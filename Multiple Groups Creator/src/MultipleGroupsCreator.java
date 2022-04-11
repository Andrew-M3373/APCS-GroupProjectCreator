import java.util.*;
import java.io.*;

public class MultipleGroupsCreator {

	public static void main(String[] args) throws FileNotFoundException {
		
		int roundCount = 1;
		Scanner input = new Scanner(System.in);
		Scanner scanStudents = new Scanner(new File("students.txt"));
		Scanner scanGroup1 = new Scanner(new File("group1.txt"));
		Scanner scanGroup2 = new Scanner(new File("group2.txt"));
		
		
		System.out.println("Welcome to the classroom group sorter!");
		
		createInitialGroups(numberOfGroups(roundCount,input),scanStudents);
		
	}
	
	public static int numberOfGroups(int roundCount, Scanner input) {
		System.out.println("How many groups do you want to create for project " + roundCount + "?");
		int numberOfGroups = Integer.parseInt(input.nextLine());
		return numberOfGroups;
	}
	
	public static ArrayList<ArrayList<String>> createInitialGroups(int numberOfGroups,Scanner scanStudents) {
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<ArrayList<String>> finalArray = new ArrayList<ArrayList<String>>();
		int peoplePerGroup = array.size()/numberOfGroups + array.size() % numberOfGroups != 0 ? 1 : 0;
		int j = 0;
		for (int i = 0; i < numberOfGroups; i++) {
			ArrayList<String> tempArray = new ArrayList<String>();
			for (; j < peoplePerGroup; j++)
				tempArray.add(scanStudents.nextLine());
			finalArray.add(tempArray);
		}
		
//		return array;
	}

}
