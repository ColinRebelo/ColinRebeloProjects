//Scanner used for user input random for accuracy math for float rounding in attack
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;


public class HumanPlayer extends Player{
    //Globally defines scanner
    Scanner scanner = new Scanner(System.in);
    //Globally defines moveNumLock In the case the user selects a Choice Item
    
    //Human player constructor
    /**
     * Assigns monster to the Human Player
     * @param monster The monster of HumanPlayer
     */
    public HumanPlayer(Monster monster){this.monster = monster;}


    /**
     * @return the integer chosen by the user
     */
    //User input with scanner
    protected int chooseMove(){
        //c is the value for the while loop
        int moveNum = 1;
        int c = 1;
        //Assigns move for the System output
        Move move1 = this.monster.getMove1();
        Move move2 = this.monster.getMove2();
        Move move3 = this.monster.getMove3();
        Move move4 = this.monster.getMove4();

        //Returns the move locked if monster has a choice item
        if (moveNumLock > 0){
            System.out.println("Choice Item forces you to repeat your move");
            return moveNumLock;
        }
        //While loop for the user to pick a move
        while (c == 1){
            System.out.println("-------------------------");
            System.out.println("1: " + move1.getName());
            System.out.println("2: " + move2.getName());
            System.out.println("3: " + move3.getName());
            System.out.println("4: " + move4.getName());
            System.out.println("-------------------------");
            System.out.println("");


            //Try statement for an integer
            try{
                //uses scanner to pick the move used from console
                System.out.print("Enter any number (1-4, anything out of range will select 1): ");
                moveNum = scanner.nextInt();
                if(this.monster.getItem() == "Choice Band" || this.monster.getItem() == "Choice Scarf"){
                    moveNumLock = moveNum;
                    return moveNumLock;
                }else{moveNumLock = 0;}
                c = 2;
            }
            catch(Exception e){
                System.out.println("Enter a number (1-4): ");

            }
        }
        //Returns the move number selected
        return moveNum;
    }


    /**
     * Assigns the Item chosen by the user to the monster
     */
    protected void chooseItem(){
        int itemNum = 1;
        int c = 1;
        float statFloat;
        int newStat;

        //Loops when c is 1
        while(c == 1){
            System.out.println("-------------------------");
            System.out.println("1: Choice Band: Locks you into 1 move but your attack is multiplied by 1.5x");
            System.out.println("2: Choice Scarf: Locks you into 1 move but your speed is multiplied by 1.5x");
            System.out.println("3: Eviolite: Raises your defense by 1.5x if you are not fully evolved");
            System.out.println("4: Life Orb: Reduces some HP when you attack in return for a damage boost of 1.3x");
            System.out.println("5: No Item: Challenge your opponent with no item equipped");
            System.out.println("-------------------------");
            System.out.println("");

            try{
                //uses scanner to pick the item used from console
                System.out.print("Enter any number (1-5): ");
                itemNum = scanner.nextInt();
                c = 2;
            }
            catch(Exception e){
                System.out.println("Enter a number (1-5): ");
            }   
        }

        //Switch statement for Assigning the item to monster
        switch(itemNum){
            case 1: this.monster.setItem("Choice Band");
            break;

            case 2: this.monster.setItem("Choice Scarf");
            break;

            case 3: this.monster.setItem("Eviolite");
            break;

            case 4: this.monster.setItem("Life Orb");
            break;
            
            case 5: this.monster.setItem("None");
            break;
        }


        //This section is for adding the buffs depending on which item is selected

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