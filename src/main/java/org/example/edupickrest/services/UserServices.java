package org.example.edupickrest.services;

import org.example.edupickrest.database.UserDBUtils;
import org.example.edupickrest.models.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

//User DBUtils methods with return type
// getAllUsers() : List<User>, getUserById(int userId) : User, addUser(User user) : boolean, updateUser(User user) : boolean, deleteUser(int userId) : boolean, getUserByUsername(String username) : User, getUserByEmail(String email) : User, getUserByUsernameAndPassword(String username, String password) : User, getUserByEmailAndPassword(String email, String password) : User

//User Variables with data types

//userID : int, firstName : String, lastName : String, middleName : String, username : String, password : String, email : String, role : String


@Path("/users")
public class UserServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        try {
            boolean added = UserDBUtils.addUser(user);
            if (added) {
                return Response.ok().entity("User added successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error adding user").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        try {
            List<User> users = UserDBUtils.getAllUsers();
            return Response.ok(users).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response userLogin(User user) throws SQLException {
        User loggedInUser = UserDBUtils.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            // Return success response with the logged-in user's data
            return Response.ok(loggedInUser).build();
        } else {
            // Return error response
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        }
    }

    @GET
    @Path("/usetype/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByRole(@PathParam("role") String role) {
        try {
            List<User> users = UserDBUtils.getUsersByRole(role);
            return Response.ok(users).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") int userId) {
        try {
            User user = UserDBUtils.getUserById(userId);
            if (user != null) {
                return Response.ok(user).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        try {
            boolean updated = UserDBUtils.updateUser(user);
            if (updated) {
                return Response.ok().entity("User updated successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error updating user").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") int userId) {
        try {
            boolean deleted = UserDBUtils.deleteUser(userId);
            if (deleted) {
                return Response.ok().entity("User deleted successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting user").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }

    @GET
    @Path("/{userId}/status/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setUserStatus(@PathParam("userId") int userId, @PathParam("status") String status) {
        try {
            boolean updated = UserDBUtils.setUserStatus(userId, status);
            if (updated) {
                return Response.ok().entity("User status updated successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error updating user status").build();
            }
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Server error").build();
        }
    }



}




