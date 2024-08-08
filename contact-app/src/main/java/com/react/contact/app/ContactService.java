package com.react.contact.app;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class ContactService {
    private final ContactRepository contactRepository;

    public Page<Contact> getAllContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    public Contact getContact(String Id) {
        return contactRepository.findById(Id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(String id) {

    }

    public String uploadPhoto(String id,MultipartFile image){
        log.info("photo is saved in contact id {}",id);
        var contact = getContact(id);
        var photoUrl = photoFunction.apply(id,image);
        contact.setPhotoUrl(photoUrl);
        contactRepository.save(contact);
        return photoUrl;
    }

    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(f -> f.contains("."))
            .map(name -> "." + name.substring(filename.lastIndexOf(".") + 1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> photoFunction = (id, image) -> {
        var filename = id + fileExtension.apply(image.getOriginalFilename());
        try {
            var location = Paths.get(Constant.PHOTO_DIRECTORY).toAbsolutePath().normalize();
            if (!Files.exists(location)) {
                Files.createDirectories(location);
            }
            Files.copy(image.getInputStream(), location.resolve(filename), REPLACE_EXISTING);
            return ServletUriComponentsBuilder.fromCurrentContextPath().path("/contact/images/" + filename).toUriString();
        } catch (Exception exception) {
            throw new RuntimeException("image cannot save");
        }
    };
}
