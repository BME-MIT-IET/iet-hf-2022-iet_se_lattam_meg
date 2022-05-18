package application;

import org.junit.jupiter.api.Test;

import application.bubble_sort.BubbleSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;

public class BubbleSortTest {
    int[] arrayShort, arrayLong, arrayNegative, arrayEmpty;

    @BeforeEach
    public void init(){
        arrayShort = new int[]{5, 8, 2, 6, 11};
        arrayLong = new int[]{5, 8, 2, 6, 11, 215, 645, 312, 2, 4, 1154, 44, 69, 420};
        arrayNegative = new int[]{0, -4, -10, 5, -35, -4, -2, -1};
        arrayEmpty = new int[0];
    }

    @Test
    public void Test_Short_Array(){
        BubbleSort.bubbleSort(arrayShort);
        assertArrayEquals(new int[]{2, 5, 6, 8, 11}, arrayShort);
    }

    @Test
    public void Test_Long_Array(){
        BubbleSort.bubbleSort(arrayLong);
        assertArrayEquals(new int[]{2, 2, 4, 5, 6, 8, 11, 44, 69, 215, 312, 420, 645, 1154}, arrayLong);
    }

    @Test
    public void Test_Negative_Array(){
        BubbleSort.bubbleSort(arrayNegative);
        assertArrayEquals(new int[]{-35, -10, -4, -4, -2, -1, 0, 5}, arrayNegative);
    }

    @Test
    public void Test_Empty_Array(){
        BubbleSort.bubbleSort(arrayEmpty);
        assertArrayEquals(new int[]{}, arrayEmpty);
    }
}
