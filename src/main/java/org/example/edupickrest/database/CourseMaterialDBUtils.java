package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;
import org.example.edupickrest.models.CourseMaterial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseMaterialDBUtils {
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

    public static boolean addCourseMaterial(CourseMaterial courseMaterial) throws SQLException {
        String query = "INSERT INTO course_materials (materialName, materialType, materialLink, courseId) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, courseMaterial.getMaterialName());
        preparedStatement.setString(2, courseMaterial.getMaterialType());
        preparedStatement.setString(3, courseMaterial.getMaterialLink());
        preparedStatement.setInt(4, courseMaterial.getCourseId());
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<CourseMaterial> getCourseMaterialsByCourseId(int courseId) throws SQLException {
        String query = "SELECT * FROM course_materials WHERE courseId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, courseId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CourseMaterial> courseMaterials = new ArrayList<>();
        while (resultSet.next()) {
            CourseMaterial courseMaterial = new CourseMaterial();
            courseMaterial.setMaterialId(resultSet.getInt("materialId"));
            courseMaterial.setMaterialName(resultSet.getString("materialName"));
            courseMaterial.setMaterialType(resultSet.getString("materialType"));
            courseMaterial.setMaterialLink(resultSet.getString("materialLink"));
            courseMaterial.setCourseId(resultSet.getInt("courseId"));
            courseMaterials.add(courseMaterial);
        }
        return courseMaterials;
    }

    public static boolean deleteCourseMaterial(int materialId) throws SQLException {
        String query = "DELETE FROM course_materials WHERE materialId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, materialId);
        return preparedStatement.executeUpdate() > 0;
    }

public static boolean updateCourseMaterial(CourseMaterial courseMaterial) throws SQLException {
        String query = "UPDATE course_materials SET materialName = ?, materialType = ?, materialLink = ?, courseId = ? WHERE materialId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, courseMaterial.getMaterialName());
        preparedStatement.setString(2, courseMaterial.getMaterialType());
        preparedStatement.setString(3, courseMaterial.getMaterialLink());
        preparedStatement.setInt(4, courseMaterial.getCourseId());
        preparedStatement.setInt(5, courseMaterial.getMaterialId());
        return preparedStatement.executeUpdate() > 0;
    }

}
