package in.geektrust.family;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import in.geektrust.model.FamilyTree;
import in.geektrust.service.InitializeTree;
import in.geektrust.service.InitializeTreeImpl;

public class Geektrust {

	public static void main(String[] args) {
		
		addChildOrGetRel(args[0]);
	}
	
	public static String addChildOrGetRel(String filePath) {

		FamilyTree familyTree = new FamilyTree();
		
		InitializeTree buildTree = new InitializeTreeImpl(familyTree);
		familyTree = buildTree.initializeTheFamilyTree();
		
		return addOrGetFamily(familyTree, filePath);
	}
	
	public static String addOrGetFamily(FamilyTree familyTree, String inpPath) {
		String res = null;
		Scanner sc = null;
		try {
			File inpFile = new File(inpPath);
			sc = new Scanner(inpFile);
			while (sc.hasNextLine()) {
				res = familyTree.addOrGetFamilyElement(familyTree, sc.nextLine());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		return res;
	}
}
