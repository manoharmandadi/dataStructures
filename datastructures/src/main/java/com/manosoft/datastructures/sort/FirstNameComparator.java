package com.manosoft.datastructures.sort;

import java.util.Comparator;

import com.manosoft.datastructures.model.Person;

/**
Class level comment added
*/
public class FirstNameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		return (p1.getfName().compareTo(p2.getfName()));
	}
	
	
	
}
