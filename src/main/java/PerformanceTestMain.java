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

import java.util.*;
import java.util.stream.Collectors;

import static application.bead_sort.BeadSort.beadSort;
import static application.bubble_sort.BubbleSort.bubbleSort;

public class PerformanceTestMain {

    private static ArrayList<int[]> inputs;
    private static HashMap<String, Long> times = new HashMap<>();
    private static HashMap<String, Long> memories = new HashMap<>();
    private static int tabCount = 0;


    public static void main(String[] args) {
        inputs = createInputs(10000, 1000);
        beadSortTest();
        bubbleSortTest();
        circleSortTest();
        cocktailSortTest();
        cycleSortTest();
        gnomeSortTest();
        heapSortTest();
        insertionSortTest();
        pigeonHoleSortTest();
        quickSortTest();
        radixSortTest();
        selectionSortTest();
        shakerSortTest();
        shellSortTest();
        // slowSortTest();
        // stoogeSortTest();
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
            System.out.print(sorted.get(i-1).getKey());
            System.out.print(" (");
            System.out.print(sorted.get(i-1).getValue());
            System.out.println(" MB)");
        }
    }

    public static ArrayList<Map.Entry<String, Long>> sortMap(HashMap<String, Long> map) {
        ArrayList<Map.Entry<String, Long>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparing(Map.Entry::getValue));
        return entries;
    }

    private static void beadSortTest() {
        System.out.println("Bead sort:");
        tabCount++;
        ArrayList<int[]> beadSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : beadSortInputs) {
            input = beadSort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Bead sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Bead sort", memory);
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
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Bubble sort", memory);
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

    private static void circleSortTest() {
        System.out.println("Circle sort:");
        tabCount++;
        ArrayList<int[]> circleSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : circleSortInputs) {
            input = CircleSort.Sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Circle sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Circle sort", memory);
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
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Cocktail sort", memory);
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
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Cycle sort", memory);
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
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Gnome sort", memory);
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

    private static void heapSortTest() {
        System.out.println("Heap sort:");
        tabCount++;
        ArrayList<int[]> heapSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : heapSortInputs) {
            HeapSort.sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Heap sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Heap sort", memory);
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

    private static void insertionSortTest() {
        System.out.println("Insertion sort:");
        tabCount++;
        ArrayList<int[]> insertionSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : insertionSortInputs) {
            new InsertionSort().sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Insertion sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Insertion sort", memory);
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

    private static void pigeonHoleSortTest() {
        System.out.println("Pigeon hole sort:");
        tabCount++;
        ArrayList<int[]> pigeonHoleSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : pigeonHoleSortInputs) {
            PigeonHoleSort.pigeonholeSort(input, input.length);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Pigeon hole sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Pigeon hole sort", memory);
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

    private static void quickSortTest() {
        System.out.println("Quick sort:");
        tabCount++;
        ArrayList<int[]> quickSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : quickSortInputs) {
            new QuickSort().sort(input, 0, input.length - 1);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Quick sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Quick sort", memory);
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

    private static void radixSortTest() {
        System.out.println("Radix sort:");
        tabCount++;
        ArrayList<int[]> radixSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : radixSortInputs) {
            RadixSort.radixSort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Radix sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Radix sort", memory);
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

    private static void selectionSortTest() {
        System.out.println("Selection sort:");
        tabCount++;
        ArrayList<int[]> selectionSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : selectionSortInputs) {
            SelectionSort.sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Selection sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Selection sort", memory);
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

    private static void shakerSortTest() {
        System.out.println("Shaker sort:");
        tabCount++;
        ArrayList<int[]> shakerSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : shakerSortInputs) {
            ShakerSort.sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Shaker sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Shaker sort", memory);
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

    private static void shellSortTest() {
        System.out.println("Shell sort:");
        tabCount++;
        ArrayList<int[]> shellSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : shellSortInputs) {
            ShellSort.sort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Shell sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Shell sort", memory);
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

    private static void slowSortTest() {
        System.out.println("Slow sort:");
        tabCount++;
        ArrayList<int[]> slowSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : slowSortInputs) {
            SlowSort.slowSort(input, 0, input.length - 1);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Slow sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Slow sort", memory);
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

    private static void stoogeSortTest() {
        System.out.println("Stooge sort:");
        tabCount++;
        ArrayList<int[]> stoogeSortInputs = copyInputs(inputs);
        Runtime runtime = Runtime.getRuntime();
        long startTime = System.currentTimeMillis();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        for (int[] input : stoogeSortInputs) {
            input = StoogeSort.stoogeSort(input, 0, input.length - 1);
        }
        long time = System.currentTimeMillis() - startTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        times.put("Stooge sort", time);
        long memory = (usedMemoryAfter - usedMemoryBefore) / 1000000;
        memories.put("Stooge sort", memory);
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
        Random random = new Random();

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
