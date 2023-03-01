package com.demo.onlinelibrary.repository;

import com.demo.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByMail(String mail);
}
