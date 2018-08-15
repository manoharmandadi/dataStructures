package com.ds.sort.simple;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		return (p1.getfName().compareTo(p2.getfName()));
	}
	
	
	
}
