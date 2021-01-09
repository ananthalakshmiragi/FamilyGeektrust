package in.geektrust.service;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.helper.FamilyConstants.Result;
import in.geektrust.model.FamilyTree;
import in.geektrust.model.Person;

public class AddChildImpl implements AddChild {

	@Override
	public Result addChildThruMother(FamilyTree family, String mother, String child, String gender) {
		Person m = family.searchTree(family,mother);
		Result result;
		if (m == null) {
			result = FamilyConstants.Result.PERSON_NOT_FOUND;
		} else {
			if (m.getGender().name().equals(FamilyConstants.Gender.MALE.name())) {
				result = FamilyConstants.Result.CHILD_ADDITION_FAILED;
			} else if (m.addChild(m, child, gender)) {
				result = FamilyConstants.Result.CHILD_ADDITION_SUCCEEDED;
			} else {
				result = FamilyConstants.Result.CHILD_ADDITION_FAILED;
			}
		}
		return result;
	}
	
}
