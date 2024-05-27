package mk.finki.ukim.webappgymspringboot.Service;

import mk.finki.ukim.webappgymspringboot.Model.User;

import java.time.LocalDate;
import java.util.List;

public interface AuthenticationService {
    User login(String username, String password);

    User register(String username, String password, String repeatPassword, String name, String surname);

}
