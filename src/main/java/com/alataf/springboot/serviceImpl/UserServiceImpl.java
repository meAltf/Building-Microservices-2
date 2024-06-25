package com.alataf.springboot.serviceImpl;

import com.alataf.springboot.entity.User;
import com.alataf.springboot.repository.UserRepository;
import com.alataf.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
