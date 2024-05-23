package mk.finki.ukim.webappgymspringboot.Repository;

import mk.finki.ukim.webappgymspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);
}
