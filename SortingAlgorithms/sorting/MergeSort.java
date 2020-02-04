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


public class MergeSort extends Sorter{

    /**
     * 
     * Uses merge sort to sort the array
     * @param array inputted array to be sorted
     * @param n size of the array
     * 
     * 
     */
    public void mergeSort(double[] array, int n) {
        //If the list is at its base integers i.e. divided
        if (n < 2) {
            return;
        }

        //Creates the mid variable
        int mid = n / 2;
        //Splits the list into two seperate lists
        double[] lower = new double[mid];
        double[] upper = new double[n - mid];

        //3 operation counts for the three variable assignments
        this.countOp();
        this.countOp();
        this.countOp();
     

        //Fills the lower array 
        for (int i = 0; i < mid; i++) {
            this.countOp();
            lower[i] = array[i];
        }

        //Fills the upper array
        for (int i = mid; i < n; i++) {
            this.countOp();
            upper[i - mid] = array[i];
        }

        //Recursively calls Merge Sort until the list is divided to its single elements
        
        mergeSort(lower, mid);
        mergeSort(upper, n - mid);
     
        //Merge the lists back together

        merge(array, lower, upper, mid, n - mid);
    }


    /**
     * Merges the lists together into one list
     * @param array total array
     * @param lower lower array
     * @param upper upper array
     * @param left left side of the array size
     * @param right right side of the array size
     */
    public void merge(double[] array, double[] lower, double[] upper, int left, int right) {

        //3 assignment counts for the i,j,k variables
        this.countOp();
        this.countOp();
        this.countOp(); 
        int i = 0;
        int j = 0;
        int k = 0;
        //Loops while the list isnt merged together sorted
        while (i < left && j < right) {
            //If the lower is lower than the upp
            if (lower[i] <= upper[j]) {
                this.countOp();
                //Insert into the array
                array[k++] = lower[i++];
            }
            //Else
            else {
                this.countOp();
                //Insert the value from the upper
                array[k++] = upper[j++];
            }
        }
        //Loops until the list is merged properly
        while (i < left) {
            this.countOp();
            array[k++] = lower[i++];
        }
        while (j < right) {
            this.countOp();
            array[k++] = upper[j++];
        }
    }

    /**
     * Sort function
     */
    public void sort(double[] array){
        mergeSort(array, array.length);
    }

    /**
     *  Outputs the array 
     */

    public void print(double[] array){
        System.out.print('[');
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.print(']');
    }

}
