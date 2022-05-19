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

import java.util.*;


public class PerformanceTestMain {
    private static final Random random = new Random();
    private static ArrayList<int[]> inputs;
    private static final HashMap<String, Long> times = new HashMap<>();
    private static final HashMap<String, Long> memories = new HashMap<>();
    private static int tabCount = 0;

    interface SortingAlgorithm {
        void sort(int[] input);
    }

    public static void main(String[] args) {
        inputs = createInputs(10000, 1000);
        testSortingAlgorithm(BeadSort::beadSort, "Bead");
        testSortingAlgorithm(BubbleSort::bubbleSort, "Bubble");
        testSortingAlgorithm(CircleSort::Sort, "Circle");
        testSortingAlgorithm(input -> new CocktailSort().sort(input), "Cocktail");
        testSortingAlgorithm(input -> CycleSort.cycleSort(input, input.length), "Cycle");
        testSortingAlgorithm(GnomeSort::gnomeSort, "Gnome");
        testSortingAlgorithm(HeapSort::sort, "Heap");
        testSortingAlgorithm(input -> new InsertionSort().sort(input), "Insertion");
        testSortingAlgorithm(input -> PigeonHoleSort.pigeonholeSort(input, input.length), "Pigeon hole");
        testSortingAlgorithm(input -> new QuickSort().sort(input, 0, input.length - 1), "Quick");
        testSortingAlgorithm(RadixSort::radixSort, "Radix");
        testSortingAlgorithm(SelectionSort::sort, "Selection");
        testSortingAlgorithm(ShakerSort::sort, "Shaker");
        testSortingAlgorithm(ShellSort::sort, "Shell");
        printTopSpeed();
        printTopMemory();
    }

    private static void printTopSpeed() {
        ArrayList<Map.Entry<String, Long>> sorted = sortMap(times);
        System.out.println("TOP 5 (Time)");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i);
            System.out.print(". ");
            System.out.print(sorted.get(i-1).getKey());
            System.out.print(" (");
            System.out.print(sorted.get(i-1).getValue());
            System.out.println(" ms)");
        }
    }

    private static void printTopMemory() {
        ArrayList<Map.Entry<String, Long>> sorted = sortMap(memories);
        System.out.println("TOP 5 (Memory)");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i);
            System.out.print(". ");
            System.out.print(sorted.get(i-1).getKey() + " sort");
            System.out.print(" (");
            System.out.print(sorted.get(i-1).getValue());
            System.out.println(" MB)");
        }
    }

    public static ArrayList<Map.Entry<String, Long>> sortMap(HashMap<String, Long> map) {
        ArrayList<Map.Entry<String, Long>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        return entries;
    }

    private static void testSortingAlgorithm(SortingAlgorithm algorithm, String name) {
        System.out.println(name + " sort:");
        tabCount++;
        ArrayList<int[]> inputsCopy = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : inputsCopy) {
            algorithm.sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put(name, time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put(name, memory);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        printTabs();
        System.out.print("Memory: ");
        System.out.print(memory);
        System.out.println(" MB");
        tabCount--;
    }

    private static void printTabs() {
        for (int i = 0; i < tabCount; i++) {
            System.out.print("\t");
        }
    }

    private static ArrayList<int[]> createInputs(int inputCount, int maxSize) {
        ArrayList<int[]> inputs = new ArrayList<>();
        for (int i = 0; i < inputCount; i++) {
            int size = random.nextInt(maxSize);
            int[] input = new int[size];
            for (int j = 0; j < size; j++) {
                input[j] = random.nextInt(1000);
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
