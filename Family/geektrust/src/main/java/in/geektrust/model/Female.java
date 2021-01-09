package in.geektrust.model;

import java.util.List;

public class Female extends Person {

//	private Male spouse;
	
	public Female(String name) {
		super(name, Person.Gender.FEMALE);
		// TODO Auto-generated constructor stub
	}
	
	public Female(Person person) {
		super(person, Person.Gender.FEMALE);
		// TODO Auto-generated constructor stub
	}

	public Female(String name, Female mother, Male father, List<Person> children, Male spouse) {
		super(Person.Gender.FEMALE, name, mother, father, children);
//		this.spouse = spouse;
	}

//	public Male getSpouse() {
//		return spouse;
//	}
//
//	public void setSpouse(Male spouse) {
//		this.spouse = spouse;
//	}

}
