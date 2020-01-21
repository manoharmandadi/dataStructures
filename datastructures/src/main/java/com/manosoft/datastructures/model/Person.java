package com.manosoft.datastructures.model;

public class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private int id;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String toString() {
		return id + " " + firstName + " " + lastName;
	}

	public int compareTo(Person o) {
		Person p = (Person) o;
		if (this.id > p.id) {
			return 1;
		} else if (this.id == p.id) {
			return 0;
		} else {
			return -1;
		}
	}

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
