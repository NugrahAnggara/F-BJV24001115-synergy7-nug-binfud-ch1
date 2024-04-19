package org.example.controller;

import org.example.entity.Users;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.example.util.exception.DataException;
import org.example.util.exception.InputException;
import org.example.view.ProductView;
import org.example.view.UserView;

public class UserController {
   private UserView userView = new UserView();
   private ProductView productView = new ProductView();
    public void selectedMenu(int selectMenu) throws InputException{
        switch (selectMenu){
            case 1 :
                userView.login();
                break;
            case 2:
                userView.registrasi();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                throw new InputException("Pastikan Menu Yang Dipilih Sesuai");
        }
    }


    public void registrationUser(Users users){
        UserService userService = new UserServiceImpl();
        userService.registration(users);
        productView.mainMenu();
    }


    public void loginUser(String username,String password) throws DataException{
        UserService userService = new UserServiceImpl();
        boolean isValid = userService.checkUser(username,password);

        if(isValid){
            ProductView productView = new ProductView();
            productView.mainMenu();
        }else{
            throw new DataException("Data User Tidak Tersedia");
        }
    }
}
