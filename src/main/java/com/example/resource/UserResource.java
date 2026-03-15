package com.example.resource;

import java.util.List;

import com.example.model.User;
import com.example.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id) {

        User user = userService.getById(id);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .build();
        }

        return Response.ok(user).build();
    }

    @GET
    @Path("/search")
    public List<User> searchUsers(@QueryParam("name") String name) {
        return userService.searchByName(name);
    }

    @POST
    public Response createUser(User user) {

        User created = userService.create(user);

        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") int id, User user) {

        User existing = userService.getById(id);

        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .build();
        }

        User updated = userService.update(id, user);

        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {

        User existing = userService.getById(id);

        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found")
                    .build();
        }

        userService.delete(id);

        return Response.ok()
                .entity("User deleted")
                .build();
    }
}