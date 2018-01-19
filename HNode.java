//Class of nodes that build the tree.
//@author Vialli Ou

public class HNode extends HTree {
   
   //Public instance variables.
   public HTree leftNode; 
   public HTree rightNode;
   
   //Default constructor for the node object.
   //@param HTree - the left node of the tree.
   //@param HTree - the right node of the tree.
   public HNode(HTree leftNode, HTree rightNode) {
      super(leftNode.freq + rightNode.freq);
      this.leftNode = leftNode;
      this.rightNode = rightNode;
   }
}