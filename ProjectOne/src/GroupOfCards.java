import java.util.ArrayList;

public class GroupOfCards {
    private ArrayList<Card> cards;
    int topCard = 0;
    GroupOfCards(){
        cards = new ArrayList<>();
    }

    void addCard(Card c){
        cards.add(c);
    }
    // EFFECTS: adds the card "c" to those presently held.

    void discardAll(){
        cards.clear();
    }
    // EFFECTS: discards any cards presently held, restoring the state
    // of the cards to empty.

    int getCurrentSize(){
        return cards.size();
    }
    // EFFECTS: return the length of cards;

    void display(){
        for(Card card : cards){
            System.out.print(card);
        }
    }
    //EFFECTS: display every card in cards;

    Card deleteCard(){
        return cards.remove(cards.size() - 1);
    }
    // EFFECTS: delete the top card from the group of cards and return the
    // deleted card value;

    Card deleteCard(int i) {
        return cards.remove(i);
    }

    void addCard(int i, Card c) {
        cards.add(i, c);
    }

    Card getCard(int i) {
        return cards.get(i);
    }

    Card getTop() {
        return cards.get(cards.size() - 1);
    }

}
