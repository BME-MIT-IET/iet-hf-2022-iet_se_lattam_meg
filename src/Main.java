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

	}

	private static void printOptions() {

	}

	private static void printInstructions() {

	}

	private static Integer readAlg() {
		return 0;
	}

	private static int[] readNumbers() {
		return new int[0];
	}
}
