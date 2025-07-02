package com.satyasolutions.smartbudget.repository;

import com.satyasolutions.smartbudget.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
