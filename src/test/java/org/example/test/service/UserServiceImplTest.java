package org.example.test.service;

import org.example.Data;
import org.example.entity.Users;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;


class UserServiceImplTest {
    private UserService userService;
    private Data data;
    @BeforeEach
    void init(){
        data = new Data();
        data.init();
        this.userService = new UserServiceImpl();
    }
    @Test
    @DisplayName("Registrasi Apabila Data Ada")
    void registrationUserDetect() {
        Users user = new Users("ahmad","ahmad@gmail.com","ahmad123");
        Assertions.assertEquals(true,userService.registration(user));
    }

    @Test
    @DisplayName("Registrasi Apabila Data Tidak Ada")
    void registrationUserNotDetect() {
        Assertions.assertEquals(false,userService.registration(null));
    }

    @Test
    @DisplayName("Akun Ditemukan")
    void checkUser() {
        Assertions.assertEquals(true,userService.checkUser("nugrah","nugrah123"));
    }

    @Test
    @DisplayName("Akun Tidak Ditemukan")
    void checkUserFailed(){
        Assertions.assertEquals(false,userService.checkUser("mamat","mamat123"));
    }
}