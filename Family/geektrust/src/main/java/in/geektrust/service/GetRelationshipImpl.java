package in.geektrust.service;

import java.util.stream.Collectors;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.helper.FamilyConstants.Relationships;
import in.geektrust.helper.FamilyConstants.Result;
import in.geektrust.model.Person;

public class GetRelationshipImpl implements GetRelationship {

	public String getRelationship(FamilyTree family, String name, String inpRel) {
		String resultRelatives = "";
		
		FamilyTree f = new FamilyTree();
		Person person = f.searchTree(family,name);
		if (person == null)
			return Result.PERSON_NOT_FOUND.toString();
		
		Relationships rel = Relationships.fromRelShip(inpRel);
		
		switch (rel) {
		
		case PATERNAL_UNCLE:
			if (person.getFather() != null)
				if (person.getFather().getMother() != null)
					resultRelatives = person.getFather().getMother()
						.getChildren()
						.stream()
						.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
						.filter(p -> !p.getName().equals(person.getFather().getName()))
						.map(p -> p.getName())
						.collect(Collectors.joining(" "));
			break;
			
		case MATERNAL_UNCLE:
			if (person.getMother() != null)
				if (person.getMother().getMother() != null)
					resultRelatives = person.getMother().getMother()
						.getChildren()
						.stream()
						.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
						.filter(p -> !p.getName().equals(person.getFather().getName()))
						.map(p -> p.getName())
						.collect(Collectors.joining(" "));
			break;
			
		case PATERNAL_AUNT:
			if (person.getFather() != null) 
				if (person.getFather().getMother() != null) 
					resultRelatives = person.getFather().getMother()
						.getChildren()
						.stream()
						.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
						.filter(p -> !p.getName().equals(person.getMother().getName()))
						.map(p -> p.getName())
						.collect(Collectors.joining(" "));
			break;
		
		case MATERNAL_AUNT:
			if (person.getMother() != null)
				if (person.getMother().getMother() != null)
				resultRelatives = person.getMother().getMother()
					.getChildren()
					.stream()
					.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
					.filter(p -> !p.getName().equals(person.getMother().getName()))
					.map(p -> p.getName())
					.collect(Collectors.joining(" "));
			break;
		
		case SISTER_IN_LAW:
			//spouse sisters
			if (person.getSpouse() != null)
				if (person.getSpouse().getMother() != null)
					resultRelatives = person.getSpouse().getMother()
						.getChildren()
						.stream()
						.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
						.map(p -> p.getName())
						.collect(Collectors.joining(" "));
			//siblings wives
			if (person.getMother() != null)
				resultRelatives += person.getMother()
					.getChildren()
					.stream()
					.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
					.filter(p -> p.getSpouse()!= null)
					.filter(p -> !p.getName().equals(person.getName()))
					.map(p -> p.getSpouse().getName())
					.collect(Collectors.joining(" "));
			break;
			
		case BROTHER_IN_LAW:
			if (person.getSpouse() != null)
				if (person.getSpouse().getMother() != null)
				//spouse bros
				resultRelatives = person.getSpouse().getMother()
					.getChildren()
					.stream()
					.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
					.map(p -> p.getName())
					.collect(Collectors.joining(" "));
			//siblings husbands
			if (person.getMother() != null)
				resultRelatives += person.getMother()
					.getChildren()
					.stream()
					.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
					.filter(p -> p.getSpouse()!= null)
					.filter(p -> !p.getName().equals(person.getSpouse().getName()))
					.map(p -> p.getSpouse().getName())
					.collect(Collectors.joining(" "));
			break;
		
		case SON:
			resultRelatives = person.getChildren()
					.stream()
					.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
					.filter(p -> !p.getName().equals(person.getName()))
					.map(p -> p.getName())
					.collect(Collectors.joining(" "));
			break;
			
		case DAUGHTER:
			resultRelatives = person.getChildren()
					.stream()
					.filter(p -> p.getGender().name().equals(FamilyConstants.Gender.FEMALE.name()))
					.filter(p -> !p.getName().equals(person.getName()))
					.map(p -> p.getName())
					.collect(Collectors.joining(" "));
			break;
			
		case SIBLINGS:
			if (person.getMother() != null)
				resultRelatives = person.getMother()
					.getChildren()
					.stream()
					.filter(p -> !p.getName().equals(person.getName()))
					.map(p -> p.getName())
					.collect(Collectors.joining(" "));
			break;
		}
		if (resultRelatives != null)
			if (resultRelatives.isEmpty())
				resultRelatives = null;
//		System.out.println((resultRelatives == null ? Result.NONE.toString() : resultRelatives));
		return (resultRelatives == null ? Result.NONE.toString() : resultRelatives);
	}

}
