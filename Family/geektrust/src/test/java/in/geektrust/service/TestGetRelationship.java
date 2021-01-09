package in.geektrust.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestGetRelationship {
	
	private FamilyTree family = new FamilyTree();
	
	@Test
	public void testIfRelationIsFetched() {
		
		GetRelationship getRel =  new GetRelationshipImpl();
		assertNotNull(getRel.getRelationship(family, "", ""));
	}
}