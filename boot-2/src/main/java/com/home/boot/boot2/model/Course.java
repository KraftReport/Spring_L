package com.home.boot.boot2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course extends Base {

    private String description;
    @ManyToMany
    @JoinTable(
            name = "author_course",
            joinColumns ={ @JoinColumn(name = "course_id")},
            inverseJoinColumns = { @JoinColumn(name = "author_id")}
    )
    private List<Author> authors;
    @OneToMany(mappedBy = "course")
    List<Session> sessions;
}
