package application.cycle_sort;

// Java program to impleament cycle sort
// Part of Cosmos by OpenGenus Foundation

public class CycleSort {
// Function sort the array using Cycle sort
	public static void cycleSort(int[] arr, int n) {
		// traverse array elements and put it on the right place
		for (int cycle_start = 0; cycle_start < n - 1; cycle_start++) {
			// initialize item as starting point
			int item = arr[cycle_start];

			// Find position where we put the item. We basically
			// count all smaller elements on right side of item.
			// cycle_start;
			int pos = calculatePos(arr, item, n, cycle_start);

			// If item is already in correct position
			if (pos == cycle_start) {
				continue;
			}

			// ignore all duplicate elements
			pos = ignoreDuplicates(arr, item, pos);

			// put the item to it's right position
			if (pos != cycle_start) {
				int temp = item;
				item = arr[pos];
				arr[pos] = temp;
			}

			// Rotate rest of the cycle
			while (pos != cycle_start) {
				pos = cycle_start;

				// Find position where we put the element
				for (int i = cycle_start + 1; i < n; i++) {
					if (arr[i] < item) {
						pos += 1;
					}
				}

				// ignore all duplicate elements
				while (item == arr[pos]) {
					pos += 1;
				}

				// put the item to it's right position
				if (item != arr[pos]) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
				}
			}
		}
	}

	private static int ignoreDuplicates(int[] arr, int item, int pos) {
		while (item == arr[pos]) {
			pos++;
		}
		return pos;
	}

	private static int calculatePos(int[] arr, int item, int n, int pos) {
		int start = pos;
		for (int i = start + 1; i < n; i++) {
			if (arr[i] < item) {
				pos++;
			}
		}
		return pos;
	}

// The Main function
	public static void main(String[] args) {
		int[] arr = { 1, 8, 3, 9, 10, 10, 2, 4 };
		int n = arr.length;
		cycleSort(arr, n);

		System.out.println("After sort : ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
