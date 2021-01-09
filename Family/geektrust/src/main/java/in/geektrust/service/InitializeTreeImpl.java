package in.geektrust.service;

import in.geektrust.helper.FamilyConstants;
import in.geektrust.model.FamilyTree;
import in.geektrust.model.Person;
import in.geektrust.model.Person.Gender;

public class InitializeTreeImpl implements InitializeTree {
	
	private FamilyTree familyTree;
	
	public InitializeTreeImpl(FamilyTree familyTree) {
		this.familyTree = familyTree;
	}
	
	public FamilyTree getFamilyTree() {
		return familyTree;
	}

	public void setFamilyTree(FamilyTree familyTree) {
		this.familyTree = familyTree;
	}

	private FamilyTree initializeCouple() {

		Person queen = new Person(FamilyConstants.QUEEN, Gender.FEMALE);
		queen.setSpouse(new Person("King Shan", Gender.MALE));
		
		//initiate the tree
		this.familyTree = new FamilyTree(queen);
		this.familyTree = initializeOffsprings();
		
		return this.familyTree;
	}
	
	private FamilyTree initializeOffsprings() {

		//Sons Daughters
		AddChild addchild = new AddChildImpl();
		addchild.addChildThruMother(this.familyTree,FamilyConstants.QUEEN,"Chit",FamilyConstants.MALE);
		addchild.addChildThruMother(this.familyTree,FamilyConstants.QUEEN,"Ish",FamilyConstants.MALE);
		addchild.addChildThruMother(this.familyTree,FamilyConstants.QUEEN,"Vich",FamilyConstants.MALE);
		addchild.addChildThruMother(this.familyTree,FamilyConstants.QUEEN,"Aras",FamilyConstants.MALE);
		addchild.addChildThruMother(this.familyTree,FamilyConstants.QUEEN,"Satya",FamilyConstants.FEMALE);

		this.familyTree = initializeOffspringSpouses();
		
		return this.familyTree;
	}
	
	private FamilyTree initializeOffspringSpouses() {

		//Daughter in laws Son in laws
		AddSpouse spouse = new AddSpouseImpl();
		spouse.addWife(familyTree,"Chit", "Amba");
		spouse.addWife(familyTree,"Vich", "Lika");
		spouse.addWife(familyTree,"Aras", FamilyConstants.CHITRA);
		spouse.addHusband(familyTree,"Satya", "Vyan");

		this.familyTree = initializeGrandchildren();
		
		return this.familyTree;
	}
	
	private FamilyTree initializeGrandchildren() {

		//Grandchildren
		AddChild addchild = new AddChildImpl();
		addchild.addChildThruMother(familyTree,"Amba","Dritha",FamilyConstants.FEMALE);
		addchild.addChildThruMother(familyTree,"Amba","Tritha",FamilyConstants.FEMALE);
		addchild.addChildThruMother(familyTree,"Amba","Vritha",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Lika","Vila",FamilyConstants.FEMALE);
		addchild.addChildThruMother(familyTree,"Lika","Chika",FamilyConstants.FEMALE);
		addchild.addChildThruMother(familyTree,FamilyConstants.CHITRA,"Jnki",FamilyConstants.FEMALE);
		addchild.addChildThruMother(familyTree,FamilyConstants.CHITRA,"Ahit",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Satya","Asva",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Satya","Vyas",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Satya","Atya",FamilyConstants.FEMALE);

		this.familyTree = initializeGrandchildrenSpouses();
		
		return this.familyTree;
	}
	
	private FamilyTree initializeGrandchildrenSpouses() {

		AddSpouse spouse = new AddSpouseImpl();
		spouse.addHusband(familyTree,"Dritha", "Jaya");
		spouse.addHusband(familyTree,"Jnki", "Arit");
		spouse.addWife(familyTree,"Asva", "Satvy");
		spouse.addWife(familyTree,"Vyas", "Krpi");
		
		this.familyTree = initializeGreatGrandchildren();
		
		return this.familyTree;
	}

	private FamilyTree initializeGreatGrandchildren() {

		//GreatGrandChildren
		AddChild addchild = new AddChildImpl();
		addchild.addChildThruMother(familyTree,"Dritha","Yodhan",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Jnki","Laki",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Jnki","Lavnya",FamilyConstants.FEMALE);
		addchild.addChildThruMother(familyTree,"Satvy","Vasa",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Krpi","Kriya",FamilyConstants.MALE);
		addchild.addChildThruMother(familyTree,"Krpi","Krithi",FamilyConstants.FEMALE);
		
		return this.familyTree;
	}
	
	public FamilyTree initializeTheFamilyTree() {
		
		this.familyTree = initializeCouple();
		
		return this.familyTree;
	}

}
