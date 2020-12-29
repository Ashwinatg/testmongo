package com.example.testMongo.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "incoming")
public class Incoming {
	@Id
	private String id;
	private Map<String,Object> into;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getInto() {
		return into;
	}
	public void setInto(Map<String, Object> into) {
		this.into = into;
	}
	
	
	
}
