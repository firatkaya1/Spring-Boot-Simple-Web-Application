package com.kayafirat.model;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loghistory")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "logtype")
	private String logtype;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "logdate")
	private String logdate;
	
	
	public Log() {}
	

	public Log(String logtype,String username) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.logtype = logtype;
		this.username = username;
		this.logdate = simpleDateFormat.format(new Date());
	}

	public long getLogId() {
		return id;
	}


	public void setLogId(long logId) {
		this.id = logId;
	}
	
	public String getLogtype() {
		return logtype;
	}


	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getLogdate() {
		return logdate;
	}


	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}


	@Override
	public String toString() {
		return "Log [logId=" + id + ", logtype=" + logtype + ", userid=" + username + ", logdate=" + logdate + "]";
	}

	
	
	
	
}
