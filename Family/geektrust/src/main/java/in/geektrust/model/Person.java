package in.geektrust.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public enum Gender { MALE, FEMALE }
	
	private Gender gender;
	private String name;
	
	private Person spouse;
	private Person mother;
	private Person father;
	
	private List<Person> children = new ArrayList<Person>();
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Person(String name, Gender gender) {
		this.setName(name);
		this.setGender(gender);
	}

	public Person(Gender gender, String name, Female mother, Male father, List<Person> children) {
		super();
		this.gender = gender;
		this.name = name;
		this.setMother(mother);
		this.setFather(father);
		this.children = children;
	}

	public Person(Person person, Gender gender) {
		super();
		this.gender = gender;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

	public boolean addChild(Person mother, String childName, String gender) {
		try {
			Gender g = (Gender.FEMALE.name().equalsIgnoreCase(gender)?Gender.FEMALE : Gender.MALE);
			Person child = new Person(childName, g);
			child.setMother(mother);
			child.setFather(mother.getSpouse());
			mother.children.add(child);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addChild(Person child) {
		child.setMother(this);
		child.setFather(this.getSpouse());
		return this.children.add(child);
	}

	public Person getSpouse() {
		return this.spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}
}
