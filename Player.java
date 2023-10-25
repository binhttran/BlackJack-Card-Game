/* code by: Binh Tran
 * email: tranb@bu.edu
 * Player object: a blueprint that represents a single human player(the user)
 */
import java.util.*;
public class Player {
    private String name;
    private Card[] hand;
    private int numCards;

    // player constructor 
public Player(String name){
    this.name = name;
    this.numCards = 0;
    this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];

}
//returns the player’s name
public String getName(){
    return this.name;
}
//returns the current number of cards in the player’s hand.
public int getNumCards(){
    return this.numCards;
}
//returns the player’s name.
public String toString(){
    String str = this.name;
    return str;
}

//takes a Card object as a parameter and adds the 
//specified card to the player’s hand, filling the 
//array from left to right
public void addCard(Card x){
    if(this.numCards > Blackjack.MAX_CARDS_PER_PLAYER){
        throw new IllegalArgumentException();
    }
    else if (x ==  null){
        throw new IllegalArgumentException();
    }
   this.hand[this.numCards] = x;
   this.numCards ++;
   
    }
    
    


// takes an integer index as a parameter and returns 
//the Card at the specified position in the player’s hand
public Card getCard(int index){
    if (index > this.getNumCards() - 1 || index < 0){
        throw new IllegalArgumentException();
    } else if (this.hand[index]== null){
        throw new IllegalArgumentException();
    }else{
        return this.hand[index];
    }
    
}


// dont know how to call method of another class
//computes and returns the total value of the player’s current hand
public int getHandValue(){
    int sum = 0;
    for (int i = 0; i < this.getNumCards(); i++){
        if (this.hand[i].isAce()){
            if (sum + 11 > 21) {
                sum += 1;
            } else{
                sum += 11;
            }
        } else{
             sum += this.getCard(i).getValue(); 
        }
    }
    return sum;
}


// prints the current contents of the player’s hand, 
//followed by the value of the player’s hand
public void printHand(){
    String str = ""; 
    for (int i = 0; i < this.numCards; i++){
       
        str += this.hand[i] + "  ";
    }
   str += "(value = "+ this.getHandValue() + ")";
   System.out.println(str);
}

//returns true if the player has Blackjack 
public boolean hasBlackjack(){
    boolean result = false;
    if (this.getNumCards() == 2){
        if (this.getHandValue() == 21){
            result = true;
        }else{
            result = false; 
        }
        result = false;
    } return result;
}


//return true if the player wants another hit,
// and false if the player does not want another hit
public boolean wantsHit(Scanner console, Player player){
    System.out.println("Want another hit, " + this.name + " (y/n)?");
    String answer =  console.nextLine();
    boolean result ;
    if (answer.equals("y") ||answer.equals("Y")){
        result = true;
    } else if (answer.equals("n") || answer.equals("N")) {
         result = false;
    } else{
        result = false;
    }
   
    return result;
}  
    


//get rid of all of the cards in the player’s hand, 
//to prepare for a new round of the game
public void discardCards(){ 
    for (int i = 0; i < this.getNumCards(); i ++){
        this.hand[i] = null;  
       
    } 
    this.numCards = 0;
    
    }
}


