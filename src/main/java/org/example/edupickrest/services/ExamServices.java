package org.example.edupickrest.services;


// Exam DButill classes with return types
// getAllExams() - List<Exam>, getExamById(int examId) - Exam, getExamsByCourse(int courseId) - List<Exam>, getExamsByType(String examType) - List<Exam>, getExamsByCourseAndType(int courseId, String examType) - List<Exam>, addExam(Exam exam) - boolean, updateExam(Exam exam) - boolean, deleteExam(int examId) - boolean

// Exam Variables with types
// examID - int, courseID - int, examName - String, examDate - Date, examType - String, examURL - String


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.ExamDBUtils;
import org.example.edupickrest.models.Exam;

import java.util.List;

@Path("/exams")
public class ExamServices {

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAllExams() {
            try {
                return Response.ok(ExamDBUtils.getAllExams()).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Response addExam(Exam exam) {
            try {
                if (ExamDBUtils.addExam(exam)) {
                    return Response.status(Response.Status.CREATED).entity("Exam added successfully").build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Error adding exam").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getExamById(@PathParam("id") int examId) {
            try {
                Exam exam = ExamDBUtils.getExamById(examId);
                if (exam != null) {
                    return Response.ok(exam).build();
                } else {
                    return Response.status(Response.Status.NOT_FOUND).entity("Exam not found").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        public Response updateExam(Exam exam) {
            try {
                if (ExamDBUtils.updateExam(exam)) {
                    return Response.status(Response.Status.OK).entity("Exam updated successfully").build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Error updating exam").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @DELETE
        @Path("/{id}")
        public Response deleteExam(@PathParam("id") int examId) {
            try {
                if (ExamDBUtils.deleteExam(examId)) {
                    return Response.status(Response.Status.OK).entity("Exam deleted successfully").build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity("Error deleting exam").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @GET
        @Path("/course/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getExamsByCourse(@PathParam("id") int courseId) {
            try {
                List<Exam> exams = ExamDBUtils.getExamsByCourse(courseId);
                if (exams != null) {
                    return Response.ok(exams).build();
                } else {
                    return Response.status(Response.Status.NOT_FOUND).entity("Exams not found").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @GET
        @Path("/type/{type}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getExamsByType(@PathParam("type") String examType) {
            try {
                List<Exam> exams = ExamDBUtils.getExamsByType(examType);
                if (exams != null) {
                    return Response.ok(exams).build();
                } else {
                    return Response.status(Response.Status.NOT_FOUND).entity("Exams not found").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }

        @GET
        @Path("/course/{id}/type/{type}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getExamsByCourseAndType(@PathParam("id") int courseId, @PathParam("type") String examType) {
            try {
                List<Exam> exams = ExamDBUtils.getExamsByCourseAndType(courseId, examType);
                if (exams != null) {
                    return Response.ok(exams).build();
                } else {
                    return Response.status(Response.Status.NOT_FOUND).entity("Exams not found").build();
                }
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
            }
        }



}
