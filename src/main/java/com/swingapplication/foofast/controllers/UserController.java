package com.swingapplication.foofast.controllers;

import com.swingapplication.foofast.daos.userDAO.IUserDAO;
import com.swingapplication.foofast.daos.userDAO.UserDAO;
import com.swingapplication.foofast.dtos.responses.ListUserResponse;
import com.swingapplication.foofast.dtos.responses.UserResponse;
import com.swingapplication.foofast.mappers.UserMapper;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;


public class UserController {

    private final IUserDAO userDAO;
    private final UserMapper userMapper;

    public UserController() {
        this.userDAO = new UserDAO();
        userMapper = UserMapper.getInstance();
    }

    public ListUserResponse getAllUsers(String key, int pageSize, int pageNumber, String fieldSort, String sorter) {
        int totalUsers = userDAO.countUsersByKey(key);
        int totalPages = (int) Math.ceil((double) totalUsers / pageSize);

        return ListUserResponse.builder()
                .totalPages(totalPages)
                .userResponses(userDAO.findAllByKey(key, pageSize, pageNumber, fieldSort, sorter)
                        .stream()
                        .map(userMapper::mapToUserResponse)
                        .collect(Collectors.toList()))
                .build();
        // In case no elements are found, return an empty list
    }
}
