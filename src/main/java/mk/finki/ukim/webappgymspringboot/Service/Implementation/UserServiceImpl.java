package mk.finki.ukim.webappgymspringboot.Service.Implementation;

import mk.finki.ukim.webappgymspringboot.Model.User;
import mk.finki.ukim.webappgymspringboot.Repository.UserRepository;
import mk.finki.ukim.webappgymspringboot.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {

        User user = new User(username,name,surname,passwordEncoder.encode(password));


       return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) this.userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
    }
}
