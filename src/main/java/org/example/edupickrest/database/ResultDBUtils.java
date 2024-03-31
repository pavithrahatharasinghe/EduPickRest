package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;
import org.example.edupickrest.models.Results;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static boolean addResult(Results results) throws SQLException {
        String query = "INSERT INTO results (userId, assignmentId, marks, resultDate) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, results.getUserId());
        preparedStatement.setInt(2, results.getAssignmentId());
        preparedStatement.setInt(3, results.getMarks());
        preparedStatement.setString(4, results.getResultDate());
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<Results> getResultsByAssignmentId(int assignmentId) throws SQLException {
        String query = "SELECT * FROM results WHERE assignmentId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, assignmentId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Results> results = new ArrayList<>();
        while (resultSet.next()) {
            Results result = new Results();
            result.setResultId(resultSet.getInt("resultId"));
            result.setUserId(resultSet.getInt("userId"));
            result.setAssignmentId(resultSet.getInt("assignmentId"));
            result.setMarks(resultSet.getInt("marks"));
            result.setResultDate(resultSet.getString("resultDate"));
            results.add(result);
        }
        return results;
    }

    public static boolean updateResult(int resultId, Results results) throws SQLException {
        String query = "UPDATE results SET userId = ?, assignmentId = ?, marks = ?, resultDate = ? WHERE resultId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, results.getUserId());
        preparedStatement.setInt(2, results.getAssignmentId());
        preparedStatement.setInt(3, results.getMarks());
        preparedStatement.setString(4, results.getResultDate());
        preparedStatement.setInt(5, resultId);
        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean deleteResult(int resultId) throws SQLException {
        String query = "DELETE FROM results WHERE resultId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, resultId);
        return preparedStatement.executeUpdate() > 0;
    }
}
