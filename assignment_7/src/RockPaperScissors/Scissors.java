package RockPaperScissors;

public class Scissors extends Tool{
    public Scissors(int strength){
        super(strength);
        this.type = 's';
    }
    public boolean fight(Tool tool){
        if(tool.type == 'p') {
            setStrength(getStrength() * 2);
            return true;
        } else if(tool.type == 'r') {
            setStrength(getStrength() / 2);
            return false;
        }
        return false;
    }
}
