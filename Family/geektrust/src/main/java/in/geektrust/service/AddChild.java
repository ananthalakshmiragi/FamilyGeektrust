package in.geektrust.service;

import in.geektrust.helper.FamilyConstants.Result;
import in.geektrust.model.FamilyTree;

public interface AddChild {

	Result addChildThruMother(FamilyTree family, String mother, String child, String gender);
	
}
