package com.jking31cs.jerseyexample.webservices;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;

/**
 * Web layer for the User object.
 * Assignment to implement.
 */
@Path("api/users")
public class UserWebService {

    private final UserStore userStore;

    @Inject
    public UserWebService(UserStore userStore) {
        this.userStore = userStore;
    }

    /**
     * Gets all users in the system.
     * @return list of all users.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        return userStore.getAll();
    }

    /**
     * Gets user with specific id.
     * @param id User ID to fetch.
     * @return matching User.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User get(
            @PathParam("id") Long id
    ) {
        return userStore.get(id);
    }

    /**
     * Creates a new user.
     * @param user new User data to create.
     * @return new User.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(
            User user
    ) {
        return userStore.save(user);
    }

    /**
     * Updates a user in the system.
     * @param user existing User data to use to update.
     * @return updated User.
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(
            @PathParam("id") Long id,
            User user
    ) {
        return userStore.save(user);
    }

    /**
     * Deletes a user from the system.
     * @param id User ID of User to delete.
     * @return deleted User.
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User delete(
            @PathParam("id") Long id
    ) {
        return userStore.delete(
                userStore.get(id)
        );
    }

}
