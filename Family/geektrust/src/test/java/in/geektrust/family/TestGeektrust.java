package in.geektrust.family;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestGeektrust {
	
	@Test
	public void testAddChildOrGetRel() {
		String result = Geektrust.addChildOrGetRel("E:\\Hacktoberfest\\Family\\input3.txt");
		 
        assertNotNull(result);
	}
}