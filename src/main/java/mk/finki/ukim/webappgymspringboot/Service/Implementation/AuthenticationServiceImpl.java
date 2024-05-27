package mk.finki.ukim.webappgymspringboot.Service.Implementation;

import mk.finki.ukim.webappgymspringboot.Model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.webappgymspringboot.Model.Exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.webappgymspringboot.Model.Exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.webappgymspringboot.Model.User;
import mk.finki.ukim.webappgymspringboot.Repository.UserRepository;
import mk.finki.ukim.webappgymspringboot.Service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private boolean credentialsInvalid(String username, String password) {
        return username == null || password == null || username.isEmpty() || password.isEmpty();
    }
    @Override
    public User login(String username, String password)  {
        if (credentialsInvalid(username,password))
        {
            throw new InvalidArgumentsException();
        }
        return this.userRepository.findByUsernameAndPassword(username,password)
                .orElseThrow(()->new InvalidUserCredentialsException());
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if(credentialsInvalid(username,password)){
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        User user=new User(username,name,surname,password);
        return  this.userRepository.save(user);
    }



}
