package in.geektrust.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import in.geektrust.model.Person;

public class TestAddSpouse {
	
	private FamilyTree family = new FamilyTree();
	
	@Test
	public void testIfAddsHusband() {
		Person queen = new Person("Queen", Person.Gender.FEMALE);
		family.setQueen(queen);
		AddSpouse addSpouse =  new AddSpouseImpl();
		assertNotNull(addSpouse.addHusband(family, "Queen", "Husband"));
	}
	
	@Test
	public void testIfAddsWife() {
		Person queen = new Person("Queen", Person.Gender.FEMALE);
		family.setQueen(queen);
		queen.addChild(queen, "Husband", "Male");
		AddSpouse addSpouse =  new AddSpouseImpl();
		assertNotNull(addSpouse.addWife(family, "Husband", "Wife"));
	}
	
}