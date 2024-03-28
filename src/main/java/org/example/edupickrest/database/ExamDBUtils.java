package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

import org.example.edupickrest.models.Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ExamDBUtils {

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

    // Fetch all exams

    public static List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM exams");
            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setExamID(resultSet.getInt("examID"));
                exam.setCourseID(resultSet.getInt("courseID"));
                exam.setExamName(resultSet.getString("examName"));
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setExamType(resultSet.getString("examType"));
                exam.setExamURL(resultSet.getString("examURL"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    // Fetch exam by ID

    public static Exam getExamById(int examId) {
        Exam exam = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exams WHERE examID = ?");
            preparedStatement.setInt(1, examId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exam = new Exam();
                exam.setExamID(resultSet.getInt("examID"));
                exam.setCourseID(resultSet.getInt("courseID"));
                exam.setExamName(resultSet.getString("examName"));
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setExamType(resultSet.getString("examType"));
                exam.setExamURL(resultSet.getString("examURL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exam;
    }

    // Add exam

    public static boolean addExam(Exam exam) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO exams (courseID, examName, examDate, examType, examURL) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, exam.getCourseID());
            preparedStatement.setString(2, exam.getExamName());
            preparedStatement.setDate(3, (Date) exam.getExamDate());
            preparedStatement.setString(4, exam.getExamType());
            preparedStatement.setString(5, exam.getExamURL());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update exam

    public static boolean updateExam(Exam exam) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE exams SET courseID = ?, examName = ?, examDate = ?, examType = ?, examURL = ? WHERE examID = ?");
            preparedStatement.setInt(1, exam.getCourseID());
            preparedStatement.setString(2, exam.getExamName());
            preparedStatement.setDate(3, (Date) exam.getExamDate());
            preparedStatement.setString(4, exam.getExamType());
            preparedStatement.setString(5, exam.getExamURL());
            preparedStatement.setInt(6, exam.getExamID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete exam

    public static boolean deleteExam(int examId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM exams WHERE examID = ?");
            preparedStatement.setInt(1, examId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fetch exams by course

    public static List<Exam> getExamsByCourse(int courseId) {
        List<Exam> exams = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exams WHERE courseID = ?");
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setExamID(resultSet.getInt("examID"));
                exam.setCourseID(resultSet.getInt("courseID"));
                exam.setExamName(resultSet.getString("examName"));
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setExamType(resultSet.getString("examType"));
                exam.setExamURL(resultSet.getString("examURL"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();


        }
        return exams;
    }

    // Fetch exams by type

    public static List<Exam> getExamsByType(String examType) {
        List<Exam> exams = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exams WHERE examType = ?");
            preparedStatement.setString(1, examType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setExamID(resultSet.getInt("examID"));
                exam.setCourseID(resultSet.getInt("courseID"));
                exam.setExamName(resultSet.getString("examName"));
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setExamType(resultSet.getString("examType"));
                exam.setExamURL(resultSet.getString("examURL"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    // Fetch exams by course and type

    public static List<Exam> getExamsByCourseAndType(int courseId, String examType) {
        List<Exam> exams = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exams WHERE courseID = ? AND examType = ?");
            preparedStatement.setInt(1, courseId);
            preparedStatement.setString(2, examType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Exam exam = new Exam();
                exam.setExamID(resultSet.getInt("examID"));
                exam.setCourseID(resultSet.getInt("courseID"));
                exam.setExamName(resultSet.getString("examName"));
                exam.setExamDate(resultSet.getDate("examDate"));
                exam.setExamType(resultSet.getString("examType"));
                exam.setExamURL(resultSet.getString("examURL"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    // Exam DButill classes with return types
    // getAllExams() - List<Exam>, getExamById(int examId) - Exam, getExamsByCourse(int courseId) - List<Exam>, getExamsByType(String examType) - List<Exam>, getExamsByCourseAndType(int courseId, String examType) - List<Exam>, addExam(Exam exam) - boolean, updateExam(Exam exam) - boolean, deleteExam(int examId) - boolean

    // Exam Variables with types
    // examID - int, courseID - int, examName - String, examDate - Date, examType - String, examURL - String

}
