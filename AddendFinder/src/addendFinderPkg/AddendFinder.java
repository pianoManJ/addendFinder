package addendFinderPkg;
import java.util.*;
import java.util.ArrayList;
/*
 * Class AddendFinder: class that contains an array of integers, and uses methods to get a list of sets that add up to a target sum
 * 	Attributes:
 * 		numberList <int array>: array of integers
 * 		sum <int>: target sum
 * 	Functions:
 * 		Constructor: initializes numberList and sum
 * 		potentialComboSum: sums up the integers a set is referencing
 * 		combinationFromGivenIndex: if able, makes a combination set and puts it in totalCombinations
 * 		calculateCombinations: finds all combinations from numberlist.
 * */
public class AddendFinder {
	private int[] numberList; //list of numbers which could be potential addends to the sum.
	private int sum;
	public ArrayList<Set<Integer>> totalCombinations = new ArrayList();
	
	AddendFinder(int[] add, int s){ //class constructor
		numberList = add; 
		sum = s;
	}
	
	int potentialComboSum(Set<Integer> s, int[] nums) {
		Iterator<Integer> i = s.iterator();
		int miniSum = 0;
		while (i.hasNext()) {
			miniSum += numberList[i.next()];
		}
		return miniSum;
	}
	
	void combinationFromGivenIndex(Set<Integer> s) {
		for(int i = 0; i < numberList.length; i++ ) {
			if (!(s.contains(i))) {
				s.add(i);
				if(potentialComboSum(s, numberList) <= sum){
					if(potentialComboSum(s, numberList) == sum) {
						if(!(totalCombinations.contains(s))) {
						System.out.println("adding set: "+ s);
						totalCombinations.add(new HashSet<Integer>(s));
					}
				}
					combinationFromGivenIndex(s);
				}
				s.remove(i);
			}else if(numberList[i] == sum && s.size() == 1) {
				if(!(totalCombinations.contains(s))) {
					totalCombinations.add(new HashSet<Integer>(s));
				}
			}
			
		}
	}
	
	void calculateCombinations(){
		for(int i = 0; i < numberList.length; i++ ) {
			if (numberList[i]<= sum) {
				Set<Integer> potentialCombo = new HashSet();
				potentialCombo.add(i);
				combinationFromGivenIndex(potentialCombo);
			}
		}
	}
}
