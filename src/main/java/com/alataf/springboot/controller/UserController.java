package com.alataf.springboot.controller;

import com.alataf.springboot.dto.UserDTO;
import com.alataf.springboot.entity.User;
import com.alataf.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(value = "id") Long userId) {
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // build all get user REST API
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    // build Update user REST API
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user) {
        // if you're going to pass 'id' also in requestBody the no need to 'setId' for user, you can skip..
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // build Delete user REST API
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

}
