package in.geektrust.model;

import java.util.List;

public class Female extends Person {

	public Female(String name) {
		super(name, Person.Gender.FEMALE);
	}
	
	public Female(Person person) {
		super(person, Person.Gender.FEMALE);
	}

	public Female(String name, Female mother, Male father, List<Person> children, Male spouse) {
		super(Person.Gender.FEMALE, name, mother, father, children);
	}

}
