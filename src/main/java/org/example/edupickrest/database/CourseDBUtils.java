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
//CourseID, CourseName, CourseDescription, CourseImage, CourseCategory, CourseLevel, CourseLanguage, CoursePrice, CourseURL,courseDuration,courseDuration

    public static boolean addCourse(Course course) throws java.sql.SQLException {
        String query = "INSERT INTO Courses (CourseName, CourseDescription, CourseImage, CourseCategory, CourseLevel, CourseLanguage, CoursePrice, CourseURL, courseDuration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, course.getCourseName());
        preparedStatement.setString(2, course.getCourseDescription());
        preparedStatement.setString(3, course.getCourseImage());
        preparedStatement.setString(4, course.getCourseCategory());
        preparedStatement.setString(5, course.getCourseLevel());
        preparedStatement.setString(6, course.getCourseLanguage());
        preparedStatement.setDouble(7, course.getCoursePrice());
        preparedStatement.setString(8, course.getCourseURL());
        preparedStatement.setString(9, course.getCourseDuration());
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<Course> getAllCourses() throws SQLException {
        String query = "SELECT * FROM Courses";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Course> courses = new ArrayList<>();
        while (resultSet.next()) {
            Course course = new Course();
            course.setCourseID(resultSet.getInt("CourseID"));
            course.setCourseName(resultSet.getString("CourseName"));
            course.setCourseDescription(resultSet.getString("CourseDescription"));
            course.setCourseImage(resultSet.getString("CourseImage"));
            course.setCourseCategory(resultSet.getString("CourseCategory"));
            course.setCourseLevel(resultSet.getString("CourseLevel"));
            course.setCourseLanguage(resultSet.getString("CourseLanguage"));
            course.setCoursePrice(resultSet.getDouble("CoursePrice"));
            course.setCourseURL(resultSet.getString("CourseURL"));
            course.setCourseDuration(resultSet.getString("courseDuration"));
            courses.add(course);
        }
        return courses;
    }

    public static Course getCourse(int courseID) throws SQLException {
        String query = "SELECT * FROM Courses WHERE CourseID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, courseID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Course course = new Course();
            course.setCourseID(resultSet.getInt("CourseID"));
            course.setCourseName(resultSet.getString("CourseName"));
            course.setCourseDescription(resultSet.getString("CourseDescription"));
            course.setCourseImage(resultSet.getString("CourseImage"));
            course.setCourseCategory(resultSet.getString("CourseCategory"));
            course.setCourseLevel(resultSet.getString("CourseLevel"));
            course.setCourseLanguage(resultSet.getString("CourseLanguage"));
            course.setCoursePrice(resultSet.getDouble("CoursePrice"));
            course.setCourseURL(resultSet.getString("CourseURL"));
            course.setCourseDuration(resultSet.getString("courseDuration"));
            return course;
        }
        return null;
    }


}
