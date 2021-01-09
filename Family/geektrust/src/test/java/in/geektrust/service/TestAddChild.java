package in.geektrust.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestAddChild {
	
	private FamilyTree family = new FamilyTree();
	
	@Test
	public void testIfAddsChild() {
		
		AddChild addChild =  new AddChildImpl();
		assertNotNull(addChild.addChildThruMother(family, "Mother", "child", "Female"));
	}
}