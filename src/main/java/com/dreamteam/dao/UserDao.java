package com.dreamteam.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dreamteam.model.User;
import com.dreamteam.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into uzytkownik (isAdmin, haslo, email) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, user.getIsAdmin());
			preparedStatement.setString(2, user.getHaslo());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(long userId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from uzytkownik where id_uzytkownik=?");
			// Parameters start with 1
			preparedStatement.setLong(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			String command="update uzytkownik set isAdmin=? ,haslo=? ,email=? where id_uzytkownik=?";
			PreparedStatement preparedStatement = connection.prepareStatement(command);
			// Parameters start with 1

			preparedStatement.setInt(1, user.getIsAdmin());
			preparedStatement.setString(2, user.getHaslo());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setLong(4, user.getId_uzytkownik());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from uzytkownik");
			while (rs.next()) {
				User user = new User();
				user.setIsAdmin(rs.getInt("isAdmin"));
				user.setHaslo(rs.getString("haslo"));
				user.setEmail(rs.getString("email"));
				user.setId_uzytkownik(rs.getLong("id_uzytkownik"));

				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

    public User getUserById(long userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from uzytkownik where id_uzytkownik=?");
            preparedStatement.setLong(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setIsAdmin(rs.getInt("isAdmin"));
                user.setHaslo(rs.getString("haslo"));
                user.setEmail(rs.getString("email"));
                user.setId_uzytkownik(rs.getLong("id_uzytkownik"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
