package com.swingapplication.foofast.views;

import com.swingapplication.foofast.controllers.UserController;
import com.swingapplication.foofast.dtos.responses.ListUserResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomePage {

    private static final UserController userController = new UserController();

    private static void actionEventListener() {
        // tham số 1: từ khóa tìm kíếm : String
        // tham số 2: số user trên 1 trang: int (giá trị 0 : mặc định là 10)
        // tham số 3: trang số n: int (giá trị 0: trang đầu tiên)
        // tham số 4: sắp xếp theo field nào: String (chọn một trong các biến thuộc tính của bảng user trong database)
        // tham số 5: sắp xếp theo tăng / giảm: String (DESC/ ASC)
        displayListUser(userController.getAllUsers("", 0, 0, "last_name", "ASC"));
    }

    private static void displayListUser(ListUserResponse users) {
        log.info(users);
    }

    // Giả lập cho view
    public static void main(String[] args) {
        actionEventListener();
    }

}
