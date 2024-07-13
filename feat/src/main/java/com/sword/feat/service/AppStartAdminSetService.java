package com.sword.feat.service;

import com.sword.feat.model.ROLE;
import com.sword.feat.model.User;
import com.sword.feat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AppStartAdminSetService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener
    public void createAdmin(ContextRefreshedEvent event)
    {
        Optional<User> user = userRepository.findByName("admin");
        if(user.isEmpty())
        {
            var admin = User.builder()
                    .name("admin")
                    .password(passwordEncoder.encode("admin"))
                    .role(ROLE.ADMIN)
                    .build();
            userRepository.save(admin);
        }
    }
}
