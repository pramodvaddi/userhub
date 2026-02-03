package com.pramodvaddiraju.userhub.backend.service;

import com.pramodvaddiraju.userhub.backend.dto.UserRequestDTO;
import com.pramodvaddiraju.userhub.backend.dto.UserResponseDTO;
import com.pramodvaddiraju.userhub.backend.entity.User;
import com.pramodvaddiraju.userhub.backend.exception.ResourceNotFoundException;
import com.pramodvaddiraju.userhub.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        // Request to entity
        User user = modelMapper.map(userRequestDTO, User.class);
        // Entity to database
        User savedUser = userRepository.save(user);

        // Entity to response
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    @Override
    public Page<UserResponseDTO> getAllUsers(Pageable pageable) {

        Page<User> usersPage = userRepository.findAll(pageable);
        // Map each entity

        return usersPage.map(user -> modelMapper.map(user, UserResponseDTO.class));
    }

    @Override
    public UserResponseDTO getUserById(int id) {

       User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found with id: " + id));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void deleteUserByid(int id) {
        userRepository.deleteById(id);

    }
}
