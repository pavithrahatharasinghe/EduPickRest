package org.example.edupickrest.database;

import org.example.edupickrest.DatabaseConnection;
import org.example.edupickrest.models.Modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModulesDBUtils {

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

    public static boolean addModule(Modules module) throws java.sql.SQLException {
        String query = "INSERT INTO modules (courseID, moduleName, moduleDescription, moduleURL, moduleStatus) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, module.getCourseID());
        preparedStatement.setString(2, module.getModuleName());
        preparedStatement.setString(3, module.getModuleDescription());
        preparedStatement.setString(4, module.getModuleURL());
        preparedStatement.setString(5, module.getModuleStatus());
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<Modules> getAllModules() throws SQLException {
        String query = "SELECT * FROM modules";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Modules> modules = new ArrayList<>();
        while (resultSet.next()) {
            Modules module = new Modules();
            module.setModuleID(resultSet.getInt("moduleID"));
            module.setCourseID(resultSet.getInt("courseID"));
            module.setModuleName(resultSet.getString("moduleName"));
            module.setModuleDescription(resultSet.getString("moduleDescription"));
            module.setModuleURL(resultSet.getString("moduleURL"));
            module.setModuleStatus(resultSet.getString("moduleStatus"));
            modules.add(module);
        }
        return modules;
    }

    //get course modules by courseID
    public static List<Modules> getCourseModules(int courseID) throws SQLException {
        String query = "SELECT * FROM modules WHERE courseID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, courseID);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Modules> modules = new ArrayList<>();
        while (resultSet.next()) {
            Modules module = new Modules();
            module.setModuleID(resultSet.getInt("moduleID"));
            module.setCourseID(resultSet.getInt("courseID"));
            module.setModuleName(resultSet.getString("moduleName"));
            module.setModuleDescription(resultSet.getString("moduleDescription"));
            module.setModuleURL(resultSet.getString("moduleURL"));
            module.setModuleStatus(resultSet.getString("moduleStatus"));
            modules.add(module);
        }
        return modules;
    }

    public static Modules getModule(int moduleID) throws SQLException {
        String query = "SELECT * FROM modules WHERE moduleID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, moduleID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Modules module = new Modules();
            module.setModuleID(resultSet.getInt("moduleID"));
            module.setCourseID(resultSet.getInt("courseID"));
            module.setModuleName(resultSet.getString("moduleName"));
            module.setModuleDescription(resultSet.getString("moduleDescription"));
            module.setModuleURL(resultSet.getString("moduleURL"));
            module.setModuleStatus(resultSet.getString("moduleStatus"));
            return module;
        }
        return null;
    }

    public static boolean updateModule(Modules module) throws SQLException {
        String query = "UPDATE modules SET courseID = ?, moduleName = ?, moduleDescription = ?, moduleURL = ?, moduleStatus = ? WHERE moduleID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, module.getCourseID());
        preparedStatement.setString(2, module.getModuleName());
        preparedStatement.setString(3, module.getModuleDescription());
        preparedStatement.setString(4, module.getModuleURL());
        preparedStatement.setString(5, module.getModuleStatus());
        preparedStatement.setInt(6, module.getModuleID());
        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean deleteModule(int moduleID) throws SQLException {
        String query = "DELETE FROM modules WHERE moduleID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, moduleID);
        return preparedStatement.executeUpdate() > 0;
    }



}
