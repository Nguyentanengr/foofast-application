package com.swingapplication.foofast.daos.userDAO;

import com.swingapplication.foofast.daos.IBaseDAO;
import com.swingapplication.foofast.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO extends IBaseDAO<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findAllByKey(String key, int pageSize, int pageNumber, String fieldSort, String sorter);

    int countUsersByKey(String key);
}
