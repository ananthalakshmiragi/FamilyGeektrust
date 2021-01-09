package in.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import in.geektrust.model.FamilyTree;

class TestBuildTree {
	
	@Test
	void testIfTreeIsBuilt() {
		
		FamilyTree family = new FamilyTree();
		InitializeTree buildTree =  new InitializeTreeImpl(family);
		assertNotNull(buildTree.initializeTheFamilyTree(),"Initializing tree should return a FamilyTree which is not null");
	}
}