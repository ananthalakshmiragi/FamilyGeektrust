package in.geektrust.model;

import java.util.List;

public class Male extends Person {

//	private Female spouse;
	
	public Male(String name) {
		super(name, Person.Gender.MALE);
		// TODO Auto-generated constructor stub
	}
	
	public Male(Person person) {
		super(person, Person.Gender.MALE);
		// TODO Auto-generated constructor stub
	}

	public Male(String name, Female mother, Male father, List<Person> children, Female spouse) {
		super(Person.Gender.MALE, name, mother, father, children);
//		this.spouse = spouse;
	}

//	public Female getSpouse() {
//		return spouse;
//	}
//	
//	public void setSpouse(Female spouse) {
//		this.spouse = spouse;
//	}

}
