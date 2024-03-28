package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

import org.example.edupickrest.models.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ResultDBUtils {

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

    //Result DBUtils methods

    public static List<Result> getAllResults() {
        List<Result> results = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM results");
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static Result getResultById(int resultId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE resultID = ?");
            preparedStatement.setInt(1, resultId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addResult(Result result) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO results (userID, courseID, marks, resultDate) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, result.getUserID());
            preparedStatement.setInt(2, result.getCourseID());
            preparedStatement.setDouble(3, result.getMarks());
            preparedStatement.setString(4, result.getResultDate());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateResult(Result result) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE results SET userID = ?, courseID = ?, marks = ?, resultDate = ? WHERE resultID = ?");
            preparedStatement.setInt(1, result.getUserID());
            preparedStatement.setInt(2, result.getCourseID());
            preparedStatement.setDouble(3, result.getMarks());
            preparedStatement.setString(4, result.getResultDate());
            preparedStatement.setInt(5, result.getResultID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteResult(int resultId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM results WHERE resultID = ?");
            preparedStatement.setInt(1, resultId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Result> getResultsByCourse(int courseId) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE courseID = ?");
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<Result> getResultsByUser(int userId) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE userID = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<Result> getResultsByUserAndCourse(int userId, int courseId) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE userID = ? AND courseID = ?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<Result> getResultsByDate(String date) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE resultDate = ?");
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<Result> getResultsByMarks(double marks) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE marks = ?");
            preparedStatement.setDouble(1, marks);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<Result> getResultsByMarksAndCourse(double marks, int courseId) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE marks = ? AND courseID = ?");
            preparedStatement.setDouble(1, marks);
            preparedStatement.setInt(2, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<Result> getResultsByMarksAndUser(double marks, int userId) {
        List<Result> results = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM results WHERE marks = ? AND userID = ?");
            preparedStatement.setDouble(1, marks);
            preparedStatement.setInt(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(new Result(resultSet.getInt("resultID"), resultSet.getInt("userID"), resultSet.getInt("courseID"), resultSet.getDouble("marks"), resultSet.getString("resultDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    //Result DBUtils methods with return types
    // getAllResults() -> List<Result>, getResultById(int resultId) -> Result, getResultsByCourse(int courseId) -> List<Result>, getResultsByUser(int userId) -> List<Result>, getResultsByUserAndCourse(int userId, int courseId) -> List<Result>, getResultsByDate(String date) -> List<Result>, getResultsByMarks(double marks) -> List<Result>, getResultsByMarksAndCourse(double marks, int courseId) -> List<Result>, getResultsByMarksAndUser(double marks, int userId) -> List<Result>, addResult(Result result) -> boolean, updateResult(Result result) -> boolean, deleteResult(int resultId) -> boolean

    //Result Variables with data types
    // resultID -> int, userID -> int, courseID -> int, marks -> double, resultDate -> String
}
