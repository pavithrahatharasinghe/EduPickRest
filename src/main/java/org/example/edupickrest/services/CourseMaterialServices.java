package org.example.edupickrest.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.CourseMaterialDBUtils;
import org.example.edupickrest.models.CourseMaterial;


@Path("/courseMaterial")
public class CourseMaterialServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourseMaterial(CourseMaterial courseMaterial) {
        try {
            if (CourseMaterialDBUtils.addCourseMaterial(courseMaterial)) {
                return Response.status(201).entity("Course Material added successfully").build();
            } else {
                return Response.status(400).entity("Failed to add course material").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Path("Course/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseMaterialsByCourseId(@PathParam("courseId") int courseId) {
        try {
            return Response.status(200).entity(CourseMaterialDBUtils.getCourseMaterialsByCourseId(courseId)).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @DELETE
    @Path("/{materialId}")
    public Response deleteCourseMaterial(@PathParam("materialId") int materialId) {
        try {
            if (CourseMaterialDBUtils.deleteCourseMaterial(materialId)) {
                return Response.status(200).entity("Course Material deleted successfully").build();
            } else {
                return Response.status(400).entity("Failed to delete course material").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCourseMaterial(CourseMaterial courseMaterial) {
        try {
            if (CourseMaterialDBUtils.updateCourseMaterial(courseMaterial)) {
                return Response.status(200).entity("Course Material updated successfully").build();
            } else {
                return Response.status(400).entity("Failed to update course material").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

}
