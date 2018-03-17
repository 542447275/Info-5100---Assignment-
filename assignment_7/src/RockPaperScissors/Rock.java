package RockPaperScissors;

public class Rock extends Tool {
    public Rock(int strength){
        super(strength);
        this.type = 'r';
    }

    public boolean fight(Tool tool){
        if(tool.type == 's') {
            setStrength(getStrength() * 2);
            return true;
        } else if(tool.type == 'p') {
            setStrength(getStrength() / 2);
            return false;
        }
        return false;
    }
}
