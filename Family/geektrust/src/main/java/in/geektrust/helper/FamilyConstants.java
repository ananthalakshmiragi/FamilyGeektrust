package in.geektrust.helper;

public class FamilyConstants {
	
	public enum Gender {
		FEMALE,
		MALE
	}
	
	public enum Result {
		CHILD_ADDITION_SUCCEEDED,
		PERSON_NOT_FOUND,
		CHILD_ADDITION_FAILED,
		NONE
	}
	
	public enum BuildTreeInst {
		ADD_CHILD,
		ADD_SPOUSE
	}
	
	public enum InputType {
		ADD_CHILD,
		GET_RELATIONSHIP
	}
	
	public static final String PATERNAL_UNCLE = "Paternal-Uncle";
	public static final String MATERNAL_UNCLE = "Maternal-Uncle";
	public static final String PATERNAL_AUNT = "Paternal-Aunt";
	public static final String MATERNAL_AUNT = "Maternal-Aunt";
	public static final String SISTER_IN_LAW = "Sister-In-Law";
	public static final String BROTHER_IN_LAW = "Brother-In-Law";
	public static final String SON = "Son";
	public static final String DAUGHTER = "Daughter";
	public static final String SIBLINGS = "Siblings";
	
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	
	public static final String QUEEN = "Queen Anga";
	public static final String CHITRA = "Chitra";
	
	public static final String SPACE = " ";
	
	public enum Relationships {

		PATERNAL_UNCLE("Paternal-Uncle"),
		MATERNAL_UNCLE("Maternal-Uncle"),
		PATERNAL_AUNT("Paternal-Aunt"),
		MATERNAL_AUNT("Maternal-Aunt"),
		SISTER_IN_LAW("Sister-In-Law"),
		BROTHER_IN_LAW("Brother-In-Law"),
		SON("Son"),
		DAUGHTER("Daughter"),
		SIBLINGS("Siblings");
		
	    private final String relShip;

		private Relationships(String relShipVal) {
	        this.relShip = relShipVal;
	    }
		
		public String getRelShip() {
	        return relShip;
	    }
		
	    public static Relationships fromRelShip(String relShip) {
	    	for (Relationships rel : Relationships.values()) {
				if (rel.getRelShip().equals(relShip)) {
					return rel;
				}
			}
	        return null;
	    }
	}
}
