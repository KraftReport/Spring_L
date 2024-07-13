package com.sword.feat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "user_tbl")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
	private String password;
	@Enumerated(EnumType.STRING)
	private ROLE role;
}
