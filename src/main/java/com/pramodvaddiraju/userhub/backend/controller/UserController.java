package com.pramodvaddiraju.userhub.backend.controller;

import com.pramodvaddiraju.userhub.backend.dto.UserRequestDTO;
import com.pramodvaddiraju.userhub.backend.dto.UserResponseDTO;
import com.pramodvaddiraju.userhub.backend.entity.User;
import com.pramodvaddiraju.userhub.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO response = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<Page<UserResponseDTO>> getAllUsers(Pageable pageable){
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponseDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }
}
