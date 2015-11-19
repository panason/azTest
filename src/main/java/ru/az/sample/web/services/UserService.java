package ru.az.sample.web.services;

import ru.az.sample.model.User;
import ru.az.sample.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDAO userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
