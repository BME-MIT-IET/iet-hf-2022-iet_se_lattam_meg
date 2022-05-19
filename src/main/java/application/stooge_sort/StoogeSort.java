package application.stooge_sort;

//This is a java program to sort numbers using Stooge Sort
import java.util.Random;

public class StoogeSort {

	private static final int ARR_LENGTH = 20;
	private static final int[] SEQUENCE = new int[ARR_LENGTH];

	public static int[] stoogeSort(int[] l, int i, int j) {
		if (j == -1) {
			return l;
		}
		if (l[j] < l[i]) {
			int swap = l[i];
			l[i] = l[j];
			l[j] = swap;
		}
		if ((j - i + 1) >= 3) {
			int t = (j - i + 1) / 3;
			stoogeSort(l, i, j - t);
			stoogeSort(l, i + t, j);
			stoogeSort(l, i, j - t);
		}
		return l;
	}

	public static void printSequence(int[] sortedSequence) {
		for (int i = 0; i < sortedSequence.length; i++) {
			System.out.print(sortedSequence[i] + " ");
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("Sorting of randomly generated numbers using STOOGE SORT");

		for (int i = 0; i < ARR_LENGTH; i++) {
			SEQUENCE[i] = Math.abs(random.nextInt(1000));
		}

		System.out.println("\nOriginal Sequence: ");
		printSequence(SEQUENCE);

		System.out.println("\nSorted Sequence: ");
		printSequence(stoogeSort(SEQUENCE, 0, SEQUENCE.length - 1));
	}
}
