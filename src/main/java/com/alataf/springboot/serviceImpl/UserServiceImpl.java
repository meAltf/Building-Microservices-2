package com.alataf.springboot.serviceImpl;

import com.alataf.springboot.entity.User;
import com.alataf.springboot.repository.UserRepository;
import com.alataf.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userById = userRepository.findById(userId);
        return userById.get();
    }
}
