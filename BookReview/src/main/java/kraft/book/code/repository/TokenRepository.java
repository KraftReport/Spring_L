package kraft.book.code.repository;

import kraft.book.code.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {

    Optional<Token> findByToken(String token);
    @Query("select t from token t inner join app_user u on t.user.id = u.id where u.id = :id and (t.expired = false or t.revoked = false)")
    List<Token> findTokenFromUserId(Long id);
}
