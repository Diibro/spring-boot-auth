package com.authenticationsystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authenticationsystem.model.User;

public interface IUser extends JpaRepository<User, UUID> {
     public User findByUserEmailOrUserName(String userEmail, String userName);
}
