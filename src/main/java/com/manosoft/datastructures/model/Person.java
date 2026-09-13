package com.manosoft.datastructures.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements Comparable<Person> {

	private String fName;
	private String lName;
	private int ID;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String fName, String lName) {
		this.ID = id;
		this.fName = fName;
		this.lName = lName;
	}

	public String toString() {
		return ID + " " + fName + " " + lName;
	}

	public int compareTo(Person p) {
		if (this.ID > p.ID) {
			return 1;
		} else if (this.ID == p.ID) {
			return 0;
		} else {
			return -1;
		}
	}

}
