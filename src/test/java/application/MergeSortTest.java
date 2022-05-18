package application;

import org.junit.jupiter.api.Test;

import application.merge_sort.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MergeSortTest {
    
    @Test
    public void Test_Sort_EmptyArray(){
    	int[] arrayEmpty = new int[] {};
    	
    	MergeSort ms = new MergeSort();
    	ms.sort(arrayEmpty, 0, arrayEmpty.length-1);
       
        assertArrayEquals(new int[]{}, arrayEmpty);
    }
    
    @Test
    public void Test_Sort_ArrayInOrder(){
    	int[] arrayInOrder = new int[] {1,2,3,4,10,20};
    	
    	MergeSort ms = new MergeSort();
    	ms.sort(arrayInOrder, 0, arrayInOrder.length-1);
       
        assertArrayEquals(new int[]{1,2,3,4,10,20}, arrayInOrder);
    }
    
    @Test
    public void Test_Sort_ArrayReversed(){
    	int[] arrayReversed = new int[] {50,45,30,10,2};
    	
    	MergeSort ms = new MergeSort();
    	ms.sort(arrayReversed, 0, arrayReversed.length-1);
       
        assertArrayEquals(new int[]{2,10,30,45,50}, arrayReversed);
    }
    
    @Test
    public void Test_Sort_ArrayWithNegativeNumbers(){
    	int[] arrayWithNegativeNumbers = new int[] {3,-8,2};
    	
    	MergeSort ms = new MergeSort();
    	ms.sort(arrayWithNegativeNumbers, 0, arrayWithNegativeNumbers.length-1);
       
        assertArrayEquals(new int[]{-8,2,3}, arrayWithNegativeNumbers);
    }
    
    @Test
    public void Test_Sort_ArrayWithZero(){
    	int[] arrayWithZero = new int[] {4,0,2,10};
    	
    	MergeSort ms = new MergeSort();
    	ms.sort(arrayWithZero, 0, arrayWithZero.length-1);
       
        assertArrayEquals(new int[]{0,2,4,10}, arrayWithZero);
    }
}