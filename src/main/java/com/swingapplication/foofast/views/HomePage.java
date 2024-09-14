package com.swingapplication.foofast.views;

import com.swingapplication.foofast.controllers.UserController;
import com.swingapplication.foofast.dtos.responses.ListUserResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomePage {

    private static final UserController userController = new UserController();

    private static void actionEventListener() {
        displayListUser(userController.getAllUsers("", 0, 0, "", ""));
    }

    private static void displayListUser(ListUserResponse users) {
        log.info(users);
    }

    // Giả lập cho view
    public static void main(String[] args) {
        actionEventListener();
    }

}
