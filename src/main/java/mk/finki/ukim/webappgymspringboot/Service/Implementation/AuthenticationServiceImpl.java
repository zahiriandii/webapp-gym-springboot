package mk.finki.ukim.webappgymspringboot.Service.Implementation;

import mk.finki.ukim.webappgymspringboot.Model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.webappgymspringboot.Model.User;
import mk.finki.ukim.webappgymspringboot.Repository.UserRepository;
import mk.finki.ukim.webappgymspringboot.Service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password)  {
        if (username != null && password !=null||username.isEmpty() && password.isEmpty())
        {
           // throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
