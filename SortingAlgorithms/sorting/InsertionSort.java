package sorting;

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


public class InsertionSort extends Sorter{
    /**
     *  Sorts the array using the Insertion sort method
     */
    public void sort(double array[]){
        //Assigns n as the length of the array
        int n = array.length;

        //Loops for the length of the array
        for(int i = 1; i < n; i++){
            this.countOp();
            double key = array[i];
            this.countOp();
            int j = i - 1;
            //loops until the insert can occur
            while(j >= 0 && array[j] > key){
                //Counts the operations and inserts the value
                this.countOp();
                array[j+1] = array[j];
                this.countOp();
                j = j-1;
            }
            this.countOp();
            array[j+1] = key;
        }
    }

    //A standard print function for testing purposes
    /**
     *  Outputs the array 
     */
    public void print(double array[]){
        System.out.print('[');
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.print(']');
    }
}