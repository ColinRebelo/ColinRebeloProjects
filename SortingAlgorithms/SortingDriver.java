import sorting.*; 

/**
 * @author Colin Rebelo 
 * @author Cole Anam
 * 
 * November 23 2019
 * 
 * Part 1 of Assignment #2
 * 
 * 
 */

public class SortingDriver {   
    /**
     * 
     * @param size size of the list
     * @return Randomly generated array
     */
    public static double[] generateRandomArray(int size) {     
        double[] array = new double[size];     
        for (int i = 0; i < array.length; i++) {       
            array[i] = Math.random() * 100.0;     
        }     return array;   
    }   
    public static void main(String[] args) {     
        double[] array1 = generateRandomArray(100000);    
        double[] array2 = array1.clone();     // algorithm #1  
        Sorter iSorter = new InsertionSort();     
        iSorter.sort(array1);     
        System.out.println("Operations: " + iSorter.getOpCount());     // algorithm #2     
        Sorter mSorter = new MergeSort();     
        mSorter.sort(array2);   
        System.out.println("Operations: " + mSorter.getOpCount()); 
    } 
}