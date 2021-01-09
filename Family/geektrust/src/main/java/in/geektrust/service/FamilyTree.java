package in.geektrust.service;

import java.util.ArrayList;
import java.util.List;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.model.Person;

public class FamilyTree {
	
	private Person queen;

	public Person getQueen() {
		return queen;
	}

	public void setQueen(Person queen) {
		this.queen = queen;
	}
	
	public Person searchTree(FamilyTree family, String name) {
		Person person = family.getQueen();
		person = searchPerson(person,name);
		return person;
	}
	
	public Person searchPerson(Person person, String name) {
		Person searchTreeRes = null;
		
		if (name.isEmpty() || person == null) {
			return null;
		}
		if (person.getName().equals(name)) //Self
			return person;
		else {
			if (person.getSpouse()!= null) {
				if (person.getSpouse().getName().equals(name)) {//Spouse
					return person.getSpouse();
				}
			}
		}
		
		//Children
		List<Person> children = new ArrayList<Person>();
		if (person.getGender().name().equalsIgnoreCase(FamilyConstants.Gender.MALE.name())) {
			if (person.getSpouse() != null) {
				children = person.getSpouse().getChildren();
			}
		} else {
			children = person.getChildren();
		}
		for (Person child : children) {
			searchTreeRes = searchPerson(child, name);
			if (person.getName().equalsIgnoreCase(name))
				return person;
			if (searchTreeRes != null)
				break;
			
		}
		return searchTreeRes;
	}
	
	public String addOrGetFamilyElement(FamilyTree familyTree, String input) {
		String[] inputFields = input.split(" ");
		String result = null;
		//Add mother child gender
		if (inputFields[0].equals(FamilyConstants.InputType.ADD_CHILD.name())) {
			AddChild addchild = new AddChildImpl();
			result = addchild.addChildThruMother(familyTree, inputFields[1], inputFields[2], inputFields[3]).name();
		} else {
			//get name relationship
			GetRelationship getRel = new GetRelationshipImpl();
			result = getRel.getRelationship(familyTree, inputFields[1], inputFields[2]);
		}
		System.out.println(result);
		return result;
	}
}
