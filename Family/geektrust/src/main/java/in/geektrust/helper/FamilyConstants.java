package in.geektrust.helper;

public class FamilyConstants {
	
	public static enum Gender {
		FEMALE,
		MALE
	}
	
	public static enum Result {
		CHILD_ADDITION_SUCCEEDED,
		PERSON_NOT_FOUND,
		CHILD_ADDITION_FAILED,
		NONE
	}
	
	public static enum BuildTreeInst {
		ADD_CHILD,
		ADD_SPOUSE
	}
	
	public static enum InputType {
		ADD_CHILD,
		GET_RELATIONSHIP
	}
	
	public static String PATERNAL_UNCLE = "Paternal-Uncle";
	public static String MATERNAL_UNCLE = "Maternal-Uncle";
	public static String PATERNAL_AUNT = "Paternal-Aunt";
	public static String MATERNAL_AUNT = "Maternal-Aunt";
	public static String SISTER_IN_LAW = "Sister-In-Law";
	public static String BROTHER_IN_LAW = "Brother-In-Law";
	public static String SON = "Son";
	public static String DAUGHTER = "Daughter";
	public static String SIBLINGS = "Siblings";
	
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
