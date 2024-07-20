package com.jwt.demo.repository;

import com.jwt.demo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    @Query(value = """ 
            SELECT t FROM Token t INNER JOIN User u
            ON t.user.id = u.id
            WHERE u.id = :id AND (t.expired = false OR t.revoked = false)
            """)
    List<Token> findByUserId(Long id);

    @Query("SELECT t FROM Token t WHERE t.token = :token")
    Optional<Token> findByToken(String token);
}
