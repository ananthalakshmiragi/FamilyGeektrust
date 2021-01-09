package in.geektrust.service;

import in.geektrust.model.Person;
import in.geektrust.model.Person.Gender;

public class AddSpouseImpl extends FamilyTree implements AddSpouse {

	@Override
	public Person addWife(FamilyTree family, String husband, String wife) {
		Person hub = searchTree(family,husband);
		if (hub != null) {
			Person f = new Person(wife,Gender.FEMALE);
			f.setSpouse(hub);
			hub.setSpouse(f);
		}
		return hub;
	}

	@Override
	public Person addHusband(FamilyTree family, String wife, String husband) {
		Person wify = searchTree(family,wife);
		if (wify != null) {
			Person m = new Person(husband,Gender.MALE);
			m.setSpouse(wify);
			wify.setSpouse(m);
		}
		return wify;
	}

}
