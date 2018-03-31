
public class SimplePlayer extends Player {
    SimplePlayer(int bankroll, int minimum) {
        super(bankroll, minimum);
    }

    @Override
    public int bet() {
        bankroll -= minimum;
        return minimum;
    }

    @Override
    public void expose(Card c) {
        System.out.println("Current card is " + c.getSpot().getValue() + " " + c.getSuit());
    }

    @Override
    public void shuffled() {
        System.out.println("Cards have shuffled!");
    }2

    @Override
    public boolean draw(Card dealer) {
        if(!hand.getHandValue().soft){
            if(hand.getHandValue().value <= 11){
                return true;
            }

            if(hand.getHandValue().value == 12){
                return dealer.getSpot().getValue() != 4 && dealer.getSpot().getValue() != 5 && dealer.getSpot().getValue() != 6;
            }


            if(hand.getHandValue().value >= 13 && hand.getHandValue().value <= 16 ){
                return dealer.getSpot().getValue() < 2 || dealer.getSpot().getValue() > 6;
            }

            if(hand.getHandValue().value >= 17){
                return false;
            }

        }else if(hand.getHandValue().soft) {
            if(hand.getHandValue().value <= 17){
                return true;
            }
            if(hand.getHandValue().value == 18){
                return dealer.getSpot().getValue() != 2 && dealer.getSpot().getValue() != 7 && dealer.getSpot().getValue() != 8;
            }
            if(hand.getHandValue().value >= 19)
                return false;
        }
        return false;
    }
}
