package org.example.edupickrest.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.CourseDBUtils;
import org.example.edupickrest.models.Course;


//Course Class variables
//CourseID, CourseName, CourseDescription, CourseImage, CourseCategory, CourseLevel, CourseLanguage, CoursePrice, CourseURL

//Course DBUtils methods
//getAllCourses, getCourseById, addCourse, updateCourse, deleteCourse, getCoursesByCategory, getCoursesByLevel, getCoursesByLanguage, getCoursesByPrice, getCoursesByCategoryAndLevel, getCoursesByCategoryAndLanguage, getCoursesByCategoryAndPrice, getCoursesByLevelAndLanguage, getCoursesByLevelAndPrice, getCoursesByLanguageAndPrice

@Path("/courses")
public class CourseServices {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCourses() {
        try {
            return Response.ok(CourseDBUtils.getAllCourses()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course) {
        try {
            if (CourseDBUtils.addCourse(course)) {
                return Response.status(Response.Status.CREATED).entity("Course added successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error adding course").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseById(@PathParam("id") int courseId) {
        try {
            Course course = CourseDBUtils.getCourseById(courseId);
            if (course != null) {
                return Response.ok(course).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Course not found").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCourse(@PathParam("id") int courseId, Course course) {
        try {
            course.setCourseID(courseId); // Ensure the ID is set correctly
            if (CourseDBUtils.updateCourse(course)) {
                return Response.ok().entity("Course updated successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error updating course").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCourse(@PathParam("id") int courseId) {
        try {
            if (CourseDBUtils.deleteCourse(courseId)) {
                return Response.ok().entity("Course deleted successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting course").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }

    }

    @GET
    @Path("/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByCategory(@PathParam("category") String category) {
        try {
            return Response.ok(CourseDBUtils.getCoursesByCategory(category)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/level/{level}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByLevel(@PathParam("level") String level) {
        try {
            return Response.ok(CourseDBUtils.getCoursesByLevel(level)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/language/{language}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByLanguage(@PathParam("language") String language) {
        try {
            return Response.ok(CourseDBUtils.getCoursesByLanguage(language)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/price/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByPrice(@PathParam("price") double price) {
        try {
            return Response.ok(CourseDBUtils.getCoursesByPrice(price)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/category/{category}/level/{level}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoursesByCategoryAndLevel(@PathParam("category") String category, @PathParam("level") String level) {
        try {
            return Response.ok(CourseDBUtils.getCoursesByCategoryAndLevel(category, level)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }




}
