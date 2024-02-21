package com.home.boot.boot2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        {
                @NamedQuery(
                        name = "Author.updateAge",
                        query = "update Author a set a.age = :age "
                )
        }
)
public class Author extends Base {
    @Column(name = "first_name",length = 40)
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;
    private int age;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
