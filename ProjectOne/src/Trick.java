
public class Trick {

    Deck deck;
    Player player;
    Dealer dealer;
    int wager;

    int trickTimes = 0;
    int bankroll = 0;

    Trick(Player player, Dealer dealer, Deck deck){
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    Trick(String type, int bankroll, int minimum, int trickTimes){
        if(type.equals("simple"))
            player = new SimplePlayer(bankroll, minimum);
        else if(type.equals("counting"))
            player = new CountingPlayer(bankroll, minimum);
        this.trickTimes = trickTimes;
        this.bankroll = bankroll;
    }

    void play() throws DeckEmptyException{
        wager();
        DealFour();
        playerTurn();
        dealerTurn();
        closeTurn();
    }
    // execute the five following steps;

    void wager(){
        wager = player.bet();
        System.out.println( "Player bets " + wager);
    }

    void DealFour() throws DeckEmptyException{
        player.hand.discardAll();
        dealer.hand.discardAll();

        Card card = deck.deal();
        System.out.println("Player dealt " + card);
        player.hand.addCard(card);
        player.expose(card);

        card = deck.deal();
        System.out.println("Dealer dealt " + card);
        dealer.hand.addCard(card);
        player.expose(card);

        card = deck.deal();
        System.out.println("Player dealt " + card);
        player.hand.addCard(card);
        player.expose(card);

        card = deck.deal();
        dealer.hand.addCard(card);
        System.out.println("Dealer dealt [hole card]");
    }
    // After the wager, the dealer deals a total of four cards:
    // the first face-up to the player, the second face-up to
    // himself, the third face-up to the player, and the fourth
    // face-down to himself.

    void playerTurn() throws DeckEmptyException{
        while (player.draw(dealer.hand.getCard(0))){
            Card card = deck.deal();
            System.out.println("Player dealt " + card);
            player.hand.addCard(card);
            player.expose(card);
        }
        int count = player.hand.getHandValue().value;
        System.out.println("Player's total is " + count);
        if(count > 21)
            System.out.println("Player busts");
    }

    void dealerTurn()throws DeckEmptyException{
        if (player.hand.getHandValue().value > 21 ||player.hand.getHandValue().value == 21 && player.hand.getCurrentSize() == 2)
            return;
        Card card = dealer.hand.getTop();
        System.out.println("Dealer's hole card is " + card);
        player.expose(card);
        while (dealer.draw()){
            card = deck.deal();
            System.out.println("Dealer dealt " + card);
            dealer.hand.addCard(card);
            player.expose(card);
        }

        System.out.println("Dealer's total is " + dealer.hand.getHandValue().value);
        if (dealer.hand.getHandValue().value > 21) {
            System.out.println("Dealer busts");
        }
    }

    // dealer's turn only happens if the player hasn’t busted or the player is
    // not dealt a natural 21 .

    void closeTurn(){
        if(player.hand.getHandValue().value == 21 && player.hand.getCurrentSize() == 2){
            System.out.println("Player dealt natural 21");
            player.win(wager * 3 / 2);
            return;
        }
        if(player.hand.getHandValue().value > 21)
            return;
        if(dealer.hand.getHandValue().value > 21){
            player.win(wager * 2);
            return;
        }
        if(dealer.hand.getHandValue().value < player.hand.getHandValue().value){
            System.out.println("Player wins");
            player.win(wager * 2);
            return;
        }
        if(dealer.hand.getHandValue().value == player.hand.getHandValue().value){
            System.out.println("Push");
            player.win(wager);
            return;
        }
        System.out.println("Dealer wins");

    }
    // compare the count and give back reward to player if win.

}






























