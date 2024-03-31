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

      public static boolean addAssignment(Assignment assignment) throws java.sql.SQLException {
            String query = "INSERT INTO assignments (moduleID, courseID, assignmentName, assignmentDescription, assignmentURL, assignmentType, assignmentStatus, dueDateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignment.getModuleID());
            preparedStatement.setInt(2, assignment.getCourseID());
            preparedStatement.setString(3, assignment.getAssignmentName());
            preparedStatement.setString(4, assignment.getAssignmentDescription());
            preparedStatement.setString(5, assignment.getAssignmentURL());
            preparedStatement.setString(6, assignment.getAssignmentType());
            preparedStatement.setString(7, assignment.getAssignmentStatus());
            preparedStatement.setString(8, assignment.getDueDateTime());
            return preparedStatement.executeUpdate() > 0;
        }

        public static List<Assignment> getAllAssignments() throws SQLException {
            String query = "SELECT * FROM assignments";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Assignment> assignments = new ArrayList<>();
            while (resultSet.next()) {
                Assignment assignment = new Assignment();
                assignment.setAssignmentID(resultSet.getInt("assignmentID"));
                assignment.setModuleID(resultSet.getInt("moduleID"));
                assignment.setCourseID(resultSet.getInt("courseID"));
                assignment.setAssignmentName(resultSet.getString("assignmentName"));
                assignment.setAssignmentDescription(resultSet.getString("assignmentDescription"));
                assignment.setAssignmentURL(resultSet.getString("assignmentURL"));
                assignment.setAssignmentType(resultSet.getString("assignmentType"));
                assignment.setAssignmentStatus(resultSet.getString("assignmentStatus"));
                assignment.setDueDateTime(resultSet.getString("dueDateTime"));
                assignments.add(assignment);
            }
            return assignments;
        }

        public static boolean updateAssignment(int assignmentID, Assignment assignment) throws SQLException {
            String query = "UPDATE assignments SET moduleID = ?, courseID = ?, assignmentName = ?, assignmentDescription = ?, assignmentURL = ?, assignmentType = ?, assignmentStatus = ?, dueDateTime = ? WHERE assignmentID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignment.getModuleID());
            preparedStatement.setInt(2, assignment.getCourseID());
            preparedStatement.setString(3, assignment.getAssignmentName());
            preparedStatement.setString(4, assignment.getAssignmentDescription());
            preparedStatement.setString(5, assignment.getAssignmentURL());
            preparedStatement.setString(6, assignment.getAssignmentType());
            preparedStatement.setString(7, assignment.getAssignmentStatus());
            preparedStatement.setString(8, assignment.getDueDateTime());
            preparedStatement.setInt(9, assignmentID);
            return preparedStatement.executeUpdate() > 0;
        }

        public static boolean deleteAssignment(int assignmentID) throws SQLException {
            String query = "DELETE FROM assignments WHERE assignmentID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignmentID);
            return preparedStatement.executeUpdate() > 0;
        }

        public static List<Assignment> getCourseAssignments(int courseID) throws SQLException {
            String query = "SELECT * FROM assignments WHERE courseID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Assignment> assignments = new ArrayList<>();
            while (resultSet.next()) {
                Assignment assignment = new Assignment();
                assignment.setAssignmentID(resultSet.getInt("assignmentID"));
                assignment.setModuleID(resultSet.getInt("moduleID"));
                assignment.setCourseID(resultSet.getInt("courseID"));
                assignment.setAssignmentName(resultSet.getString("assignmentName"));
                assignment.setAssignmentDescription(resultSet.getString("assignmentDescription"));
                assignment.setAssignmentURL(resultSet.getString("assignmentURL"));
                assignment.setAssignmentType(resultSet.getString("assignmentType"));
                assignment.setAssignmentStatus(resultSet.getString("assignmentStatus"));
                assignment.setDueDateTime(resultSet.getString("dueDateTime"));
                assignments.add(assignment);
            }
            return assignments;
        }



}
