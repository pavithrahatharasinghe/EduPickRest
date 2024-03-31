package org.example.edupickrest.services;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.ResultDBUtils;
import org.example.edupickrest.models.Results;


@Path("/results")
public class ResultServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addResult(Results results) {
        try {
            if (ResultDBUtils.addResult(results)) {
                return Response.status(201).entity("Result added successfully").build();
            } else {
                return Response.status(400).entity("Failed to add result").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Path("Assignment/{assignmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByAssignmentId(@PathParam("assignmentId") int assignmentId) {
        try {
            return Response.status(200).entity(ResultDBUtils.getResultsByAssignmentId(assignmentId)).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @PUT
    @Path("{resultId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateResult(@PathParam("resultId") int resultId, Results results) {
        try {
            if (ResultDBUtils.updateResult(resultId, results)) {
                return Response.status(200).entity("Result updated successfully").build();
            } else {
                return Response.status(400).entity("Failed to update result").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @DELETE
    @Path("{resultId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteResult(@PathParam("resultId") int resultId) {
        try {
            if (ResultDBUtils.deleteResult(resultId)) {
                return Response.status(200).entity("Result deleted successfully").build();
            } else {
                return Response.status(400).entity("Failed to delete result").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }




}
