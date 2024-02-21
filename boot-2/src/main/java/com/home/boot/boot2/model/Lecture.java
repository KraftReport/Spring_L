package com.home.boot.boot2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Lecture extends Base {

    private String name;
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resources resources;
}
