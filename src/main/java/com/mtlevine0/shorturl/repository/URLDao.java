package com.mtlevine0.shorturl.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mtlevine0.shorturl.model.URL;
import com.mtlevine0.shorturl.repository.SessionUtil;

public class URLDao {
	
    public void addURL(URL bean) {
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
    	session.save(bean);
        tx.commit();
        session.close(); 
    }
    
    public List<URL> getURL(String redirectId) {
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("from URL where uuid = :redirectId");
        query.setParameter("redirectId", redirectId);
        List<URL> urls =  query.list();
        session.close();
        return urls;
    }
    
    public int updateURL(URL bean) {
        Session session = SessionUtil.getSession();    
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("update URL set hitCount = :hitCount where uuid = :redirectId");
        query.setParameter("redirectId", bean.getUuid());
        query.setParameter("hitCount", bean.getHitCount());
        int rowCount =  query.executeUpdate();
        tx.commit();
        session.close();
        return rowCount;
    }

}
