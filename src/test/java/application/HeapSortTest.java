package application;

import org.junit.jupiter.api.Test;

import application.heap_sort.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class HeapSortTest {
    
    @Test
    public void Test_Heapify_EmptyArray(){
    	int[] arrayEmpty = new int[] {};
        int n = arrayEmpty.length;
    	
        for (int i = n / 2 - 1; i >= 0; i--){
            HeapSort.heapify(arrayEmpty, n, i);
        }
       
        assertArrayEquals(new int[]{}, arrayEmpty);
    }
    
    @Test
    public void Test_Heapify_ArrayInOrder(){
    	int[] arrayInOrder = new int[] {1,2,3,4,10,20};
    	int n = arrayInOrder.length;
    	
        for (int i = n / 2 - 1; i >= 0; i--){
            HeapSort.heapify(arrayInOrder, n, i);
        }
       
        assertArrayEquals(new int[]{20,10,3,4,2,1}, arrayInOrder);
    }
    
    @Test
    public void Test_Heapify_ArrayReversed(){
        //should not change -> already heapified
    	int[] arrayReversed = new int[] {50,45,30,10,2};
    	
    	int n = arrayReversed.length;
    	
        for (int i = n / 2 - 1; i >= 0; i--){
            HeapSort.heapify(arrayReversed, n, i);
        }
       
        assertArrayEquals(new int[]{50,45,30,10,2}, arrayReversed);
    }

    @Test
    public void Test_Heapify_DontChangeSortedElement(){
    	int[] array = new int[] {50,45,30,10,2, 100};
    	
        //last element not included
    	int n = array.length-1;
    	
        for (int i = n / 2 - 1; i >= 0; i--){
            HeapSort.heapify(array, n, i);
        }
       
        assertArrayEquals(new int[]{50,45,30,10,2,100}, array);
    }
    

}
