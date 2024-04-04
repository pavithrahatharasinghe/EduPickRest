package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.edupickrest.models.Course;
import org.example.edupickrest.models.Enrollment;


public class EnrollmentDBUtils {
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

    public static boolean addEnrollment(Enrollment enrollment) throws SQLException {
        String query = "INSERT INTO enrollments (userID, courseID, enrollmentDate, completionDate, completionStatus) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, enrollment.getUserID());
        preparedStatement.setInt(2, enrollment.getCourseID());
        preparedStatement.setDate(3, Date.valueOf(enrollment.getEnrollmentDate()));
        preparedStatement.setDate(4, Date.valueOf(enrollment.getCompletionDate()));
        preparedStatement.setInt(5, enrollment.getCompletionStatus());
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<Enrollment> getAllEnrollments() throws SQLException {
        String query = "SELECT * FROM enrollments";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Enrollment> courses = new ArrayList<>();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setEnrollmentID(resultSet.getInt("enrollmentID"));
            enrollment.setUserID(resultSet.getInt("userID"));
            enrollment.setCourseID(resultSet.getInt("courseID"));
            enrollment.setEnrollmentDate(String.valueOf(resultSet.getDate("enrollmentDate").toLocalDate()));
            enrollment.setCompletionDate(String.valueOf(resultSet.getDate("completionDate").toLocalDate()));
            enrollment.setCompletionStatus(resultSet.getInt("completionStatus"));
            courses.add(enrollment);
        }
        return courses;
    }

    public static List<Enrollment> getEnrollmentsByCourseId(int courseId) throws SQLException {
        String query = "SELECT * FROM enrollments WHERE courseID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, courseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Enrollment> enrollments = new ArrayList<>();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setEnrollmentID(resultSet.getInt("enrollmentID"));
            enrollment.setUserID(resultSet.getInt("userID"));
            enrollment.setCourseID(resultSet.getInt("courseID"));
            enrollment.setEnrollmentDate(String.valueOf(resultSet.getDate("enrollmentDate").toLocalDate()));
            enrollment.setCompletionDate(String.valueOf(resultSet.getDate("completionDate").toLocalDate()));
            enrollment.setCompletionStatus(resultSet.getInt("completionStatus"));
            enrollments.add(enrollment);
        }
        return enrollments;

    }

    public static boolean deleteEnrollment(int enrollmentID) throws SQLException {
        String query = "DELETE FROM enrollments WHERE enrollmentID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, enrollmentID);
        return preparedStatement.executeUpdate() > 0;
    }
}

