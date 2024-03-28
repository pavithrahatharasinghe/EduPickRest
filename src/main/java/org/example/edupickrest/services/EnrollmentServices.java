package org.example.edupickrest.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.EnrollmentDBUtils;
import org.example.edupickrest.models.Enrollment;

//DBUtils methods with parameters and response types
//getEnrollmentById(int enrollmentId) - Enrollment, addEnrollment(Enrollment enrollment) - boolean, updateEnrollment(Enrollment enrollment) - boolean, deleteEnrollment(int enrollmentId) - boolean, getEnrollmentsByUserId(int userId) - List<Enrollment>, getEnrollmentsByCourseId(int courseId) - List<Enrollment>, getEnrollmentsByCompletionStatus(String status) - List<Enrollment>, getEnrollmentsByUserIdAndCompletionStatus(int userId, String status) - List<Enrollment>, getEnrollmentsByCourseIdAndCompletionStatus(int courseId, String status) - List<Enrollment>, getEnrollmentsByUserIdCourseIdAndCompletionStatus(int userId, int courseId, String status) - List<Enrollment>, getEnrollmentsByUserIdAndCourseId(int userId, int courseId) - List<Enrollment>


//Class variables with data types
//enrollmentID - int, userID - int, courseID - int, enrollmentDate - Date, completionDate - Date, completionStatus - int

@Path("/enrollments")
public class EnrollmentServices {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnrollments() {
        try {
            return Response.ok(EnrollmentDBUtils.getAllEnrollments()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEnrollment(Enrollment enrollment) {
        try {
            if (EnrollmentDBUtils.addEnrollment(enrollment)) {
                return Response.status(Response.Status.CREATED).entity("Enrollment added successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error adding enrollment").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnrollmentById(@PathParam("id") int enrollmentId) {
        try {
            Enrollment enrollment = EnrollmentDBUtils.getEnrollmentById(enrollmentId);
            if (enrollment != null) {
                return Response.ok(enrollment).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Enrollment not found").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEnrollment(@PathParam("id") int enrollmentId, Enrollment enrollment) {
        try {
            enrollment.setEnrollmentID(enrollmentId); // Ensure the ID is set correctly
            if (EnrollmentDBUtils.updateEnrollment(enrollment)) {
                return Response.ok().entity("Enrollment updated successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error updating enrollment").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEnrollment(@PathParam("id") int enrollmentId) {
        try {
            if (EnrollmentDBUtils.deleteEnrollment(enrollmentId)) {
                return Response.ok().entity("Enrollment deleted successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Enrollment not found").build();

            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getEnrollmentsByUserId(@PathParam("id") int userId) {
        try {
            return Response.ok(EnrollmentDBUtils.getEnrollmentsByUserId(userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/course/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getEnrollmentsByCourseId(@PathParam("id") int courseId) {
        try {
            return Response.ok(EnrollmentDBUtils.getEnrollmentsByCourseId(courseId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }








}
