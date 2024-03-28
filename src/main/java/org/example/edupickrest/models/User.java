package org.example.edupickrest.models;


public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String username;
    private String password;
    private String email;
    private String role;
    private String status;

    // User variables with data types
    // userID : int, firstName : String, lastName : String, middleName : String, username : String, password : String, email : String, role : String, status : String

    public User() {

    }


    public User(int userID, String firstName, String lastName, String middleName, String username, String password, String email, String role, String status) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

//SQL to create the table for the User class
//CREATE TABLE User ( userID INT PRIMARY KEY, firstName VARCHAR(255), lastName VARCHAR(255), middleName VARCHAR(255), username VARCHAR(255), password VARCHAR(255), email VARCHAR(255), role VARCHAR(255) , status VARCHAR(255));

//SQL to insert a record into the User table
//INSERT INTO User (userID, firstName, lastName, middleName, username, password, email, role, status) VALUES (1, 'John', 'Doe', 'Smith', 'johndoe', 'password', 'johndoe@gmail.com', 'student', 'active');



