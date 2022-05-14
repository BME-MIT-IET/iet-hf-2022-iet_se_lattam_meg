import java.util.ArrayList;
import java.util.Scanner;

import bead_sort.BeadSort;
import bubble_sort.BubbleSort;
import circle_sort.CircleSort;

public class Main {

	public static void main(String[] args) {
		try {
			printOptions();
			Integer alg = readAlg();
			printInstructions();
			int[] nums = readNumbers();
			switch (alg) {
			case 1:
				nums = BeadSort.beadSort(nums);
				break;
			case 2:
				BubbleSort.bubbleSort(nums);
				break;
			case 3:
				nums = CircleSort.Sort(nums);
				break;
			}
			printNumbers(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printNumbers(int[] arr) {
		System.out.println("Sorted:");
		for(int i=0;i<arr.length;++i) {
			System.out.println(arr[i]);
		}
	}

	private static void printOptions() {
		System.out.println("Enter a number to select an algorithm");
		System.out.println("1 - Bead");
		System.out.println("2 - Bubble");
		System.out.println("3 - Circle");
	}

	private static void printInstructions() {
		System.out.println("Enter the numbers you want to sort, separated by enters");
		System.out.println("Enter an empty line to start sorting");
	}

	private static Integer readAlg() {
		return 0;
	}

	private static int[] readNumbers() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			try {
				String s = in.nextLine();
				if(s.equals("")){
					break;
				}
				Integer number = Integer.parseInt(s);
				array.add(number);
			}
			catch (NumberFormatException nfe) {
				System.out.println("Please enter a number");
			}
		}		
		
		int[] res = new int[array.size()];
		for(int i = 0; i < array.size(); i++) {
			res[i] = array.get(i);
		}
		return res;
	}
}
