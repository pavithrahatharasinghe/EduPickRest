package org.example.edupickrest.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.CourseDBUtils;
import org.example.edupickrest.database.EnrollmentDBUtils;
import org.example.edupickrest.database.ModulesDBUtils;
import org.example.edupickrest.models.Enrollment;

//DBUtils methods with parameters and response types
//getEnrollmentById(int enrollmentId) - Enrollment, addEnrollment(Enrollment enrollment) - boolean, updateEnrollment(Enrollment enrollment) - boolean, deleteEnrollment(int enrollmentId) - boolean, getEnrollmentsByUserId(int userId) - List<Enrollment>, getEnrollmentsByCourseId(int courseId) - List<Enrollment>, getEnrollmentsByCompletionStatus(String status) - List<Enrollment>, getEnrollmentsByUserIdAndCompletionStatus(int userId, String status) - List<Enrollment>, getEnrollmentsByCourseIdAndCompletionStatus(int courseId, String status) - List<Enrollment>, getEnrollmentsByUserIdCourseIdAndCompletionStatus(int userId, int courseId, String status) - List<Enrollment>, getEnrollmentsByUserIdAndCourseId(int userId, int courseId) - List<Enrollment>


//Class variables with data types
//enrollmentID - int, userID - int, courseID - int, enrollmentDate - Date, completionDate - Date, completionStatus - int

@Path("/enrollments")
public class EnrollmentServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEnrollment(Enrollment enrollment) {
        try {
            if (EnrollmentDBUtils.addEnrollment(enrollment)) {
                return Response.status(201).entity("Enrollment added successfully").build();
            } else {
                return Response.status(400).entity("Failed to add enrollment").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnrollments() {
        try {
            return Response.status(200).entity(EnrollmentDBUtils.getAllEnrollments()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Path("Course/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnrollmentsByCourseId(@PathParam("courseId") int courseId) {
        try {
            return Response.status(200).entity(EnrollmentDBUtils.getEnrollmentsByCourseId(courseId)).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @DELETE
    @Path("/{enrollmentID}")
    public Response deleteModule(@PathParam("enrollmentID") int enrollmentID) {
        try {
            if (EnrollmentDBUtils.deleteEnrollment(enrollmentID)) {
                return Response.status(200).entity("Enrollment deleted successfully").build();
            } else {
                return Response.status(400).entity("Failed to delete enrollment").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }








}
