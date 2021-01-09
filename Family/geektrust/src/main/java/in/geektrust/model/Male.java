package in.geektrust.model;

import java.util.List;

public class Male extends Person {

	public Male(String name) {
		super(name, Person.Gender.MALE);
	}
	
	public Male(Person person) {
		super(person, Person.Gender.MALE);
	}

	public Male(String name, Female mother, Male father, List<Person> children, Female spouse) {
		super(Person.Gender.MALE, name, mother, father, children);
	}
}
