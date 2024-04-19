package org.example;

import org.example.view.UserView;

public class App {

    public static void main(String[] args) {
        Data initiateData = new Data();
        initiateData.init();

        UserView userView = new UserView();
        userView.menu();
    }
}
