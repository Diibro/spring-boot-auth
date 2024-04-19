package com.authenticationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authenticationsystem.model.User;
import com.authenticationsystem.repository.IUser;
import com.authenticationsystem.utils.MessageReturn;
import com.authenticationsystem.utils.UserUtils;

@Service
public class UserService {
     @Autowired
     private IUser userRepo;

     public MessageReturn save(User user){
          try{
               User savedUser = userRepo.save(user);
               if(savedUser != null){
                    return new MessageReturn("Created Account successfully", true);
               }else{
                    return new MessageReturn("failed to create user account. Server error", false);
               }
          }catch(Exception e){
               e.printStackTrace();
               return new MessageReturn("Server error.", false);
          }
     }

     public MessageReturn update(User user){
          try{
               User ckUser = search(user);
               if(ckUser != null){
                    User uUser = UserUtils.copyForUpate(user, ckUser);
                    userRepo.save(uUser);
                    return new MessageReturn("updated user successfully", true);
               }else{
                    return new MessageReturn("User not Found", false);
               }
          }catch(Exception e){
               e.printStackTrace();
               return new MessageReturn("Server error.", false);
          }
     }

     public User search(User user) {
          try{
               User uFound = userRepo.findByUserEmailOrUserName(user.getUserEmail(), user.getUserName());
               return uFound;
          }catch(Exception e){
               e.printStackTrace();
               return null;
          }
     }


     public MessageReturn delete (User user ){
          try {
               User ckUser = userRepo.findByUserEmailOrUserName(user.getUserEmail(), user.getUserName());
               if(ckUser != null){
                    userRepo.delete(ckUser);
                    return new MessageReturn("Deleted user successfully", true);
               }else{
                    return new MessageReturn("Trying to delete unregistered user", false);
               }
          } catch (Exception e) {
               e.printStackTrace();
               return new MessageReturn("Failed to delete user. Server error", false);
          }
     }

     public List<User> findAll(){
          List<User> users = userRepo.findAll();
          return users;
     }
}
