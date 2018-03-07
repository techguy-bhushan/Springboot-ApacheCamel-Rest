package com.src;

import java.util.Collection;

public interface UserService {

    User findUser(Integer id);

    Collection<User> findUsers();

    void updateUser(User user);

    void create(User user);

    void delete(Integer id);
}
