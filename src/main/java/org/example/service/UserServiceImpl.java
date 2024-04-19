package org.example.service;


import org.example.Data;
import org.example.entity.Users;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Override
    public boolean registration(Users user) {
        Optional<Users> usersOptional = Optional.ofNullable(user);
        if (usersOptional.isPresent()){
            Users userAccount = new Users(
                    Data.users.size()+1,
                    usersOptional.get().getUsername(),
                    usersOptional.get().getEmailAddress(),
                    usersOptional.get().getPassword());
            Data.users.add(userAccount);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUser(String username, String password) {
        Optional<Users> account = Data.users.stream()
                .filter(users -> users.getUsername().equals(username) && users.getPassword().equals(password))
                .findFirst();

        if (account.isPresent()){
            Data.tempUser.setId(account.get().getId());
            Data.tempUser.setUsername(account.get().getUsername());
            Data.tempUser.setPassword(account.get().getPassword());
            Data.tempUser.setEmailAddress(account.get().getEmailAddress());
            return true;
        }

        return false;

    }
}
