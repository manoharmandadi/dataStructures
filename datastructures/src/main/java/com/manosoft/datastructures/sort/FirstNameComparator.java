package com.manosoft.datastructures.sort;

import java.util.Comparator;

import com.manosoft.datastructures.model.Person;

/**
Class level comment added
Confliecting clss level comments
*/
public class FirstNameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		return (p1.getFirstName().compareTo(p2.getFirstName()));
	}
	
	
	
}
