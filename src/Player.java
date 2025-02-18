public class Player {
    private String name;
    private int hp;
    private int mp;
    private int exp;
    private int level;
    private int damageAttack;
    private double x,y;//position
    private double heSoExp = 1;
    public Player(String name){
        this.name = name;
        this.hp = 100;
        this.mp = 100;
        this.exp = 0;
        this.level = 1;
        this.damageAttack = 10;
        this.x = 0;
        this.y = 0;
    }
    void setName(String name){
        this.name = name;
    }
    //Level up

    //Increase hp, mp, damageAttack

    //Level up when exp >= 100

    //Attack enemy

    //Move player

    //Apply item

    //Get position
}
