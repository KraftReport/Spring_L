package com.sword.feat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService()
    {
        var admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .authorities("admin")
                .roles("admin")
                .build();

        var member = User.builder()
                .username("member")
                .password(passwordEncoder.encode("member"))
                .authorities("user")
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(admin,member);
    }
}
