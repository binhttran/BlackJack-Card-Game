/*
 * Card.java
 *
 * A blueprint class for objects that represent a single playing card
 * that has a rank and a suit.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: Binh Tran tranb@bu.edu
 */

public class Card {
    /* constants for the ranks of non-numeric cards */
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    /* other constants for the ranks */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    /* 
     * class-constant array containing the string representations
     * of all of the card ranks. 
     * The string for the numeric rank r is given by RANK_STRINGS[r].
     */
    public static final String[] RANK_STRINGS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };
    
    /* 
     * class-constant array containing the char representations
     * of all of the possible suits.
     */
    public static final char[] SUITS = {'C', 'D', 'H', 'S'};

    
    /* Put the rest of the class definition below. */
    // returns the index of the rank
    public static int rankNumFor(String rank){
   
      if (rank.equals("A")){
        return 1;
      } else if (rank.equals("J")){
        return 11;
      } else if (rank.equals("Q")){
        return 12;
      }else if (rank.equals("K")){
        return 13;
      }
      for(int i = 1; i < RANK_STRINGS.length; i++){
        if (RANK_STRINGS[i].equals(rank)){
          return i;
    }
      }
      return -1;
    
  }

    // determines if a suit is valid
    public static boolean isValidSuit(char suit){
      for (int i = 0; i < SUITS.length; i++){
        if (SUITS[i] == suit){
            return true;
        }
      }
      return false;
    }
    
    private int rank;
    private char suit;
    // constructors that take in different parameters
    public Card(int rank, char suit){
      this.rank = rank;
      this.suit = suit;
      if(isValidSuit(suit) == false){
        throw new IllegalArgumentException();
      }
      if ((rank > 13) || (rank <= 0)) {
        throw new IllegalArgumentException();
      }
    }

    
    public Card(String cards){
      String cardRank = cards.substring(0, (cards.length() - 1));
      this.rank = rankNumFor(cardRank);
      this.suit = cards.charAt(cards.length() - 1);
      if (cards.equals(null)){
        throw new IllegalArgumentException();
      }
      if (cards.length()> 3 ){
        throw new IllegalArgumentException();
      }
    }

     // get the rank 
    public int getRank(){
      return this.rank;
    }
    // get the suit
    public char getSuit(){
      return this.suit;
    }
    // determines if it is ACE
    public boolean isAce(){
      if (this.rank == ACE){
        return true;
      } 
      return false;
    }
     // determines if it's a face card

    public boolean isFaceCard(){
      if ((this.rank == 11) ||(this.rank == 12) ||(this.rank == 13)){
        return true;
      } 
      return false;
    }
    // get the value of the card

    public int getValue(){
      if (isFaceCard() == true){
        return 10;
      } else{
        return this.rank;
      }
    }
    // returns the rank and suit of the card
    public  String toString(){
    return RANK_STRINGS[this.rank] + this.suit;
    }
    // see if it is the same suit as Other card
    public  boolean sameSuitAs(Card other ){
      return (other != null           
      && this.suit == other.suit);
    }
    // see if it is equal (same suit and rank) as Other card
    public boolean equals(Card other){
      return (other != null   
      && this.rank == other.rank        
      && this.suit == other.suit);

    }
      public static void main(String[] args){
        //returns 12
        System.out.println(rankNumFor("Q"));
        //returns True
        System.out.println(isValidSuit('D'));
      }
    


}
