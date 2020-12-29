package com.example.testMongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "outgoing")
public class Outgoing {
	
	@Id
	private String id;
	private int largestNum;
	private List<char[]> duplicateStr;
	private String stringWithoutWhiteSpaces;
	
	public Outgoing(String id, int largestNum, List<char[]> duplicateStr, String stringWithoutWhiteSpaces) {
		super();
		this.id = id;
		this.largestNum = largestNum;
		this.duplicateStr = duplicateStr;
		this.stringWithoutWhiteSpaces = stringWithoutWhiteSpaces;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public int getLargestNum() {
		return largestNum;
	}
	public void setLargestNum(int largestNum) {
		this.largestNum = largestNum;
	}
	public List<char[]> getDuplicateStr() {
		return duplicateStr;
	}
	public void setDuplicateStr(List<char[]> duplicateStr) {
		this.duplicateStr = duplicateStr;
	}
	public String getStringWithoutWhiteSpaces() {
		return stringWithoutWhiteSpaces;
	}
	public void setStringWithoutWhiteSpaces(String stringWithoutWhiteSpaces) {
		this.stringWithoutWhiteSpaces = stringWithoutWhiteSpaces;
	}
	
	
}
