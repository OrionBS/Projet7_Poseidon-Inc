package fr.orionbs.services.impl;

import fr.orionbs.models.User;
import fr.orionbs.repositories.UserRepository;
import fr.orionbs.services.AdminInit;

import javax.annotation.PostConstruct;

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
            User admin = new User(null, "admin", "adminPassword", "Admin", "ADMIN");
            userRepository.save(admin);
        }
    }
}
