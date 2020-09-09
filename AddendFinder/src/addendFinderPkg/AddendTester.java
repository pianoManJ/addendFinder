package addendFinderPkg;
/*
 * class AddendTester: tests the class AddendFinder
 * 	Functions:
 * 		main(): what the program looks for to run
 * */
public class AddendTester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddendFinder finder;
		int[] list = {5, 5, 15, 10};
		finder = new AddendFinder(list, 15);
		finder.calculateCombinations();
		System.out.println(finder.totalCombinations);
		
		AddendFinder finder2;
		int[] newList = {1,2,3,4,5,6};
		finder2 = new AddendFinder(newList, 6);
		finder2.calculateCombinations();
		System.out.println(finder2.totalCombinations);
	}

}
