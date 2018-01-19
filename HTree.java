//Class that gives function for the tree.
//@author Vialli Ou

public class HTree implements Comparable<HTree> {
    
   //Public instance variables.
   public int freq; 
    
   //Default constructor for the tree object.
   public HTree(int freq){
      this.freq = freq;
   }
    
   //Method to compare the tree.
   //@para HTree - tree you want to compare.
   //@return int - the value of the two trees compared.
   public int compareTo(HTree tree) {
      return this.freq - tree.freq;
   }
}