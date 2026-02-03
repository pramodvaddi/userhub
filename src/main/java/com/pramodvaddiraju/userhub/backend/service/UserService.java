package com.pramodvaddiraju.userhub.backend.service;

import com.pramodvaddiraju.userhub.backend.dto.UserRequestDTO;
import com.pramodvaddiraju.userhub.backend.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    Page<UserResponseDTO> getAllUsers(Pageable pageable);
    UserResponseDTO getUserById(int id);
    void deleteUserByid(int id);


}
