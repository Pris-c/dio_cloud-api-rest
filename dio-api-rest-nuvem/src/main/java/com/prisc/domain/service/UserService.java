package com.prisc.domain.service;

import com.prisc.domain.model.User;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);
}
