package com.pingwit.part_41.repository;

import com.pingwit.part_41.entity.User;
import com.pingwit.part_41.service.DatabaseConnectorService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final DatabaseConnectorService connectorService;

    public UserRepository(DatabaseConnectorService connectorService) {
        this.connectorService = connectorService;
    }

    public List<User> findAll() {
        try (Connection connection = connectorService.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users order by id");

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setRating(rs.getDouble("rating"));
                user.setPayment(rs.getDouble("payment"));
                user.setActive(rs.getBoolean("active"));
                user.setCountry(rs.getString("country"));
                user.setCurrency(rs.getString("currency"));
                user.setBio(rs.getString("bio"));

                users.add(user);
            }

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
