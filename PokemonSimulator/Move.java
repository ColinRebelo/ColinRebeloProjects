public class Move{
    //Variable declaration

    public String name;
    public String type;
    public int power;
    public float accuracy;


    //Constructor for move
    public Move(String name, String type, int power, float accuracy){
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    //Getter functions for the moves
    /**
     * 
     * @return the name of the Move
     */
    public String getName(){
        return this.name;
    }
    /**
     * 
     * @return the attack power of the move
     */

    public int getAttack(){
        return this.power;
    }

    /**
     * 
     * @return the type of the move
     */
    public String getType(){
        return this.type;
    }

    /**
     * 
     * @return the accuracy of the move
     */
    public float getAccuracy(){
        return this.accuracy;
    }

}