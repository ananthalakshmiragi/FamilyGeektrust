package in.geektrust.service;

import in.geektrust.model.Person;
//import in.geektrust.model.Female;
//import in.geektrust.model.Male;
import in.geektrust.model.Person.Gender;

public class BuildTreeImpl implements BuildTree {
	
	FamilyTree familyTree = new FamilyTree();
	
	public FamilyTree getFamilyTree() {
		return familyTree;
	}

	public void setFamilyTree(FamilyTree familyTree) {
		this.familyTree = familyTree;
	}

	public FamilyTree buildTheFamilyTree(FamilyTree f) {
		
		//Couple
		Person queen = new Person("Queen Anga", Gender.FEMALE);
		familyTree.setQueen(queen);
		queen.setSpouse(new Person("King Shan", Gender.MALE));
		
		//Sons Daughters
		AddChild addchild = new AddChildImpl();
		addchild.addChildThruMother(familyTree,"Queen Anga","Chit","Male");
		addchild.addChildThruMother(familyTree,"Queen Anga","Ish","Male");
		addchild.addChildThruMother(familyTree,"Queen Anga","Vich","Male");
		addchild.addChildThruMother(familyTree,"Queen Anga","Aras","Male");
		addchild.addChildThruMother(familyTree,"Queen Anga","Satya","Female");
		
		//Daughter in laws Son in laws
		AddSpouse spouse = new AddSpouseImpl();
		spouse.addWife(familyTree,"Chit", "Amba");
		spouse.addWife(familyTree,"Vich", "Lika");
		spouse.addWife(familyTree,"Aras", "Chitra");
		spouse.addHusband(familyTree,"Satya", "Vyan");

		//Grandchildren
		addchild.addChildThruMother(familyTree,"Amba","Dritha","Female");
		addchild.addChildThruMother(familyTree,"Amba","Tritha","Female");
		addchild.addChildThruMother(familyTree,"Amba","Vritha","Male");
		addchild.addChildThruMother(familyTree,"Lika","Vila","Female");
		addchild.addChildThruMother(familyTree,"Lika","Chika","Female");
		addchild.addChildThruMother(familyTree,"Chitra","Jnki","Female");
		addchild.addChildThruMother(familyTree,"Chitra","Ahit","Male");
		addchild.addChildThruMother(familyTree,"Satya","Asva","Male");
		addchild.addChildThruMother(familyTree,"Satya","Vyas","Male");
		addchild.addChildThruMother(familyTree,"Satya","Atya","Female");

		spouse.addHusband(familyTree,"Dritha", "Jaya");
		spouse.addHusband(familyTree,"Jnki", "Arit");
		spouse.addWife(familyTree,"Asva", "Satvy");
		spouse.addWife(familyTree,"Vyas", "Krpi");
		
		//GreatGrandChildren
		addchild.addChildThruMother(familyTree,"Dritha","Yodhan","Male");
		addchild.addChildThruMother(familyTree,"Jnki","Laki","Male");
		addchild.addChildThruMother(familyTree,"Jnki","Lavnya","Female");
		addchild.addChildThruMother(familyTree,"Satvy","Vasa","Male");
		addchild.addChildThruMother(familyTree,"Krpi","Kriya","Male");
		addchild.addChildThruMother(familyTree,"Krpi","Krithi","Female");
		
		return familyTree;
	}

}
