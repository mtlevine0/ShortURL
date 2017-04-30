package com.mtlevine0.shorturl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "url")
public class URL {
	
	@Id
	@Column
	private String uuid;
	@Column
	private String targetURL;
	@Column
	private int hitCount;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getTargetURL() {
		return targetURL;
	}
	
	public void setTargetURL(String targetURL) {
		this.targetURL = targetURL;
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

}
