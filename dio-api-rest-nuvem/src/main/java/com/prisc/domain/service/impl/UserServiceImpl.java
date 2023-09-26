package com.prisc.domain.service.impl;

import com.prisc.domain.model.User;
import com.prisc.domain.repository.UserRepository;
import com.prisc.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /*
    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() !=null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This user ID already exists.");
        }
        return null;
    }
    */

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
