package com.alataf.springboot.service;

import com.alataf.springboot.dto.UserDTO;
import com.alataf.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long userId);
}
