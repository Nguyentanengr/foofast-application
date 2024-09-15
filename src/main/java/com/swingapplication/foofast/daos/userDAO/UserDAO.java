package com.swingapplication.foofast.daos.userDAO;


import com.swingapplication.foofast.models.User;
import com.swingapplication.foofast.utils.DatabaseUtil;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Log4j2
public class UserDAO implements IUserDAO{

    private static final String DATE_REGEX =
            "^(19|20)\\d\\d-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users;";

        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                users.add(buildUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> findAllByKey(String key, int pageSize, int pageNumber, String fieldSort, String sorter) {
        int offset = (pageNumber) * (pageSize == 0 ? 10 : pageSize);
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        if (!key.isEmpty()) {
            sql += " WHERE (`first_name` LIKE '%" + key + "%' OR `last_name` LIKE '%" + key + "%')";
        }
        if (!fieldSort.isEmpty() && !sorter.isEmpty()) {
            sql += " ORDER BY " + fieldSort + " " + sorter;
        }
        sql += " LIMIT " + (pageSize == 0 ? 10 : pageSize) + " OFFSET " + (offset) + ";";


        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            log.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(buildUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


    @Override
    public Optional<User> findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?;";
        Optional<User> user = Optional.empty();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = Optional.of(buildUserFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User save(User entity) {
        String insertSql = """
             INSERT INTO users (`first_name`, `last_name`, `day_of_birth`, `username`, `password`)
             VALUES (?, ?, ?, ?, ?);
        """;

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setDate(3, Date.valueOf(entity.getDayOfBirth()));
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getPassword());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                entity.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public User update(User entity) {
        String sql = """
             UPDATE users SET `first_name` = ?, `last_name` = ? , `day_of_birth` = ? , `username` = ? , `password` = ?
             WHERE id = ?;
        """;

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setDate(3, Date.valueOf(entity.getDayOfBirth()));
            preparedStatement.setString(4, entity.getUsername());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.setLong(6, entity.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public User setActiveOrInactive(Long id) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?;";
        Optional<User> user = Optional.empty();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = Optional.of(buildUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public int countUsersByKey(String key) {
        String sql = "SELECT COUNT(*) FROM users";

        if (!key.isEmpty()) {
            sql += " WHERE (`first_name` LIKE ? OR `last_name` LIKE ?)";
        }
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (!key.isEmpty()) {
                preparedStatement.setString(1, "%" + key + "%");
                preparedStatement.setString(2, "%" + key + "%");
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    private User buildUserFromResultSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .dayOfBirth(resultSet.getDate("day_of_birth") != null
                        ? resultSet.getDate("day_of_birth").toLocalDate()
                        : null)
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .build();
    }
}
