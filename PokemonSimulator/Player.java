import java.util.Random;

abstract public class Player{
    //variable definition
    public Monster monster;
    protected int moveNumLock = 0;

    /**
     * 
     * @return Player's Monster
     */
    public Monster getMonster(){
        return this.monster;
    }

    /**
     * Assigns an item to Monster
     */
    protected abstract void chooseItem();

    /**
     * 
     * @return the integer the user inputted or CPU randomly selects
     */
    protected abstract int chooseMove();

    /**
     * 
     * @return whether or not the pokemon has fainted
     */
    //Determines if the pokemon is fainted
    protected boolean hasLost(){
        boolean isDown;
        //Checks the HP value
        if(this.monster.getHP() <= 0){
            isDown = true;
        }
        else{
            isDown = false;
        }
        //Returns the boolean value
        return isDown;
    }
    

    /**
     * 
     * @param player player used to the comparison
     * @return Whether or not the pokemon is faster
     */
    //Determines who moves first based on speed
    protected boolean isFasterThan(Player player){
        boolean isFaster = false;
        //Checks the speed values to determine if the pokemon is faster
        if(this.monster.getSpeed() >= player.monster.getSpeed()){
            isFaster = true;
            return isFaster;
        }        //Returns the boolean value

        return isFaster;
    }
    

    /**
     * 
     * @param player player who is being attacked
     * @param move move used against the pokemon
     */
    protected void attack(Player player, int move){
        /*
        A quick note, after doing research a critical hit after generation VI will result in a 1.5x damage boost with a 6.25% chance
        to occur, so I will be using those rules in this version of the Emulator
        Stab also results in a multiplier which would multiply with the crit, so this will also be implimented
        critChance is 625 because 625 / 10000 = 6.25% and is easier to compare using my method
        */
        int critChance = 625;
        int damageDealt;
        float damageDealtFloat;
        int newHP;
        float newHPFloat;
        float accuracy;
        float healthReduction;
        Move moveUsed = this.monster.getMove1();
        //Switch case to assign the Move
        switch(move){
            case 1: moveUsed = this.monster.getMove1();
            break;

            case 2: moveUsed = this.monster.getMove2();
            break;

            case 3: moveUsed = this.monster.getMove3();
            break;

            case 4: moveUsed = this.monster.getMove4();
            break;
        }

        Random randCrit = new Random();

        //If we make 6.25 rise to 625 we need 10000 as the denominator so 625/10000 = 6.25%
        int randCritNum = randCrit.nextInt(10000); 


        //Makes it [1-10000]
        randCritNum += 1;

        //Accuracy multiplied by 100 to make it easier for typecasting
        accuracy = (moveUsed.getAccuracy() * 100);
        //Typecasts the float to an int
        int intAccuracy = (int) accuracy;

        Random rand = new Random();

        // Obtain a number between [0 - 99]
        int accCheck = rand.nextInt(100);
        // makes the number between [1-100]
        accCheck += 1;


        //Checks if it is within the roll
        if(accCheck <= intAccuracy){

            
            damageDealt = this.monster.getAttack() + moveUsed.getAttack() - player.monster.getDefense();
            //Checks for stab and does the calculation
            if(moveUsed.getType() == this.monster.getType()){
                damageDealtFloat = damageDealt * 1.5f;
                damageDealt = Math.round(damageDealtFloat);
            }

            //Checks for the critical hit
            if(randCritNum <= critChance){
                damageDealtFloat = damageDealt * 1.5f;
                damageDealt = Math.round(damageDealtFloat);
                System.out.println(this.monster.getName() + " Landed a critical hit!");
            }

            //Checks for Life Orb buff
            if(this.monster.getItem() == "Life Orb"){
                healthReduction = this.monster.getHP() * 0.10f;
                newHPFloat = (this.monster.getHP() - healthReduction);
                newHP = Math.round(newHPFloat);
                this.monster.setHP(newHP);
                System.out.println("Due to the life orb " + this.monster.getName() + " lost 10% of its HP");
            }

            //Calculates the HP taken and sets it in the opponent
            newHP = (player.monster.getHP() - damageDealt);
            System.out.println(this.monster.getName() + " Used " + moveUsed.getName() + " It dealt " +  damageDealt + " Damage");
            player.monster.setHP(newHP);
    
        }

        //if it misses output to the console
        else{
            System.out.println("The attack missed.");
        }
    }



}