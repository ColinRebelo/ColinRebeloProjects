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

public abstract class Sorter {   
    private long opCount = 0L;   
    /**
     * 
     * @return The operation count
     */
    public long getOpCount() {     
        return this.opCount;   
    }   

    /**
     *  Resets the operation count to a 0 value of type long
     */
    protected void resetOpCount() {     
        this.opCount = 0L;   
    }   

    /**
     * Increases the operation counter
     */
    protected void countOp() {     
        this.opCount++;   
    }

    
    public abstract void print(double[] list);   
    public abstract void sort(double[] list); 
} 