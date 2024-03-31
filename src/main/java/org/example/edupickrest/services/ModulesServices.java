package org.example.edupickrest.services;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.edupickrest.database.ModulesDBUtils;
import org.example.edupickrest.models.Modules;

@Path("/modules")
public class ModulesServices {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addModule(Modules module) {
        try {
            if (ModulesDBUtils.addModule(module)) {
                return Response.status(201).entity("Module added successfully").build();
            } else {
                return Response.status(400).entity("Failed to add module").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        try {
            return Response.status(200).entity(ModulesDBUtils.getAllModules()).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    //get course modules by courseID
    @GET
    @Path("/byCourse/{courseID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseModules(@PathParam("courseID") int courseID) {
        try {
            return Response.status(200).entity(ModulesDBUtils.getCourseModules(courseID)).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }



    @GET
    @Path("/{moduleID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModule(@PathParam("moduleID") int moduleID) {
        try {
            return Response.status(200).entity(ModulesDBUtils.getModule(moduleID)).build();
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateModule(Modules module) {
        try {
            if (ModulesDBUtils.updateModule(module)) {
                return Response.status(200).entity("Module updated successfully").build();
            } else {
                return Response.status(400).entity("Failed to update module").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

    @DELETE
    @Path("/{moduleID}")
    public Response deleteModule(@PathParam("moduleID") int moduleID) {
        try {
            if (ModulesDBUtils.deleteModule(moduleID)) {
                return Response.status(200).entity("Module deleted successfully").build();
            } else {
                return Response.status(400).entity("Failed to delete module").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }

}
