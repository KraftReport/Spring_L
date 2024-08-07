package kraft.book.code.repository;

import kraft.book.code.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser,Long> {

    Optional<ApplicationUser> findByEmail(String email);
}
