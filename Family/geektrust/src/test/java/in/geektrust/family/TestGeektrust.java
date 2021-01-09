package in.geektrust.family;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.Test;

class TestGeektrust {
	
	@Test
	void testPathToFileShouldBeTakenAsInput() {
		String path = "src/test/resources/SampleInput.txt";
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		
		String result = Geektrust.addChildOrGetRel(absolutePath);

        assertNotNull(result,"File Input Is process and Result should be returned");

	}
}