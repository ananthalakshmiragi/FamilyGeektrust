package in.geektrust.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestBuildTree {
	
	private FamilyTree familyTree = new FamilyTree();
	
	@Test
	public void testIfTreeIsBuilt() {
		
		BuildTree buildTree =  new BuildTreeImpl();
		assertNotNull(buildTree.buildTheFamilyTree(familyTree));
	}
}