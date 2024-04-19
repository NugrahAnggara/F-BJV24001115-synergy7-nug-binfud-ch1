package org.example.view;

import lombok.experimental.Accessors;
import org.example.controller.UserController;
import org.example.entity.Users;
import org.example.util.exception.DataException;
import org.example.util.exception.InputException;

import java.util.Scanner;

@Accessors(chain = true)
public class UserView {
    private Scanner scanner = new Scanner(System.in);

    public void menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Apakah Sudah Pernah Mendaftar?\n")
                .append("1. Sudah\n")
                .append("2. Belum\n")
                .append("3. Keluar Aplikasi");

        System.out.println(stringBuilder);
        System.out.print("=>");
        int selectedMenu = scanner.nextInt();

        UserController userCtrl = new UserController();
        try {
            userCtrl.selectedMenu(selectedMenu);
        } catch (InputException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void registrasi(){
        System.out.println("Pastikan Mengisi Data Secara Keseluruhan");
        System.out.print("Username : ");
        String username = scanner.next();
        System.out.print("Email Address : ");
        String email = scanner.next();
        System.out.print("Password");
        String password = scanner.next();
        Users user = new Users(username,email,password);
        UserController userCtrl = new UserController();
        userCtrl.registrationUser(user);
    }

    public void login(){
        System.out.print("Silahkan Masukkan Username : ");
        String username = scanner.next();
        System.out.print("Silahkan Masukkan Password : ");
        String password = scanner.next();
        UserController usrCtrl = new UserController();
        try {
            usrCtrl.loginUser(username,password);
        } catch (DataException e) {
            System.out.println(e.getMessage() + "\n");
            menu();
        }
    }
}
