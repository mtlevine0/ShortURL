package com.mtlevine0.shorturl.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

import com.mtlevine0.shorturl.model.URL;
import com.mtlevine0.shorturl.repository.URLDao;

public class URLService {
	
	URLDao urlDao = new URLDao();
	
	public void addURL(URL url) {
		url.setUuid(generateId());
		urlDao.addURL(url);
	}
	
	public URI getRedirect(String redirectId) {
		List<URL> urlList = urlDao.getURL(redirectId);
    	URI redirectUri = null;
    	
    	URL url = urlList.get(0);
    	
    	url.setHitCount(url.getHitCount()+1);
    	String targetURL = url.getTargetURL();
    	
		try {
			redirectUri = new URI(targetURL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		urlDao.updateURL(url);
		return redirectUri;
	}
	
	private String generateId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

}
