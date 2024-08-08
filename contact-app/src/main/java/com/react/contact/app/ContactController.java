package com.react.contact.app;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.react.contact.app.Constant.PHOTO_DIRECTORY;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        var created = contactService.createContact(contact);
        return ResponseEntity.created(URI.create("/contact/"+created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<Page<Contact>> GetAllContacts(@RequestParam(name = "page",defaultValue = "0")int page,
                                                        @RequestParam(name = "size",defaultValue = "10")int size){
        return ResponseEntity.ok().body(contactService.getAllContacts(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> GetContact(@PathVariable("id")String id){
        return ResponseEntity.ok(contactService.getContact(id));
    }

    @PostMapping("/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam("id")String id,
                                              @RequestParam("image")MultipartFile image){
        return ResponseEntity.ok(contactService.uploadPhoto(id,image));
    }

    @GetMapping(path = "/images/{filename}",produces = {IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public byte[] getPhoto(@PathVariable("filename")String filename) throws IOException {
        return Files.readAllBytes(Paths.get(PHOTO_DIRECTORY+filename));
    }


}
