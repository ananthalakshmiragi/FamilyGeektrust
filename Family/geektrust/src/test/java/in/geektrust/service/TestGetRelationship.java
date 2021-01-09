package in.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.model.FamilyTree;

@TestInstance(Lifecycle.PER_CLASS)
class TestGetRelationship {
	
	private FamilyTree family = new FamilyTree();
	
	@BeforeAll
	void initTree() {
		InitializeTree buildTree =  new InitializeTreeImpl(family);
		family = buildTree.initializeTheFamilyTree();
	}
	
	@Test
	void testGettingSomeRelationShouldReturnSuccess() {

		GetRelationship getRel =  new GetRelationshipImpl();
		assertEquals("Tritha",getRel.getRelationship(family, "Yodhan", FamilyConstants.MATERNAL_AUNT),"Maternal Aunt should be Tritha.");
	}
	
	@Test
	void testGettingRelationOfInexistentMemberShouldReturnPersonNotFound() {

		GetRelationship getRel =  new GetRelationshipImpl();
		assertEquals(FamilyConstants.Result.PERSON_NOT_FOUND.name(),getRel.getRelationship(family, "Anu", FamilyConstants.SIBLINGS),"Anu does not exist and returns person not found.");
	}
	
	@Test
	void testGettingRelationWithNoMembersShouldReturnNone() {

		GetRelationship getRel =  new GetRelationshipImpl();
		assertEquals(FamilyConstants.Result.NONE.name(),getRel.getRelationship(family, "Vila", FamilyConstants.BROTHER_IN_LAW),"Vila does not have Bro in Law. Should return None.");
	}
}