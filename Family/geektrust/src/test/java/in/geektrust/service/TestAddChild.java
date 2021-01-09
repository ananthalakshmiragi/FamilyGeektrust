package in.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.model.FamilyTree;

@TestInstance(Lifecycle.PER_CLASS)
class TestAddChild {
	
	private FamilyTree family = new FamilyTree();
	
	@BeforeAll
	void initTree() {
		InitializeTree buildTree =  new InitializeTreeImpl(family);
		family = buildTree.initializeTheFamilyTree();
	}
	
	@Test
	void testChildAdditionThruMotherShouldReturnSuccess() {
		
		AddChild addChild =  new AddChildImpl();
		assertEquals(FamilyConstants.Result.CHILD_ADDITION_SUCCEEDED,addChild.addChildThruMother(family, FamilyConstants.QUEEN, "child", "Female"),"Child addition should be successful when added through Mother");
	}
	
	@Test
	void testChildAdditionThruFatherShouldReturnFailure() {
		
		AddChild addChild =  new AddChildImpl();
		assertEquals(FamilyConstants.Result.CHILD_ADDITION_FAILED,addChild.addChildThruMother(family, "King Shan", "child", "Female"),"Child addition should have failed as added through Husband");
	}
}