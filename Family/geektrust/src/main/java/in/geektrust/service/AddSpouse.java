package in.geektrust.service;

import in.geektrust.model.FamilyTree;
import in.geektrust.model.Person;

public interface AddSpouse {

	Person addWife(FamilyTree family, String husband, String wife);
	
	Person addHusband(FamilyTree family, String wife, String husband);
	
}
