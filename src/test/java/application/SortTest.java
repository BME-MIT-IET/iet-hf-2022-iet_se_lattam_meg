package test.java.application;

import org.junit.jupiter.api.Test;

import main.java.application.bubble_sort.BubbleSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;

public class SortTest {
    int[] arrayShort, arrayLong, arrayNegative;

    @BeforeEach
    public void init(){
        arrayShort = new int[]{5, 8, 2, 6, 11};
        arrayLong = new int[]{5, 8, 2, 6, 11, 215, 645, 312, 2, 4, 1154, 44, 69, 420};
        arrayNegative = new int[]{0, -4, -10, 5, -35, -4, -2, -1};
    }

    @Test
    public void Test_Bubble_Sort(){
        BubbleSort.bubbleSort(arrayShort);
        BubbleSort.bubbleSort(arrayLong);
        BubbleSort.bubbleSort(arrayNegative);

        assertArrayEquals(new int[]{2, 5, 6, 8, 11}, arrayShort);
        assertArrayEquals(new int[]{2, 2, 4, 5, 6, 8, 11, 44, 69, 215, 312, 420, 645, 1154}, arrayLong);
        assertArrayEquals(new int[]{-35, -10, -4, -4, -2, -1, 0, 5}, arrayNegative);
    }
}
