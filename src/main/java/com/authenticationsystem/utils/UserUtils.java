package com.authenticationsystem.utils;

import java.lang.reflect.Field;

import com.authenticationsystem.model.User;

public class UserUtils {
     public static User copyForUpate(User updateUser, User originalUser){
          if (updateUser == null || originalUser == null) {
               throw new IllegalArgumentException("Both updateUser and originalUser must not be null");
          }

          Class<?> clazz = updateUser.getClass();

          for(Field field: clazz.getDeclaredFields()){
               field.setAccessible(true);
               try{
                    Object value = field.get(updateUser);
                    if(value != null){
                         field.set(originalUser, value);
                    }
               }catch(IllegalAccessException e){
                    e.printStackTrace();
               }
          }

          return originalUser;

     }
}
