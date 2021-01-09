package in.geektrust.service;

import in.geektrust.helper.FamilyConstants.Result;

public interface AddChild {

	public Result addChildThruMother(FamilyTree family, String mother, String child, String gender);
	
}
