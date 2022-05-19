package application;

import java.util.ArrayList;
import java.util.Scanner;

import application.bead_sort.BeadSort;
import application.bubble_sort.BubbleSort;
import application.circle_sort.CircleSort;
import application.cocktail_sort.CocktailSort;
import application.cycle_sort.CycleSort;
import application.gnome_sort.GnomeSort;
import application.heap_sort.HeapSort;
import application.insertion_sort.InsertionSort;
import application.pigeonhole_sort.PigeonHoleSort;
import application.quick_sort.QuickSort;
import application.radix_sort.RadixSort;
import application.selection_sort.SelectionSort;
import application.shaker_sort.ShakerSort;
import application.shell_sort.ShellSort;
import application.slow_sort.SlowSort;
import application.stooge_sort.StoogeSort;

public class Main {

	public static void main(String[] args) {
		try {
			printOptions();
			Integer alg = readAlg();
			printInstructions();
			int[] nums = readNumbers();
			if (nums.length == 0) {
				System.out.println("Cannot sort empty array");
				return;
			}
			switch (alg) {
			case 1:
				nums = BeadSort.beadSort(nums);
				break;
			case 2:
				BubbleSort.bubbleSort(nums);
				break;
			case 3:
				nums = CircleSort.sort(nums);
				break;
			case 4:
				CocktailSort cs = new CocktailSort();
				cs.sort(nums);
				break;
			case 5:
				InsertionSort is = new InsertionSort();
				is.sort(nums);
				break;
			case 6:
				CycleSort.cycleSort(nums, nums.length);
				break;
			case 7:
				GnomeSort.gnomeSort(nums);
				break;
			case 8:
				HeapSort.sort(nums);
				break;
			case 9:
				PigeonHoleSort.pigeonholeSort(nums, nums.length);
				break;
			case 10:
				QuickSort qs = new QuickSort();
				qs.sort(nums, 0, nums.length - 1);
				break;
			case 11:
				RadixSort.radixSort(nums);
				break;
			case 12:
				SelectionSort.sort(nums);
				break;
			case 13:
				ShakerSort.sort(nums);
				break;
			case 14:
				ShellSort.sort(nums);
				break;
			case 15:
				SlowSort.slowSort(nums, 0, nums.length - 1);
				break;
			case 16:
				nums = StoogeSort.stoogeSort(nums, 0, nums.length - 1);
				break;
			}
			printNumbers(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printNumbers(int[] arr) {
		System.out.println("Sorted:");
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
	}

	private static void printOptions() {
		System.out.println("Enter a number to select an algorithm");
		System.out.println("1 - Bead");
		System.out.println("2 - Bubble");
		System.out.println("3 - Circle");
		System.out.println("4 - Cocktail");
		System.out.println("5 - Insert");
		System.out.println("6 - Cycle");
		System.out.println("7 - Gnome");
		System.out.println("8 - Heap");
		System.out.println("9 - Pigeonhole");
		System.out.println("10 - Quick");
		System.out.println("11 - Radix");
		System.out.println("12 - Selection");
		System.out.println("13 - Shaker");
		System.out.println("14- Shell");
		System.out.println("15 - Slow");
		System.out.println("16 - Stooge");
	}

	private static void printInstructions() {
		System.out.println("Enter the numbers you want to sort, separated by enters");
		System.out.println("Enter an empty line to start sorting");
	}

	private static Integer readAlg() {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			System.out.println("Please add a number\n");
			throw nfe;
		}

	}

	private static int[] readNumbers() {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			try {
				String s = in.nextLine();
				if (s.equals("")) {
					break;
				}
				Integer number = Integer.parseInt(s);
				list.add(number);
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a number");
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}
}
