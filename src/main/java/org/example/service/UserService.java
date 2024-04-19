package org.example.service;

import org.example.entity.Users;

public interface UserService {
    boolean registration(Users user);
    boolean checkUser(String username,String password);
}
