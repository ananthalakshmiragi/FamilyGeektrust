package in.geektrust.service;

import in.geektrust.model.FamilyTree;

public interface GetRelationship {

	String getRelationship(FamilyTree family, String name, String rel);
	
}
