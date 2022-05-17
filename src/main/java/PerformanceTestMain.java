import application.circle_sort.CircleSort;

import java.util.*;

import static application.bead_sort.BeadSort.beadSort;
import static application.bubble_sort.BubbleSort.bubbleSort;

public class PerformanceTestMain {

    private static ArrayList<int[]> inputs;
    private static HashMap<String, Long> runTimes = new HashMap<>();
    private static int tabCount = 0;


    public static void main(String[] args) {
        inputs = createInputs();
        bubbleSortTest();
    }

    private static void bubbleSortTest() {
        System.out.println("Bubble sort:");
        tabCount++;
        ArrayList<int[]> bubbleSortInputs = copyInputs(inputs);
        long startTime = System.currentTimeMillis();
        for (int[] input : bubbleSortInputs) {
            bubbleSort(input);
        }
        long time = System.currentTimeMillis() - startTime;
        runTimes.put("Bubble sort", time);
        printTabs();
        System.out.print("Time: ");
        System.out.print(time);
        System.out.println(" ms");
        tabCount--;
    }

    private static void printInput(int[] input) {
        printTabs();
        System.out.print("Input: ");
        printNumber(input);
    }

    private static void printResult(int[] result) {
        printTabs();
        System.out.print("Result: ");
        printNumber(result);
    }

    private static void printNumber(int[] numbers) {
        String outputString = "[";
        for (int number : numbers) {
            outputString += number + ", ";
        }
        if (outputString.length() > 1) {
            outputString = outputString.substring(0, outputString.length() - 2);
        }
        outputString += "]";
        System.out.println(outputString);
    }

    private static void printTabs() {
        for (int i = 0; i < tabCount; i++) {
            System.out.print("\t");
        }
    }


    private static ArrayList<int[]> createInputs() {
        return createInputs(10000, 1000);
    }
    private static ArrayList<int[]> createInputs(int inputCount) {
        return createInputs(inputCount, 1000);
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
            for (int j = 0; j < input.length; j++) {
                inputCopy[j] = input[j];
            }
            inputsCopy.add(inputCopy);
        }
        return inputsCopy;
    }
}
