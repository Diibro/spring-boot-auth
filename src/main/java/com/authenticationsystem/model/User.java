package com.authenticationsystem.model;

import java.util.UUID;

import com.authenticationsystem.enums.EUserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
     @Id
     @Column(name="user_id")
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID userId;

     @Column(name = "user_name", nullable = false, unique = true)
     private String userName;

     @Column(name = "user_email", nullable = false, unique = true)
     private String userEmail;

     @Column(name = "user_password", nullable = false, unique = true)
     private String userPassword;

     @Column(name = "age")
     private int age;

     @Column(name="user_type", nullable = false)
     private EUserType userType;

     public User(String userName, String userEmail, String userPassword, int age, EUserType userType) {
          this.userName = userName;
          this.userEmail = userEmail;
          this.userPassword = userPassword;
          this.age = age;
          this.userType = userType;
     }

     public User(String userName, String userEmail, String userPassword) {
          this.userName = userName;
          this.userEmail = userEmail;
          this.userPassword = userPassword;
     }

     

     
}
