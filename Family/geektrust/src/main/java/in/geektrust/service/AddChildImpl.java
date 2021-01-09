package in.geektrust.service;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.helper.FamilyConstants.Result;
import in.geektrust.model.Person;

public class AddChildImpl extends FamilyTree implements AddChild {

	@Override
	public Result addChildThruMother(FamilyTree family, String mother, String child, String gender) {
		Person m = searchTree(family,mother);
		if (m == null)
			return FamilyConstants.Result.PERSON_NOT_FOUND;
		if (m.getGender().name().equals(FamilyConstants.Gender.MALE.name()))
			return FamilyConstants.Result.CHILD_ADDITION_FAILED;
		if (m.addChild(m, child, gender))
			return FamilyConstants.Result.CHILD_ADDITION_SUCCEEDED;
		else 
			return FamilyConstants.Result.CHILD_ADDITION_FAILED;
	}
	
}
