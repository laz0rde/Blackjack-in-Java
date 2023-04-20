public class Card {
    private Suit mySuit;
    private int myNumber;

    public Card(Suit aSuit,int aNumber){
        this.mySuit = aSuit;

        if (aNumber >=1 && aNumber<=13)
            this.myNumber = aNumber;
        else{
            System.err.println(aNumber + " is Not a valid number");
            System.exit(1);
        }
    }

    public int getNumber(){
        return myNumber;
    }

    public String toString(){
        String numStr = switch (this.myNumber) {
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            case 1 -> "Ace";
            default -> "Not";
        };

        return numStr + " of " + mySuit.toString();
    }
}
