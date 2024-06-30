package com.alataf.springboot.serviceImpl;

import com.alataf.springboot.dto.UserDTO;
import com.alataf.springboot.entity.User;
import com.alataf.springboot.repository.UserRepository;
import com.alataf.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        //Convert UserDTO to USER JPA Entity
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );

        User savedUser = userRepository.save(user);

        //Convert USER JPA entity to DTO
        UserDTO savedUserDTO = new UserDTO(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );

        return savedUserDTO;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userById = userRepository.findById(userId);
        return userById.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
