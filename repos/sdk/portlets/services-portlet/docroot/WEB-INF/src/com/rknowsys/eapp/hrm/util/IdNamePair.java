package com.rknowsys.eapp.hrm.util;

public class IdNamePair {

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IdNamePair(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public IdNamePair() {
	}

	@Override
	public String toString() {
		return "IdNamePair [id=" + id + ", name=" + name + "]";
	}
	
}
