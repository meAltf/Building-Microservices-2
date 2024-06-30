package com.alataf.springboot.mapper;

import com.alataf.springboot.dto.UserDTO;
import com.alataf.springboot.entity.User;

public class userMapper {

    // convert JPA entity to UserDTO
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    // convert UserDTO to User JPA Entity
    public static User mapToUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
