package com.abhi.RAssured;


/**
 * Sample Plain Old Java Object for request body creation
 *
 */
public class POJO_User {
	private String name;
	private String job;
	
	
	public POJO_User() {
		super();
	}
	public POJO_User(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	

}
