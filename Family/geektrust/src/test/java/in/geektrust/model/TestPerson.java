package in.geektrust.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class TestPerson {
	
	@Test
	void testAddingMaleChildShouldBeSuccessful() {
		
		Person person = new Person("Person", Person.Gender.FEMALE);
		Person child  = new Person("Child", Person.Gender.MALE);
		
		assertTrue(person.addChild(child),"Adding Male Child is successful");
	}
	
	@Test
	void testAddingFemaleChildShouldBeSuccessful() {
		
		Person person = new Person("Person", Person.Gender.FEMALE);
		Person child  = new Person("Child", Person.Gender.FEMALE);
		
		assertTrue(person.addChild(child),"Adding Female Child is successful");
	}
}
