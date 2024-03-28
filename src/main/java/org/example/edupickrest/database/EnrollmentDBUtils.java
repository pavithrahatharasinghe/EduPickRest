package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    // Fetch all enrollments
    public static List<Enrollment> getAllEnrollments() throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    // Fetch enrollment by ID
    public static Enrollment getEnrollmentById(int enrollmentId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE EnrollmentID = ?");
        statement.setInt(1, enrollmentId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
        }
        return null;
    }

    // Add enrollment
    public static boolean addEnrollment(Enrollment enrollment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Enrollments (UserID, CourseID, EnrollmentDate, CompletionDate, CompletionStatus) VALUES (?, ?, ?, ?, ?)");
        statement.setInt(1, enrollment.getUserID());
        statement.setInt(2, enrollment.getCourseID());
        statement.setDate(3, (Date) enrollment.getEnrollmentDate());
        statement.setDate(4, (Date) enrollment.getCompletionDate());
        statement.setInt(5, enrollment.getCompletionStatus());

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    // Update enrollment
    public static boolean updateEnrollment(Enrollment enrollment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Enrollments SET UserID = ?, CourseID = ?, EnrollmentDate = ?, CompletionDate = ?, CompletionStatus = ? WHERE EnrollmentID = ?");
        statement.setInt(1, enrollment.getUserID());
        statement.setInt(2, enrollment.getCourseID());
        statement.setDate(3, (Date) enrollment.getEnrollmentDate());
        statement.setDate(4, (Date) enrollment.getCompletionDate());
        statement.setInt(5, enrollment.getCompletionStatus());
        statement.setInt(6, enrollment.getEnrollmentID());

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    // Delete enrollment
    public static boolean deleteEnrollment(int enrollmentId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Enrollments WHERE EnrollmentID = ?");
        statement.setInt(1, enrollmentId);

        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }

    // Fetch enrollments by user ID
    public static List<Enrollment> getEnrollmentsByUserId(int userId) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE UserID = ?");
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    // Fetch enrollments by course ID
    public static List<Enrollment> getEnrollmentsByCourseId(int courseId) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE CourseID = ?");
        statement.setInt(1, courseId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    // Fetch enrollments by completion status




    // Fetch enrollments by course ID and completion status
    public static List<Enrollment> getEnrollmentsByCourseIdAndCompletionStatus(int courseId, int completionStatus) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE CourseID = ? AND CompletionStatus = ?");
        statement.setInt(1, courseId);
        statement.setInt(2, completionStatus);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    // Fetch enrollments by user ID, course ID, and completion status

    public static List<Enrollment> getEnrollmentsByUserIdCourseIdAndCompletionStatus(int userId, int courseId, int completionStatus) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE UserID = ? AND CourseID = ? AND CompletionStatus = ?");
        statement.setInt(1, userId);
        statement.setInt(2, courseId);
        statement.setInt(3, completionStatus);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    // Fetch enrollments by user ID and course ID
    public static List<Enrollment> getEnrollmentsByUserIdAndCourseId(int userId, int courseId) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE UserID = ? AND CourseID = ?");
        statement.setInt(1, userId);
        statement.setInt(2, courseId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }


    // Fetch enrollments by completion status
    public static List<Enrollment> getEnrollmentsByCompletionStatus(int completionStatus) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Enrollments WHERE CompletionStatus = ?");
        statement.setInt(1, completionStatus);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Enrollment enrollment = new Enrollment(
                    resultSet.getInt("EnrollmentID"),
                    resultSet.getInt("UserID"),
                    resultSet.getInt("CourseID"),
                    resultSet.getDate("EnrollmentDate"),
                    resultSet.getDate("CompletionDate"),
                    resultSet.getInt("CompletionStatus")
            );
            enrollments.add(enrollment);
        }
        return enrollments;
    }

    // Fetch enrollments by user ID and completion status


    //DBUtils methods with parameters and response types
    //getEnrollmentById(int enrollmentId) - Enrollment, addEnrollment(Enrollment enrollment) - boolean, updateEnrollment(Enrollment enrollment) - boolean, deleteEnrollment(int enrollmentId) - boolean, getEnrollmentsByUserId(int userId) - List<Enrollment>, getEnrollmentsByCourseId(int courseId) - List<Enrollment>, getEnrollmentsByCompletionStatus(String status) - List<Enrollment>, getEnrollmentsByUserIdAndCompletionStatus(int userId, String status) - List<Enrollment>, getEnrollmentsByCourseIdAndCompletionStatus(int courseId, String status) - List<Enrollment>, getEnrollmentsByUserIdCourseIdAndCompletionStatus(int userId, int courseId, String status) - List<Enrollment>, getEnrollmentsByUserIdAndCourseId(int userId, int courseId) - List<Enrollment>


    //Class variables with data types
    //enrollmentID - int, userID - int, courseID - int, enrollmentDate - Date, completionDate - Date, completionStatus - int

}
