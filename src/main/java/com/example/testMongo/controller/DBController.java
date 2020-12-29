package com.example.testMongo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testMongo.model.Incoming;
import com.example.testMongo.model.Outgoing;
import com.example.testMongo.repository.IncomingRepository;
import com.example.testMongo.repository.OutgoingRepository;

@RestController
@RequestMapping(value = "/")
public class DBController {

	@Autowired
	private  IncomingRepository incomingRepository;
	
	@Autowired
	private  OutgoingRepository outgoingRepository;
	
	@PostMapping(value = "/addEntry")
	public String addEntry(@RequestBody Incoming incoming) {
		List<Integer> newList;
		String duplicateString;
		String whiteSpaces;
		try {
		newList = new ArrayList<Integer>((List)incoming.getInto().get("numbersMeetNumbers"));
		duplicateString = String.valueOf(incoming.getInto().get("findDuplicates"));
		whiteSpaces = String.valueOf(incoming.getInto().get("whiteSpacesGalore"));
		
		}catch(ClassCastException exception) {
			return "invalid Data Type";
		}
		int largestNum = newList.stream().max(Comparator.comparing(Integer::valueOf)).get();
		List<char[]> duplicates = findDuplicates(duplicateString);
		String removedWhiteSpaces = removeSpaces(whiteSpaces);
		Outgoing outgoing = new Outgoing(incoming.getId(), largestNum, duplicates, removedWhiteSpaces);
		
		incomingRepository.save(incoming);
		outgoingRepository.save(outgoing);
		return incoming.getId();
		
	}
	
	@GetMapping(value = "/find/{id}")
	public Outgoing findEntry(@PathVariable(name = "id")String id) throws Exception {
		Outgoing outgoing = outgoingRepository.findById(id).get();
		if(outgoing != null)
			return outgoing;
		else {
			throw new Exception();
		}
		
	}

	private String removeSpaces(String whiteSpaces) {
		StringBuilder str = new StringBuilder();
		for(char ch : whiteSpaces.toCharArray()) {
			if(ch != ' ') {
				str.append(ch);
			}
		}
		return str.toString();
	}

	private List<char[]> findDuplicates(String duplicateString) {
		char stringArray[] = duplicateString.toCharArray();  
		List<char[]> input = Arrays.asList(stringArray);
		List<char[]> result = Stream.of(stringArray).filter(i->Collections.frequency(input, i)>1).collect(Collectors.toList());
		return result;
	}
}
