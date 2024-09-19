package com.swingapplication.foofast.controllers;

import com.swingapplication.foofast.daos.userDAO.IUserDAO;
import com.swingapplication.foofast.daos.userDAO.UserDAO;
import com.swingapplication.foofast.dtos.responses.UserResponse;
import com.swingapplication.foofast.models.User;

import java.util.Optional;

public class LoginController {

    private IUserDAO userDAO;

    public LoginController() {
        userDAO = new UserDAO();
    }

    public Boolean login(String username, String password) {

//        Optional<User> userFound = userDAO.findByUsername(username);
//
//        userFound.ifPresent(user -> {throw new RuntimeException("Username da ton tai");});

        // logic kiem tra password

        // UserDAo -> User : chua noi dung nhay nham
        // UserController -> UserResponse : khong chua noi dung nhay cam
        // passowrd = userfound.getpassword;

        // thuat toan bcript giai ma mat khaku

        return true;

    }
}
