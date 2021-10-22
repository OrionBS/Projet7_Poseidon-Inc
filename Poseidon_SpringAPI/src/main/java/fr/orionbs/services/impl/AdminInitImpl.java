package fr.orionbs.services.impl;

import fr.orionbs.models.User;
import fr.orionbs.repositories.UserRepository;
import fr.orionbs.services.AdminInit;
import fr.orionbs.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class AdminInitImpl implements AdminInit {

    private final UserRepository userRepository;

    public AdminInitImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @PostConstruct
    public void postContruct() {
        User isPresent = userRepository.findByUsername("admin");
        if (isPresent == null) {
            log.info("Admin added");
            User admin = new User(null, "admin", new BCryptPasswordEncoder().encode("adminPassword"), "Admin", "ADMIN");
            userRepository.save(admin);
        } else {
            log.info("Admin already present.");
        }
    }
}
