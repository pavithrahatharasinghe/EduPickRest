package org.example.edupickrest.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.CourseDBUtils;
import org.example.edupickrest.models.Course;

@Path("/courses")
public class CourseServices {

    @POST

    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course) {
        try {
            if (CourseDBUtils.addCourse(course)) {
                return Response.status(201).entity("Course added successfully").build();
            } else {
                return Response.status(400).entity("Failed to add course").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCourses() {
        try {
            return Response.status(200).entity(CourseDBUtils.getAllCourses()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Path("/{courseID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourse(@PathParam("courseID") int courseID) {
        try {
            return Response.status(200).entity(CourseDBUtils.getCourse(courseID)).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }




}
