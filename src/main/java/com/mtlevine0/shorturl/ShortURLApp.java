package com.mtlevine0.shorturl;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//import com.mtlevine0.shorturl.repository.SessionUtil;

//import com.mtlevine0.filter.*;
//import com.mtlevine0.resource.*;

@ApplicationPath("/api")
public class ShortURLApp extends ResourceConfig{
	public ShortURLApp() {
		System.out.println("ShortURL is Running!");
	}
}
