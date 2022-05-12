import java.util.*;
import java.io.*;

public class MultipleGroupsCreator {

	public static void main(String[] args) throws IOException {
		
		int roundCount = 1;
		Scanner input = new Scanner(System.in);
		Scanner scanStudents = new Scanner(new File("students.txt"));
		Scanner scanGroup1 = new Scanner(new File("project1.txt"));
		Scanner scanGroup2 = new Scanner(new File("project2.txt"));
		
		
		System.out.println("Welcome to the classroom group sorter!");
		
		ArrayList<ArrayList<String>> project1 = createInitialGroups(numberOfGroups(roundCount,input),scanStudents);
		printGroups(project1,1);
		roundCount++;
		scanStudents = new Scanner(new File("students.txt"));
		
		ArrayList<ArrayList<String>> project2 = createSecondGroups(numberOfGroups(roundCount,input),scanStudents,project1);
		printGroups(project2,2);
		
	}
	
	public static int numberOfGroups(int roundCount, Scanner input) {
		System.out.println("How many groups do you want to create for project " + roundCount + "?");
		int numberOfGroups = Integer.parseInt(input.nextLine());
		return numberOfGroups;
	}
	
	public static void printGroups(ArrayList<ArrayList<String>> a, int projectNumber) throws IOException {
		for (int i = 0; i < a.size(); i++) {
			System.out.println("\nGroup " + (i+1) + ":");
			for (int j = 0; j < a.get(i).size(); j++) {
				System.out.println("\t" + a.get(i).get(j));
			}
		}
		FileWriter writer = new FileWriter(projectNumber == 1 ? "project1.txt" : (projectNumber == 2 ? "project2.txt" : "project3.txt"));
		for (int i = 0; i < a.size(); i++) {
			writer.write("\n\nGroup " + (i+1) + ":");
			for (int j = 0; j < a.get(i).size(); j++) {
				writer.write("\n" + a.get(i).get(j));
			}
		}
		writer.close();
	}
	
	public static ArrayList<ArrayList<String>> createInitialGroups(int numberOfGroups,Scanner scanStudents) {
		ArrayList<String> array = new ArrayList<String>();
		while (scanStudents.hasNextLine()) 
			array.add(scanStudents.nextLine());
		ArrayList<ArrayList<String>> finalArray = new ArrayList<ArrayList<String>>();
		int peoplePerGroup = array.size()/numberOfGroups;
		
		for (int i = 0; i < numberOfGroups; i++) {
			ArrayList<String> tempArray = new ArrayList<String>();
			int j = 0;
			while (j < peoplePerGroup && array.size()>0) {
				tempArray.add(array.get(0));
				array.remove(0);
				j++;
			}
			finalArray.add(tempArray);
		}
		
		int i = 0;
		for (String s : array) {
			finalArray.get(i).add(s);
			i++;
		}
		
		return finalArray;
	}
	
	public static ArrayList<ArrayList<String>> createSecondGroups(int numberOfGroups, Scanner scanStudents, ArrayList<ArrayList<String>> project1) {
		ArrayList<String> array = new ArrayList<String>();
		while (scanStudents.hasNextLine()) 
			array.add(scanStudents.nextLine());
		ArrayList<ArrayList<String>> finalArray = new ArrayList<ArrayList<String>>();
		int peoplePerGroup = array.size()/numberOfGroups;
		
		boolean solutionFound = false;
		do {
			for (int i = 0; i<numberOfGroups; i++) {
				ArrayList<String> tempArray = new ArrayList<String>();
				int j =0;
				while (j < peoplePerGroup && array.size()>0) {
					int random = (int) Math.random()*array.size();
					tempArray.add(array.get(random));
					array.remove(random);
					j++;
				}
				finalArray.add(tempArray);
			}
			int i = 0;
			for (String s : array) {
				finalArray.get(i).add(s);
				i++;
			}
			
			// Do checks
			
		} while (!solutionFound);
		
		return finalArray;
//		if(numberOfGroups > )
	}

}
