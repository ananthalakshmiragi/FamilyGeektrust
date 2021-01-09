package in.geektrust.service;

import in.geektrust.model.Person;

public interface AddSpouse {

	public Person addWife(FamilyTree family, String husband, String wife);
	
	public Person addHusband(FamilyTree family, String wife, String husband);
	
}
