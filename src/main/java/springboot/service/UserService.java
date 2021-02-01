package springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import springboot.entity.User;
import springboot.entity.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

