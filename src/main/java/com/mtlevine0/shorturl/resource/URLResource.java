package com.mtlevine0.shorturl.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.mtlevine0.shorturl.model.URL;
import com.mtlevine0.shorturl.repository.URLDao;
import com.mtlevine0.shorturl.service.URLService;
  
@Path("/")
public class URLResource
{
	
	URLService urlService = new URLService();
	
    @POST
    @Path("/test")
    @Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
    public URL test(URL url) {
    	urlService.addURL(url);
    	return url;
    }
    
    @GET
    @Path("/{redirectUuid}")
    public Response redirect(@PathParam("redirectUuid") String redirectUuid) {
    	return Response.temporaryRedirect(urlService.getRedirect(redirectUuid)).build();
    } 
	
//    @POST
//    @Path("/authenticate")
//    @Consumes({MediaType.APPLICATION_JSON})
//	@Produces({MediaType.APPLICATION_JSON})
//    public User authenticate(User user) {
//    	return user;
//    }
    
}