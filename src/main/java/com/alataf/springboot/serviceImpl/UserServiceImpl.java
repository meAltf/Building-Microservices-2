package com.alataf.springboot.serviceImpl;

import com.alataf.springboot.dto.UserDTO;
import com.alataf.springboot.entity.User;
import com.alataf.springboot.exception.ResourceNotFoundException;
import com.alataf.springboot.mapper.userMapper;
import com.alataf.springboot.repository.UserRepository;
import com.alataf.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        //Convert UserDTO to USER JPA Entity
        //User user = userMapper.mapToUser(userDTO);
        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepository.save(user);

        //Convert USER JPA entity to DTO
        //UserDTO savedUserDTO = userMapper.mapToUserDTO(savedUser);
        UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);

        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        //return userMapper.mapToUserDTO(user);

        return modelMapper.map(user, UserDTO.class);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
//        return userList.stream().map(userMapper::mapToUserDTO)
//                .collect(Collectors.toList());

        return userList.stream().map((user) -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
       // return userMapper.mapToUserDTO(updatedUser);

        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
