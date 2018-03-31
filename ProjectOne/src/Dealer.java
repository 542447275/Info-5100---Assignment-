
public class Dealer {

    Hand hand;

    Dealer(){
        hand = new Hand();
    }

    public boolean draw(){
        return hand.getHandValue().value < 17;
    }
    // EFFECTS: For dealer The dealer must
    // hit until he either reaches a total greater than or equal to 17
    // (hard or soft), or busts.
}
