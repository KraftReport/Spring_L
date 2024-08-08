package com.react.contact.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "contact")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Contact {
    @Id
    @UuidGenerator
    @Column(unique = true,updatable = false)
    private String id;
    private String name;
    private String email;
    private String title;
    private String phone;
    private String address;
    private String status;
    private String photoUrl;
}
