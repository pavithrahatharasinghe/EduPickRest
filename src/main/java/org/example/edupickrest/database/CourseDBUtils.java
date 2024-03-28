package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;
import org.example.edupickrest.models.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;


public class CourseDBUtils {

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

    // Fetch all courses
    public static List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch course by ID
    public static Course getCourseById(int courseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseID = ?");
        statement.setInt(1, courseId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
        }
        return null;
    }

    // Add a new course
    public static boolean addCourse(Course course) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Courses (CourseName, CourseDescription, CourseImage, CourseCategory, CourseLevel, CourseLanguage, CoursePrice, CourseURL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, course.getCourseName());
        statement.setString(2, course.getCourseDescription());
        statement.setString(3, course.getCourseImage());
        statement.setString(4, course.getCourseCategory());
        statement.setString(5, course.getCourseLevel());
        statement.setString(6, course.getCourseLanguage());
        statement.setDouble(7, course.getCoursePrice());
        statement.setString(8, course.getCourseURL());
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    // Update course
    public static boolean updateCourse(Course course) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE Courses SET CourseName = ?, CourseDescription = ?, CourseImage = ?, CourseCategory = ?, CourseLevel = ?, CourseLanguage = ?, CoursePrice = ?, CourseURL = ? WHERE CourseID = ?");
        statement.setString(1, course.getCourseName());
        statement.setString(2, course.getCourseDescription());
        statement.setString(3, course.getCourseImage());
        statement.setString(4, course.getCourseCategory());
        statement.setString(5, course.getCourseLevel());
        statement.setString(6, course.getCourseLanguage());
        statement.setDouble(7, course.getCoursePrice());
        statement.setString(8, course.getCourseURL());
        statement.setInt(9, course.getCourseID());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    }

    // Delete course
    public static boolean deleteCourse(int courseId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Courses WHERE CourseID = ?");
        statement.setInt(1, courseId);
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    }

    // Fetch courses by category
    public static List<Course> getCoursesByCategory(String category) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseCategory = ?");
        statement.setString(1, category);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by level
    public static List<Course> getCoursesByLevel(String level) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseLevel = ?");
        statement.setString(1, level);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by language
    public static List<Course> getCoursesByLanguage(String language) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseLanguage = ?");
        statement.setString(1, language);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by price
    public static List<Course> getCoursesByPrice(double price) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CoursePrice = ?");
        statement.setDouble(1, price);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by category and level
    public static List<Course> getCoursesByCategoryAndLevel(String category, String level) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseCategory = ? AND CourseLevel = ?");
        statement.setString(1, category);
        statement.setString(2, level);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by category and language
    public static List<Course> getCoursesByCategoryAndLanguage(String category, String language) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseCategory = ? AND CourseLanguage = ?");
        statement.setString(1, category);
        statement.setString(2, language);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by category and price
    public static List<Course> getCoursesByCategoryAndPrice(String category, double price) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseCategory = ? AND CoursePrice = ?");
        statement.setString(1, category);
        statement.setDouble(2, price);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by level and language
    public static List<Course> getCoursesByLevelAndLanguage(String level, String language) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseLevel = ? AND CourseLanguage = ?");
        statement.setString(1, level);
        statement.setString(2, language);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by level and price
    public static List<Course> getCoursesByLevelAndPrice(String level, double price) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseLevel = ? AND CoursePrice = ?");
        statement.setString(1, level);
        statement.setDouble(2, price);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    // Fetch courses by language and price
    public static List<Course> getCoursesByLanguageAndPrice(String language, double price) throws SQLException {
        List<Course> courses = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE CourseLanguage = ? AND CoursePrice = ?");
        statement.setString(1, language);
        statement.setDouble(2, price);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Course course = new Course(
                    resultSet.getInt("CourseID"),
                    resultSet.getString("CourseName"),
                    resultSet.getString("CourseDescription"),
                    resultSet.getString("CourseImage"),
                    resultSet.getString("CourseCategory"),
                    resultSet.getString("CourseLevel"),
                    resultSet.getString("CourseLanguage"),
                    resultSet.getDouble("CoursePrice"),
                    resultSet.getString("CourseURL")
            );
            courses.add(course);
        }
        return courses;
    }

    //Course Class variables
    //CourseID, CourseName, CourseDescription, CourseImage, CourseCategory, CourseLevel, CourseLanguage, CoursePrice, CourseURL

    //Course DBUtils methods
    //getAllCourses, getCourseById, addCourse, updateCourse, deleteCourse, getCoursesByCategory, getCoursesByLevel, getCoursesByLanguage, getCoursesByPrice, getCoursesByCategoryAndLevel, getCoursesByCategoryAndLanguage, getCoursesByCategoryAndPrice, getCoursesByLevelAndLanguage, getCoursesByLevelAndPrice, getCoursesByLanguageAndPrice
}
