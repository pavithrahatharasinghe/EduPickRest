package org.example.edupickrest.services;

import jakarta.ws.rs.Path;
import org.example.edupickrest.database.AssignmentDBUtils;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.models.Assignment;


@Path("/assignments")
public class AssignmentServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAssignment(Assignment assignment) {
        try {
            if (AssignmentDBUtils.addAssignment(assignment)) {
                return Response.status(201).entity("Assignment added successfully").build();
            } else {
                return Response.status(400).entity("Failed to add assignment").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAssignments() {
        try {
            return Response.status(200).entity(AssignmentDBUtils.getAllAssignments()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @PUT
    @Path("/{assignmentID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAssignment(@PathParam("assignmentID") int assignmentID, Assignment assignment) {
        try {
            if (AssignmentDBUtils.updateAssignment(assignmentID, assignment)) {
                return Response.status(200).entity("Assignment updated successfully").build();
            } else {
                return Response.status(400).entity("Failed to update assignment").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @DELETE
    @Path("/{assignmentID}")
    public Response deleteAssignment(@PathParam("assignmentID") int assignmentID) {
        try {
            if (AssignmentDBUtils.deleteAssignment(assignmentID)) {
                return Response.status(200).entity("Assignment deleted successfully").build();
            } else {
                return Response.status(400).entity("Failed to delete assignment").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }


}
