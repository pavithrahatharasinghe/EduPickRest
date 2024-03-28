package org.example.edupickrest.services;

//Result DBUtils methods with return types
// getAllResults() -> List<Result>, getResultById(int resultId) -> Result, getResultsByCourse(int courseId) -> List<Result>, getResultsByUser(int userId) -> List<Result>, getResultsByUserAndCourse(int userId, int courseId) -> List<Result>, getResultsByDate(String date) -> List<Result>, getResultsByMarks(double marks) -> List<Result>, getResultsByMarksAndCourse(double marks, int courseId) -> List<Result>, getResultsByMarksAndUser(double marks, int userId) -> List<Result>, addResult(Result result) -> boolean, updateResult(Result result) -> boolean, deleteResult(int resultId) -> boolean

//Result Variables with data types
// resultID -> int, userID -> int, courseID -> int, marks -> double, resultDate -> String


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.ResultDBUtils;
import org.example.edupickrest.models.Result;


@Path("/results")
public class ResultServices {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResults() {
        try {
            return Response.ok(ResultDBUtils.getAllResults()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addResult(Result result) {
        try {
            if (ResultDBUtils.addResult(result)) {
                return Response.status(Response.Status.CREATED).entity("Result added successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error adding result").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultById(@PathParam("id") int resultId) {
        try {
            Result result = ResultDBUtils.getResultById(resultId);
            if (result != null) {
                return Response.ok(result).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Result not found").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateResult(Result result) {
        try {
            if (ResultDBUtils.updateResult(result)) {
                return Response.ok("Result updated successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error updating result").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteResult(@PathParam("id") int resultId) {
        try {
            if (ResultDBUtils.deleteResult(resultId)) {
                return Response.ok("Result deleted successfully").build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting result").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/course/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByCourse(@PathParam("id") int courseId) {
        try {
            return Response.ok(ResultDBUtils.getResultsByCourse(courseId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByUser(@PathParam("id") int userId) {
        try {
            return Response.ok(ResultDBUtils.getResultsByUser(userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/user/{userId}/course/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByUserAndCourse(@PathParam("userId") int userId, @PathParam("courseId") int courseId) {
        try {
            return Response.ok(ResultDBUtils.getResultsByUserAndCourse(userId, courseId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/date/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByDate(@PathParam("date") String date) {
        try {
            return Response.ok(ResultDBUtils.getResultsByDate(date)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/marks/{marks}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByMarks(@PathParam("marks") double marks) {
        try {
            return Response.ok(ResultDBUtils.getResultsByMarks(marks)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/marks/{marks}/course/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByMarksAndCourse(@PathParam("marks") double marks, @PathParam("courseId") int courseId) {
        try {
            return Response.ok(ResultDBUtils.getResultsByMarksAndCourse(marks, courseId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/marks/{marks}/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResultsByMarksAndUser(@PathParam("marks") double marks, @PathParam("userId") int userId) {
        try {
            return Response.ok(ResultDBUtils.getResultsByMarksAndUser(marks, userId)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }


}