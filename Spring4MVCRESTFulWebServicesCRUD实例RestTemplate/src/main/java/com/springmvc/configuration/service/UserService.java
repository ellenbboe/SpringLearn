package com.springmvc.configuration.service;

import com.springmvc.configuration.model.User;

import java.util.List;

public interface UserService {
    User findById(long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUser();
    void deleteAllUser();
    public boolean idUserExist(User user);
}
