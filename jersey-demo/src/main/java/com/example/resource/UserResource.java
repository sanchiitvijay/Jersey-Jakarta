package com.example.resource;

import java.util.List;

import com.example.model.User;
import com.example.service.UserService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    public UserService userService = new UserService();

    @GET
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        return userService.getById(id);
    }

    @POST
    public User createUser(User user) {
        return userService.create(user);
    }

    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") int id, User user){
        return userService.update(id, user);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id){
        userService.delete(id);
        return Response.ok().build();
    }
    
}
