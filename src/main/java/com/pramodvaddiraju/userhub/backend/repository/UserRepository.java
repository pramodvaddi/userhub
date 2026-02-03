package com.pramodvaddiraju.userhub.backend.repository;

import com.pramodvaddiraju.userhub.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
