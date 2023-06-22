package com.example.myapp;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {
	private Person person;
	private List<Object> lists; //setLists
	private Set<Object> sets;
	private Map<String, Object> maps;
	private Properties props;
}
