package mk.finki.ukim.webappgymspringboot.Service;

import mk.finki.ukim.webappgymspringboot.Model.User;

import java.util.List;

public interface AuthenticationService {
    User login(String username, String password);

    List<User> findAll();

}
