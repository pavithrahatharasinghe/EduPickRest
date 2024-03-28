package org.example.edupickrest.services;

import jakarta.ws.rs.Path;
import org.example.edupickrest.database.AssignmentDBUtils;
import org.example.edupickrest.models.Assignment;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

//Assignment Class variables
//AssignmentID, AssignmentName, AssignmentDescription, AssignmentType, AssignmentStatus, AssignmentDueDate, AssignmentDueTime, AssignmentCourse, AssignmentModule, AssignmentFile


//Course DBUtils methods
//Fetch all courses, Fetch course by ID, Add course, Update course, Delete course, Fetch courses by category, Fetch courses by level, Fetch courses by language, Fetch courses by price, Fetch courses by category and level, Fetch courses by category and language, Fetch courses by category and price, Fetch courses by level and language, Fetch courses by level and price, Fetch courses by language and price

@Path("/assignments")
public class AssignmentServices {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAssignments() {
        try {
            return Response.ok(AssignmentDBUtils.getAllAssignments()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAssignment(Assignment assignment) {
        try {
            if (AssignmentDBUtils.addAssignment(assignment)) {
                return Response.status(Response.Status.CREATED).entity("Assignment added successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error adding assignment").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssignmentById(@PathParam("id") int assignmentId) {
        try {
            Assignment assignment = AssignmentDBUtils.getAssignmentById(assignmentId);
            if (assignment != null) {
                return Response.ok(assignment).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Assignment not found").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAssignment(@PathParam("id") int assignmentId, Assignment assignment) {
        try {
            assignment.setAssignmentID(assignmentId); // Ensure the ID is set correctly
            if (AssignmentDBUtils.updateAssignment(assignment)) {
                return Response.ok().entity("Assignment updated successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error updating assignment").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAssignment(@PathParam("id") int assignmentId) {
        try {
            if (AssignmentDBUtils.deleteAssignment(assignmentId)) {
                return Response.ok().entity("Assignment deleted successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting assignment").build();
            }
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/course/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssignmentsByCourse(@PathParam("id") int courseId) {
        try {
            return Response.ok(AssignmentDBUtils.getAssignmentsByCourse(courseId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }


}
