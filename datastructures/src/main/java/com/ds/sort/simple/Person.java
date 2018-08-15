package com.ds.sort.simple;

public class Person implements Comparable<Person> {
	private String fName;
	private String lName;
	private int ID;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String fName, String lName){
		this.ID = id;
		this.fName = fName;
		this.lName = lName;
	}
	
	public String toString(){
		return ID + " "+fName +" "+lName;
	}
	
	
	public int compareTo(Person o) {
		Person p =(Person) o;
		if(this.ID > p.ID){
			return 1;
		} else if (this.ID == p.ID) {
			return 0;
		} else {
			return -1;
		}
	}



	public String getfName() {
		return fName;
	}



	public void setfName(String fName) {
		this.fName = fName;
	}



	public String getlName() {
		return lName;
	}



	public void setlName(String lName) {
		this.lName = lName;
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	};
}
