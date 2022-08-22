package com.platzi.springboot.fundamentos.service;

import com.platzi.springboot.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    Log LOG = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveTransactionalUsers(List<User> users) {
        users.stream()
                .peek(user -> LOG.info(user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByPage(int page, int pageSize) {
        Map<String, String> structure = new HashMap<>();
        Optional<String> resutl = Optional.of(structure.get("s").toString());

        return userRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public User update(User newUser, Long id) {
        return userRepository.findById(id).map(
                user -> {
                    user.setEmail(newUser.getEmail());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }
        ).get();
    }
}
