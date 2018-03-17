package RockPaperScissors;

public class Tool {
    private int strength;
    protected char type;

    Tool(int strength){
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
}
