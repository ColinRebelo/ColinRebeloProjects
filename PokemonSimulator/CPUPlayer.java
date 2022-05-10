//Random for chooseMove Math for rounding floats in attack
import java.util.Random;
import java.lang.Math;

class CPUPlayer extends Player{

    //Constructor for CPU
    /**
     * Assigns the Monster to CPU Player
     * @param monster
     */
    public CPUPlayer(Monster monster){this.monster = monster;}

    //CPU chooses move at random
    /** 
     * @return the integer randomly selected by the CPU
    */
    protected int chooseMove(){
        //Used for returning the Choiced locked move
        if (moveNumLock > 0){
            return moveNumLock;
        }

        Random rand = new Random();

        // Obtain a number between [0 - 3]
        int moveNum = rand.nextInt(4);

        //Makes its [1-4]
        moveNum += 1;
        if(this.monster.getItem() == "Choice Band" || this.monster.getItem() == "Choice Scarf"){
            moveNumLock = moveNum;
            return moveNumLock;
        }
        else{moveNumLock=0;}

        //Returns the movenumber
        return moveNum;
    }

    /**
     * Assigns the Item chosen to monster
     */

    //Chooses the item
    protected void chooseItem(){
        float statFloat;
        int newStat;
        Random rand = new Random();

        // Obtain a number between [0 - 3]
        int itemNum = rand.nextInt(4);

        //Makes its [1-4]
        itemNum += 1;

        //Assigns the Item to the monster
        switch(itemNum){
            case 1: this.monster.setItem("Choice Band");
            break;

            case 2: this.monster.setItem("Choice Scarf");
            break;

            case 3: this.monster.setItem("Eviolite");
            break;

            case 4: this.monster.setItem("Life Orb");
            break;
        }

        //If statements for which items are equipped
        if (this.monster.getItem() == "Eviolite"){
            statFloat = this.monster.getDefense() * 1.5f;
            newStat = Math.round(statFloat);
            this.monster.setDefense(newStat);
        }

        if(this.monster.getItem() == "Choice Band"){
            statFloat = this.monster.getAttack() * 1.5f;
            newStat = Math.round(statFloat);
            this.monster.setAttack(newStat);
        }

        if(this.monster.getItem() == "Choice Scarf"){
            statFloat = this.monster.getSpeed() * 1.5f;
            newStat = Math.round(statFloat);
            this.monster.setSpeed(newStat);
        }

        if(this.monster.getItem() == "Life Orb"){
            statFloat = this.monster.getAttack() * 1.3f;
            newStat = Math.round(statFloat);
            this.monster.setAttack(newStat);
        }
    }



}