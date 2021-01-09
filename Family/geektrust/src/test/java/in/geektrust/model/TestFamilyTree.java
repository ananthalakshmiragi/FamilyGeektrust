package in.geektrust.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.service.InitializeTree;
import in.geektrust.service.InitializeTreeImpl;

@TestInstance(Lifecycle.PER_CLASS)
class TestFamilyTree {
	
	private FamilyTree family = new FamilyTree();

	@BeforeAll
	void initTree() {
		InitializeTree buildTree =  new InitializeTreeImpl(family);
		family = buildTree.initializeTheFamilyTree();
	}
	
	@Test
	void testSearchTreeWithValidPersonShouldReturnPerson() {
		Person searchedPerson = family.searchTree(family, FamilyConstants.QUEEN);
		assertNotNull(searchedPerson,"Searched Person should not be null for valid family member");
		assertTrue(searchedPerson instanceof Person,"Search Tree returns a valid Family Member");
	}
	
	@Test
	void testSearchTreeWithInvalidPersonShouldReturnNone() {
		Person searchedPerson = family.searchTree(family, "Anu");
		assertNull(searchedPerson, "Searched Person should is null for valid family member");
	}
}
