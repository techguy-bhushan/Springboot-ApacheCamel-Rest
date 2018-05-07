package com.src.service;

import com.src.domain.User;

import java.util.Collection;

public interface UserService {

    User findUser(Integer id);

    Collection<User> findUsers();

    void updateUser(User user);

    User create(User user);

    void delete(Integer id);

    long count();

}
