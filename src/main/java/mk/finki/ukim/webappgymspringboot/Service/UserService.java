package mk.finki.ukim.webappgymspringboot.Service;

import mk.finki.ukim.webappgymspringboot.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname);
}
