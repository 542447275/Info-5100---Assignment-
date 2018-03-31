import java.util.Scanner;

public class blackjack {

    public static void main(String[] args) {
	    // write your code here first you need to use system in to ask four parameter from
        // console. Then run the game and print the relevant game step.

        System.out.println("Welcome to BlackJack");
        System.out.println("Please input Bankroll, Tricks, Minimum of wager and type of player(simple | counting)");
        Scanner scanner = new Scanner(System.in);
        int bankroll = scanner.nextInt();
        int tricks = scanner.nextInt();
        int minimum = scanner.nextInt();
        String type = scanner.next();
        Deck deck = new Deck();
        deck.shuffle(7);

        Dealer dealer = new Dealer();
        Player player = null;

        if (type.equals("simple")) {
            player = new SimplePlayer(bankroll, minimum);
        } else if(type.equals("counting")) {
            player = new CountingPlayer(bankroll, minimum);
        }

        int curTrick = 1;
        while (player.bankroll >= minimum && curTrick <= tricks) {
            Trick trick = new Trick(player, dealer, deck);
            System.out.println( "Trick " + curTrick + " bankroll " + player.bankroll);
            if (deck.cardsLeft() < 20) {
                deck.shuffle(7);
                player.shuffled();
            }
            try {
                trick.play();
            } catch (DeckEmptyException deckEmptyException) {
                deck.shuffle(7);
                player.shuffled();
                continue;
            }
            curTrick++;
        }
        System.out.println("Player has " + player.bankroll + " after " + (curTrick - 1) + " tricks");

    }
}
