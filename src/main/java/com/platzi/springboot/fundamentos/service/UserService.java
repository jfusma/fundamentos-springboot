package com.platzi.springboot.fundamentos.service;

import com.platzi.springboot.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    Log LOG = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveTransactionalUsers(List<User> users){
        users.stream()
                .peek(user -> LOG.info(user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
      return  userRepository.findAll();
    }
}
