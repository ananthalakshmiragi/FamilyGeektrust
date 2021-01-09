package in.geektrust.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public enum Gender { MALE, FEMALE }
	
	private Gender gender;
	private String name;
	
	private Person spouse;
//	private Female mother;
//	private Male father;
	private Person mother;
	private Person father;
	
//	private List<Male> sons = new ArrayList<>();
//	private List<Female> daughters = new ArrayList<>();
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

//	public Female getMother() {
//		return mother;
//	}

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

//	public void setMother(Female mother) {
//		this.mother = mother;
//	}

//	public Male getFather() {
//		return father;
//	}

//	public void setFather(Male father) {
//		this.father = father;
//	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}

//	public List<Male> getSons() {
//		return sons;
//	}
//
//	public void setSons(List<Male> sons) {
//		this.sons = sons;
//	}
//
//	public List<Female> getDaughters() {
//		return daughters;
//	}
//
//	public void setDaughters(List<Female> daughters) {
//		this.daughters = daughters;
//	}
	
	public boolean addChild(Person mother, String childName, String gender) {
		try {
			Gender g = (Gender.FEMALE.name().equalsIgnoreCase(gender)?Gender.FEMALE : Gender.MALE);
			Person child = new Person(childName, g);
			child.setMother(mother);
			child.setFather(mother.getSpouse());
//			if (child.getGender().equals(Gender.FEMALE)) {
//				daughters.add(new Female(child));
//			} else {
//				sons.add(new Male(child));
//			}
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
//		if (child.getGender().equals(Gender.FEMALE)) {
//			daughters.add(new Female(child));
//		} else {
//			sons.add(new Male(child));
//		}
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
