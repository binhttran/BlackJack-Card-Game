/* 
 * ArrayBag.java
 *
 * A blueprint class for objects that represent a bag of other objects --
 * i.e., a collection of items in which the items do not have a position.
 * This implementation uses an array to store to objects in the bag.
 *
 * Computer Science 112
 *
 * modified by: <Binh Tran >, <tranb@bu.edu>
 */

import java.util.*;

public class ArrayBag {
    /** 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /** 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /**
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /** 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /**
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }
    
    /** 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /** 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /**
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }
    
    /**
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }
    
    /**
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // // Create an ArrayBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        ArrayBag bag1 = new ArrayBag(size);
        scan.nextLine();    // consume the rest of the line
        
        // // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // // Iterate over the objects in bag1, printing them one per
        // // line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();

        // // size - return 10
        ArrayBag b1 = new ArrayBag(10);
        System.out.println(b1.size());
         // count- return 1
        ArrayBag b2 = new ArrayBag(10);
        int[] vals = {7, 5, 3, 7, 7, 2, 5};
        for (int x : vals) {
        b2.add(x);
        }
         System.out.println(b2.count(2));

        // reduceSize- before: 8| after: 3
         ArrayBag b3 = new ArrayBag(8);
        b3.add("hello");
        b3.add("world");
        System.out.println(b3);
        System.out.println("size before: " + b3.size());

         b3.reduceSize(5);
         System.out.println(b3);
         System.out.println("size after: " + b3.size());

         //subtract 
         ArrayBag b5 = new ArrayBag(10);
         String[] letters5 = {"a", "a", "b", "d", "f", "f", "f", "g"};
         for (String ltr: letters5) {
         b5.add(ltr);
         }
         System.out.println(b5);

         ArrayBag b6 = new ArrayBag(7);
        String[] letters6 = {"b", "c", "e", "e", "g"};
       for (String ltr: letters6) {
        b6.add(ltr);
}
      System.out.println(b6);

      ArrayBag b7 = b5.subtract(b6);
      System.out.println(b7);
     System.out.println(b7.numItems());
     System.out.println(b7.size());
     System.out.println(b5);   // make sure original bags are unchanged
     System.out.println(b6);






    }
    // returns the max size of the array
    public int size(){
        return this.items.length;
    }
    // return a count of the number of times that 
    //the parameter item occurs in the called ArrayBag.
    public int count(Object item){
        int count = 0;
        for(int i = 0; i < this.size(); i++){
           if (this.items[i] == item){
            count ++;
           }
        }
           return count;        
    }

    //reduce the size of the called ArrayBag by the specified amount
    public boolean reduceSize(int decrease){
        //requested reduction in size wouldn’t leave enough room 
        //for all of the items in the ArrayBag, false.
        if (decrease < 0){
            throw new IllegalArgumentException();
        }
        else if(this.size() - decrease < this.numItems()){
            return false;
        }else{
            int newSize = this.size() - decrease;
            System.out.println("this is reduced size: " + newSize);
            Object[] newArray = new Object[newSize];
            for (int i = 0; i < newSize; i++){
                newArray[i] = this.items[i];
            }
            this.items = newArray;
            return true;
        }  
    }
    // determine if the called ArrayBag is equal to the parameter other
    public boolean equals(ArrayBag other){
        if(other == null){
            throw new IllegalArgumentException();
        } 
        int count = 0;
        if (this.numItems() == other.numItems()){
            for ( int i = 0; i < this.numItems(); i++){
              if( this.count(this.items[i]) == other.count(other.items[i])){
                count ++;
        }
    }   
}        if (count ==  this.numItems()) {
         return true;       
        }
        return false;
    }
    //create and return an ArrayBag containing one occurrence of 
    //any item from the called ArrayBag object that is not also present 
    //in the ArrayBag represented by the parameter other
    public ArrayBag subtract(ArrayBag other){
        
        if( other == null){
            throw new IllegalArgumentException();
        } int size = 0;
        if( this.numItems() == 0){
            size = 1;
        } else{
            size = this.numItems();
        }
        ArrayBag array = new ArrayBag(size);
        for (int i = 0; i < this.numItems(); i++){
            if (! other.contains(this.items[i])){
                if (!array.contains(this.items[i])){
                     array.add(this.items[i]);
                }            
            }
        }
        return array;
        
    }

}
