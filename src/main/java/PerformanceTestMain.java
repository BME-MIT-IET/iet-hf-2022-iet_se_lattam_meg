import application.circle_sort.CircleSort;
import application.cocktail_sort.CocktailSort;
import application.cycle_sort.CycleSort;
import application.gnome_sort.GnomeSort;

import java.util.*;

import static application.bead_sort.BeadSort.beadSort;
import static application.bubble_sort.BubbleSort.bubbleSort;

public class PerformanceTestMain {

    private static ArrayList<int[]> inputs;
    private static HashMap<String, Long> times = new HashMap<>();
    private static int tabCount = 0;


    public static void main(String[] args) {
        inputs = createInputs(10000, 1000);
        beadSortTest();
        bubbleSortTest();
        circleSortTest();
        cocktailSortTest();
        cycleSortTest();
        gnomeSortTest();
    }

    private static void beadSortTest() {
        System.out.println("Bead sort:");
        tabCount++;
        ArrayList<int[]> beadSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : beadSortInputs) {
            beadSort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Bead sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print((usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println(" MB");
        tabCount--;
    }

    private static void bubbleSortTest() {
        System.out.println("Bubble sort:");
        tabCount++;
        ArrayList<int[]> bubbleSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : bubbleSortInputs) {
            bubbleSort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Bubble sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print((usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println(" MB");
        tabCount--;
    }

    private static void circleSortTest() {
        System.out.println("Circle sort:");
        tabCount++;
        ArrayList<int[]> circleSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : circleSortInputs) {
            CircleSort.Sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Circle sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print((usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println(" MB");
        tabCount--;
    }

    private static void cocktailSortTest() {
        System.out.println("Cocktail sort:");
        tabCount++;
        ArrayList<int[]> cocktailSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : cocktailSortInputs) {
            new CocktailSort().sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Cocktail sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print((usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println(" MB");
        tabCount--;
    }

    private static void cycleSortTest() {
        System.out.println("Cycle sort:");
        tabCount++;
        ArrayList<int[]> cycleSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : cycleSortInputs) {
            CycleSort.cycleSort(input, input.length);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Cycle sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print((usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println(" MB");
        tabCount--;
    }

    private static void gnomeSortTest() {
        System.out.println("Gnome sort:");
        tabCount++;
        ArrayList<int[]> gnomeSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : gnomeSortInputs) {
            GnomeSort.gnomeSort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Gnome sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print((usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.out.println(" MB");
        tabCount--;
    }

    private static void printTabs() {
        for (int i = 0; i < tabCount; i++) {
            System.out.print("\t");
        }
    }

    private static ArrayList<int[]> createInputs(int inputCount, int maxSize) {
        Random random = new Random();

        ArrayList<int[]> inputs = new ArrayList<>();
        for (int i = 0; i < inputCount; i++) {
            int size = random.nextInt(maxSize);
            int[] input = new int[size];
            for (int j = 0; j < size; j++) {
                input[j] = random.nextInt(2000) - 1000;
            }
            inputs.add(input);
        }
        return inputs;
    }

    private static ArrayList<int[]> copyInputs(ArrayList<int[]> inputs) {
        ArrayList<int[]> inputsCopy = new ArrayList<>();
        for (int[] input : inputs) {
            int[] inputCopy = new int[input.length];
            System.arraycopy(input, 0, inputCopy, 0, input.length);
            inputsCopy.add(inputCopy);
        }
        return inputsCopy;
    }
}
