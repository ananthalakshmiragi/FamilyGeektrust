package in.geektrust.family;

import java.io.File;
import java.util.Scanner;

import in.geektrust.service.BuildTree;
import in.geektrust.service.BuildTreeImpl;
import in.geektrust.service.FamilyTree;

public class Geektrust {

	public static void main(String[] args) {
		
		addChildOrGetRel(args[0]);
	}
	
	public static String addChildOrGetRel(String filePath) {

		FamilyTree familyTree = new FamilyTree();
		
		BuildTree b = new BuildTreeImpl();
		b.setFamilyTree(familyTree);
		familyTree = b.buildTheFamilyTree(familyTree);
//		String inpFilePath = "E:\\Hacktoberfest\\Family\\input3.txt";
//		familyTree.addOrGetFamily(familyTree, inpFilePath);
		
		return addOrGetFamily(familyTree, filePath);
	}
	
	public static String addOrGetFamily(FamilyTree familyTree, String inpPath) {
		String res =null;
		try {
			File inpFile = new File(inpPath);
			Scanner sc = new Scanner(inpFile);
			while (sc.hasNextLine()) {
				res = familyTree.addOrGetFamilyElement(familyTree, sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
