import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck theDeck = new Deck(1,true);

        Player me = new Player("Ahmed");
        Player dealer = new Player("Dealer");

        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        System.out.println("Cards are dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println();

        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while (!meDone || !dealerDone){
            if (!meDone){
                System.out.print("Hit Or Stay? (Enter H or S): ");
                ans = scanner.next();
                System.out.println();

                if (ans.compareToIgnoreCase("H") == 0){
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);
                }else {
                    meDone = true;
                }
            }

            if(!dealerDone){
                if (dealer.getHandSum() < 17){
                    System.out.println("The Dealer Hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                }else {
                    System.out.println("The Dealer stays\n");
                    dealerDone = true;
                }
            }

            System.out.println();
        }

        scanner.close();

        me.printHand(true);
        dealer.printHand(true);

        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if (mySum > dealerSum && mySum <= 21 || dealerSum > 21){
            System.out.println("You Win!");
        }else {
            System.out.println("Dealer Wins!");
        }
    }
}