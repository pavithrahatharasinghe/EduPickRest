package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;
import org.example.edupickrest.models.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDBUtils {
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

    // Fetch all assignments
    public static List<Assignment> getAllAssignments() throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Fetch assignment by ID
    public static Assignment getAssignmentById(int assignmentId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentID = ?");
        statement.setInt(1, assignmentId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
        }
        return null;
    }

    // Add assignment
    public static boolean addAssignment(Assignment assignment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Assignments (AssignmentName, AssignmentDescription, AssignmentType, AssignmentStatus, AssignmentDueDate, AssignmentDueTime, AssignmentCourse, AssignmentModule, AssignmentFile) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, assignment.getAssignmentName());
        statement.setString(2, assignment.getAssignmentDescription());
        statement.setString(3, assignment.getAssignmentType());
        statement.setString(4, assignment.getAssignmentStatus());
        statement.setString(5, assignment.getAssignmentDueDate());
        statement.setString(6, assignment.getAssignmentDueTime());
        statement.setString(7, assignment.getAssignmentCourse());
        statement.setString(8, assignment.getAssignmentModule());
        statement.setString(9, assignment.getAssignmentFile());
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    // Update assignment

    public static boolean updateAssignment(Assignment assignment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Assignments SET AssignmentName = ?, AssignmentDescription = ?, AssignmentType = ?, AssignmentStatus = ?, AssignmentDueDate = ?, AssignmentDueTime = ?, AssignmentCourse = ?, AssignmentModule = ?, AssignmentFile = ? WHERE AssignmentID = ?");
        statement.setString(1, assignment.getAssignmentName());
        statement.setString(2, assignment.getAssignmentDescription());
        statement.setString(3, assignment.getAssignmentType());
        statement.setString(4, assignment.getAssignmentStatus());
        statement.setString(5, assignment.getAssignmentDueDate());
        statement.setString(6, assignment.getAssignmentDueTime());
        statement.setString(7, assignment.getAssignmentCourse());
        statement.setString(8, assignment.getAssignmentModule());
        statement.setString(9, assignment.getAssignmentFile());
        statement.setInt(10, assignment.getAssignmentID());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    // Delete assignment
    public static boolean deleteAssignment(int assignmentId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Assignments WHERE AssignmentID = ?");
        statement.setInt(1, assignmentId);
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }

    // Change assignment status (assuming there's a 'status' column in Assignments table)
    public static boolean changeAssignmentStatus(int assignmentId, String status) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Assignments SET AssignmentStatus = ? WHERE AssignmentID = ?");
        statement.setString(1, status);
        statement.setInt(2, assignmentId);
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    // Get assignment by course

    public static List<Assignment> getAssignmentsByCourse(int course) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentCourse = ?");
        statement.setInt(1, course);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Get assignment by module

    public static List<Assignment> getAssignmentsByModule(String module) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentModule = ?");
        statement.setString(1, module);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Get assignment by type

    public static List<Assignment> getAssignmentsByType(String type) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentType = ?");
        statement.setString(1, type);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Get assignment by status

    public static List<Assignment> getAssignmentsByStatus(String status) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentStatus = ?");
        statement.setString(1, status);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Get assignment by due date

    public static List<Assignment> getAssignmentsByDueDate(String dueDate) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentDueDate = ?");
        statement.setString(1, dueDate);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Get assignment by due time

    public static List<Assignment> getAssignmentsByDueTime(String dueTime) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentDueTime = ?");
        statement.setString(1, dueTime);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    // Get assignment by course and module

    public static List<Assignment> getAssignmentsByCourseAndModule(String course, String module) throws SQLException {
        List<Assignment> assignments = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Assignments WHERE AssignmentCourse = ? AND AssignmentModule = ?");
        statement.setString(1, course);
        statement.setString(2, module);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Assignment assignment = new Assignment(
                    resultSet.getInt("AssignmentID"),
                    resultSet.getString("AssignmentName"),
                    resultSet.getString("AssignmentDescription"),
                    resultSet.getString("AssignmentType"),
                    resultSet.getString("AssignmentStatus"),
                    resultSet.getString("AssignmentDueDate"),
                    resultSet.getString("AssignmentDueTime"),
                    resultSet.getString("AssignmentCourse"),
                    resultSet.getString("AssignmentModule"),
                    resultSet.getString("AssignmentFile")
            );
            assignments.add(assignment);
        }
        return assignments;
    }

    //Assignment Class variables
    //AssignmentID, AssignmentName, AssignmentDescription, AssignmentType, AssignmentStatus, AssignmentDueDate, AssignmentDueTime, AssignmentCourse, AssignmentModule, AssignmentFile


    //Course DBUtils methods
    //Fetch all courses, Fetch course by ID, Add course, Update course, Delete course, Fetch courses by category, Fetch courses by level, Fetch courses by language, Fetch courses by price, Fetch courses by category and level, Fetch courses by category and language, Fetch courses by category and price, Fetch courses by level and language, Fetch courses by level and price, Fetch courses by language and price
}
