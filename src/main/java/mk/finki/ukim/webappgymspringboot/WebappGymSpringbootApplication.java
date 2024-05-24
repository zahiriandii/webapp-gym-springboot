package mk.finki.ukim.webappgymspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebappGymSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappGymSpringbootApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder ()
    {
        return new BCryptPasswordEncoder();
    }

}
