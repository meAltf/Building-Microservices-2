package com.alataf.springboot.service;

import com.alataf.springboot.dto.UserDTO;
import com.alataf.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
