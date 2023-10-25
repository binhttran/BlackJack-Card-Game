/* code by: Binh Tran
 * email: tranb@bu.edu
 * Dealer object: a blueprint that represents the Dealer, subclass of Player.
 */


import java.util.*;
public class Dealer extends Player {
    private boolean reveal;

    //constructor
    public Dealer(){
        super("dealer");
        this.reveal = false;

    }

    //indicate that the dealer’s first card should now be revealed
    public void revealFirstCard(){
        this.reveal = true;
    }
    // overrides the inherited printHand version 
    public void printHand(){
        String str = "";
        if(this.reveal == false){
                str += "XX" + "  ";
                for(int i = 1; i < this.getNumCards(); i++){
                    str += this.getCard(i) + "  "; 
                }
              System.out.println(str); 
            }  
      
        else if (this.reveal == true) {
             super.printHand();
        }
    
       
    }

    //determine if the dealer should give herself another hit, 
    //and return true or false accordingly
    public boolean wantsHit(Scanner console, Player player){
        boolean result = false ;
         if (player.hasBlackjack()){
            result = false;
         }
        else if(player.getHandValue() < 17){
            if (this.getHandValue() <= player.getHandValue()){ 
                 result = true;
            }
        } else if ( player.getHandValue() >= 17){
            if (this.getHandValue() < player.getHandValue()){
                result = true;

            }
        }
        return result;
        
    }
    // have the same effect as the inherited version of the method. 
    //In addition, it should reset the called object’s boolean field to its original value
    public void discardCards(){
        super.discardCards();
        this.reveal = false;
    }
    
}
