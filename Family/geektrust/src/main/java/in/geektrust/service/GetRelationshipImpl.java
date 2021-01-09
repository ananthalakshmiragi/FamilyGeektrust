package in.geektrust.service;

import java.util.stream.Collectors;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.helper.FamilyConstants.Relationships;
import in.geektrust.helper.FamilyConstants.Result;
import in.geektrust.model.FamilyTree;
import in.geektrust.model.Person;

public class GetRelationshipImpl implements GetRelationship {

	public String getRelationship(FamilyTree family, String name, String inpRel) {
		
		Person person = family.searchTree(family,name);
		if (person == null) {
			return Result.PERSON_NOT_FOUND.toString();
		}
		
		Relationships rel = Relationships.fromRelShip(inpRel);
		String resultRelatives = "";
		
		switch (rel) {
		
			case PATERNAL_UNCLE:
				resultRelatives = findPaternalUncle(person);
				break;
			
			case MATERNAL_UNCLE:
				resultRelatives = findMaternalUncle(person);
				break;
			
			case PATERNAL_AUNT:
				resultRelatives = findPaternalAunt(person);
				break;
		
			case MATERNAL_AUNT:
				resultRelatives = findMaternalAunt(person);
				break;
		
			case SISTER_IN_LAW:
				resultRelatives = findSisterInLaw(person);
				break;
			
			case BROTHER_IN_LAW:
				resultRelatives = findBrotherInLaw(person);
				break;
		
			case SON:
				resultRelatives = findSons(person);
				break;
			
			case DAUGHTER:
				resultRelatives = findDaughters(person);
				break;
			
			case SIBLINGS:
				resultRelatives = findSiblings(person);
				break;
		}
		if ((resultRelatives != null && resultRelatives.isEmpty()) || resultRelatives == null) {
			resultRelatives = Result.NONE.toString();
		}
		return resultRelatives;
	}


	private static String findPaternalUncle(Person person) {

		String resultRelatives = "";
		if (person.getFather() != null && person.getFather().getMother() != null) {
			resultRelatives = person.getFather().getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
				.filter(p -> !p.getName().equals(person.getFather().getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		return resultRelatives;
	}

	private static String findMaternalUncle(Person person) {
		String resultRelatives = "";
		if (person.getMother() != null && person.getMother().getMother() != null) {
			resultRelatives = person.getMother().getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
				.filter(p -> !p.getName().equals(person.getFather().getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		return resultRelatives;
	}

	private static String findPaternalAunt(Person person) {
		String resultRelatives = "";
		if (person.getFather() != null && person.getFather().getMother() != null) {
			resultRelatives = person.getFather().getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
				.filter(p -> !p.getName().equals(person.getMother().getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		return resultRelatives;
	}

	private static String findMaternalAunt(Person person) {
		String resultRelatives = "";

		if (person.getMother() != null && person.getMother().getMother() != null) {
			resultRelatives = person.getMother().getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
				.filter(p -> !p.getName().equals(person.getMother().getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		System.out.println("resultRelatives" + resultRelatives);
		return resultRelatives;
	}
	
	private static String findSisterInLaw(Person person) {
		String resultRelatives = "";
		//spouse sisters
		if (person.getSpouse() != null && person.getSpouse().getMother() != null) {
			resultRelatives = person.getSpouse().getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		//siblings wives
		if (person.getMother() != null) {
			resultRelatives += person.getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
				.filter(p -> p.getSpouse()!= null)
				.filter(p -> !p.getName().equals(person.getName()))
				.map(p -> p.getSpouse().getName())
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		
		return resultRelatives;
	}
	
	private static String findBrotherInLaw(Person person) {
		String resultRelatives = "";
		//spouse bros
		if (person.getSpouse() != null && person.getSpouse().getMother() != null) {
			resultRelatives = person.getSpouse().getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		//siblings husbands
		if (person.getMother() != null) {
			resultRelatives += person.getMother()
				.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
				.filter(p -> p.getSpouse()!= null)
				.filter(p -> !p.getName().equals(person.getSpouse().getName()))
				.map(p -> p.getSpouse().getName())
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		return resultRelatives;
	}
	
	private static String findSons(Person person) {
		
		return person.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
				.filter(p -> !p.getName().equals(person.getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
	}
	
	private static String findDaughters(Person person) {
		
		return person.getChildren()
				.stream()
				.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
				.filter(p -> !p.getName().equals(person.getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
	}
	
	private static String findSiblings(Person person) {
		String resultRelatives = "";
		
		if (person.getMother() != null) {
			resultRelatives = person.getMother()
				.getChildren()
				.stream()
				.filter(p -> !p.getName().equals(person.getName()))
				.map(Person::getName)
				.collect(Collectors.joining(FamilyConstants.SPACE));
		}
		
		return resultRelatives;
	}
}
