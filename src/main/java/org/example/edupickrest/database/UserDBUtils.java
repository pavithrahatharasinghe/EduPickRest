package org.example.edupickrest.database;

import jakarta.ws.rs.core.Response;
import org.example.edupickrest.DatabaseConnection;
import org.example.edupickrest.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// User variables with data types
// userID : int, firstName : String, lastName : String, middleName : String, username : String, password : String, email : String, role : String, status : String

public class UserDBUtils {

    private static Connection connection;

    static {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Add user
    public static boolean addUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Users (firstName, lastName, middleName, username, password, email, role, status) VALUES (?, ?, ?, ?, ?, ?, ?, 'active')");
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getMiddleName());
        statement.setString(4, user.getUsername());
        statement.setString(5, user.getPassword());
        statement.setString(6, user.getEmail());
        statement.setString(7, user.getRole());
        return statement.executeUpdate() > 0;
    }

    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("UserID"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("middleName"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("status")
            );
            users.add(user);
        }
        return users;
    }


    public static User getUserByEmailAndPassword(String email, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Email = ? AND Password = ?");
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt("UserID"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("middleName"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("status")
            );
        }
        return null;
    }

    public static List<User> getUsersByRole(String role) throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE Role = ?");
        statement.setString(1, role);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("UserID"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("middleName"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("status")
            );
            users.add(user);
        }
        return users;
    }

    public static User getUserById(int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE UserID = ?");
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt("UserID"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("middleName"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("status")
            );
        }
        return null;
    }

    public static boolean updateUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Users SET firstName = ?, lastName = ?, middleName = ?, username = ?, password = ?, email = ?, role = ?, status = ? WHERE UserID = ?");
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getMiddleName());
        statement.setString(4, user.getUsername());
        statement.setString(5, user.getPassword());
        statement.setString(6, user.getEmail());
        statement.setString(7, user.getRole());
        statement.setString(8, user.getStatus());
        statement.setInt(9, user.getUserID());
        return statement.executeUpdate() > 0;
    }

    public static boolean deleteUser(int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Users WHERE UserID = ?");
        statement.setInt(1, userId);
        return statement.executeUpdate() > 0;
    }

    //setUserStatus
    public static boolean setUserStatus(int userId, String status) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Users SET status = ? WHERE UserID = ?");
        statement.setString(1, status);
        statement.setInt(2, userId);
        return statement.executeUpdate() > 0;
    }



}


//User DBUtils methods with return type
// getAllUsers() : List<User>, getUserById(int userId) : User, addUser(User user) : boolean, updateUser(User user) : boolean, deleteUser(int userId) : boolean, getUserByUsername(String username) : User, getUserByEmail(String email) : User, getUserByUsernameAndPassword(String username, String password) : User, getUserByEmailAndPassword(String email, String password) : User

//User Variables with data types

//userID : int, firstName : String, lastName : String, middleName : String, username : String, password : String, email : String, role : String

//paylod for addUser
// {
//     "firstName": "John",
//     "lastName": "Doe",
//     "middleName": "Smith",
//     "username": "johndoe",
//     "password": "password",
//     "email": "johndoe@gmail.com",
//     "role": "student"
// }







