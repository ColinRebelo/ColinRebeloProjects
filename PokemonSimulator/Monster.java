public class Monster{
    

    //Declarations for variables

    public String name;
    public String type;
    public int hp;
    public int speed;
    public int attack;
    public int defense;
    public String item;
    public Move move1;
    public Move move2;
    public Move move3;
    public Move move4;

    /**
     * @param name monster's name
     * @param type monster's type
     * @param hp monster's hp
     * @param speed monster's speed
     * @param attack monster's attack
     * @param defense monster's defense
     * @param item monster's item
     * @param move1 monster's move1
     * @param move2 monster's move2
     * @param move3 monster's move3
     * @param move4 monster's move4
     */

    //Constructor for monster
    public Monster(String name, String type, int hp, int speed, int attack, int defense, String item, Move move1, Move move2, Move move3, Move move4){
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.item = item;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }
    
    //getter and setter functions for all the values in constructor
    /**
     * 
     * @return Monster's name
     */
    public String getName(){return this.name;}

    /**
     * 
     * @return Monster's type
     */

    public String getType(){return this.type;}

    /**
     * 
     * @return Monster's HP
     */
    public int getHP(){return this.hp;}

    /**
     * Assigns the monsters HP value to the inputted integer
     * @param hp new HP value of the monster
     */
    public void setHP(int hp){this.hp = hp;}


    /**
     * 
     * @return Monster's speed
     */
    public int getSpeed(){return this.speed;}


    /**
     * Assigns the monsters speed value to the inputted integer
     * @param speed new speed value of the monster
     */
    public void setSpeed(int speed){this.speed = speed;}


    /**
     * 
     * @return Monster's attack
     */
    public int getAttack(){return this.attack;}


    /**
     * Assigns the monsters attack value to the inputted integer
     * @param attack new attack value of the monster
     */
    public void setAttack(int attack){this.attack = attack;}

    
    /**
     * 
     * @return Monster's defense
     */
    public int getDefense(){return this.defense;}


    /**
     * Assigns the monsters defense value to the inputted integer
     * @param defense new defense value of the monster
     */
    public void setDefense(int defense){this.defense = defense;}


    /**
     * Assigns the monsters item to the inputted string
     * @param item new item to be held by the monster
     */
    public void setItem(String item){this.item = item;}

    /**
     * 
     * @return Monster's item
     */
    public String getItem(){return this.item;}


    /**
     * @return Monster's move1
     */
    public Move getMove1(){return this.move1;}


    /**
     * 
     * @return Monster's move2
     */
    public Move getMove2(){return this.move2;}


    /**
     * 
     * @return Monster's move3
     */
    public Move getMove3(){return this.move3;}


    /**
     * 
     * @return Monster's move4
     */
    public Move getMove4(){return this.move4;}
}

