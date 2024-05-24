package mk.finki.ukim.webappgymspringboot.Repository;

import mk.finki.ukim.webappgymspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsernameAndPassword(String username,String password);

    Optional<User> findByUsername(String username);
}
