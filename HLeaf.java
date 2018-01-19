//Class for the leaf nodes of the tree.
//@author Vialli Ou

public class HLeaf extends HTree {
   
   //Public instance variables.
   public char symbol;
   
   //Default constructor for the leaf object.
   //@param int - the frequency of the character
   //@param char - the actual character. 
   public HLeaf(int freq, char symbol) {
      super(freq);
      this.symbol = symbol;
   }
}
