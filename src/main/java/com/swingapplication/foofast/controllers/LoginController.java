package com.swingapplication.foofast.controllers;

import com.swingapplication.foofast.daos.userDAO.IUserDAO;
import com.swingapplication.foofast.daos.userDAO.UserDAO;
import com.swingapplication.foofast.dtos.requests.LoginRequest;
import com.swingapplication.foofast.dtos.responses.LoginResponse;
import com.swingapplication.foofast.dtos.responses.UserResponse;
import com.swingapplication.foofast.models.User;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

public class LoginController {

    private IUserDAO userDAO;

    public LoginController() {
        userDAO = new UserDAO();
    }

    public LoginResponse login(@Valid LoginRequest loginRequest) { // bat validation

        // kiem tra username co ton tai trong database khong
        Optional<User> user = userDAO.findByUsername(loginRequest.getUsername());

       // logic kiem tra


        // neu kiem tra password dung

        return new LoginResponse()
                .builder()
                .veryfied(true)
                .build();

    }
}
