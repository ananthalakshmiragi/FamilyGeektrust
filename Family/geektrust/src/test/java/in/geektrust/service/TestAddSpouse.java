package in.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import in.geektrust.model.FamilyTree;
import in.geektrust.model.Person;

@TestInstance(Lifecycle.PER_CLASS)
class TestAddSpouse {
	
	private FamilyTree family = new FamilyTree();
	
	@BeforeAll
	public void initTree() {
		InitializeTree buildTree =  new InitializeTreeImpl(family);
		family = buildTree.initializeTheFamilyTree();
	}
	
	@Test
	void testIfAddsHusband() {
		AddSpouse addSpouse =  new AddSpouseImpl();
		Person person = addSpouse.addHusband(family, "Vila", "Husband");
		assertNotNull(person.getSpouse(),"Added spouse should return wife with added husband");
		assertTrue(person instanceof Person,"Added Husband to Wife");
	}
	
	@Test
	void testIfAddsWife() {
		AddSpouse addSpouse =  new AddSpouseImpl();
		assertNotNull(addSpouse.addWife(family, "Ahit", "Wife"),"Added spouse should return person back");
	}
	
}