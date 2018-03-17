package RockPaperScissors;

public class Paper extends Tool {
    public Paper(int strength){
        super(strength);
        this.type = 'p';
    }
    public boolean fight(Tool tool){
        if(tool.type == 'r') {
            setStrength(getStrength() * 2);
            return true;
        } else if(tool.type == 's') {
            setStrength(getStrength() / 2);
            return false;
        }
        return false;
    }
}
