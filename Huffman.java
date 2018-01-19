//Driver class for Huffman Encoding program.
//@author Vialli Ou

import java.util.*;
import java.io.*;

public class Huffman{
   
   //Main throws IOException to handle .txt file not found. 
   public static void main(String args[])throws IOException{
           
      System.out.println("These are the characters and their frequencies you will be encoding:");
      //Create a Scanner object of the .txt file so you can read it.
      Scanner fileRead = new Scanner(new File("frequencies.txt"));
      //Instantiated variables and objects to be used.
      int count = 0; 
      String string = "";
      //While loop to print out characters and their frequencies that will be encoded.      
      while(fileRead.hasNextLine()){
         String symbol = fileRead.nextLine();
            if(count%2 == 0){
               System.out.print(symbol + "-");
               string = string + symbol;
            }
            else{
               System.out.print(symbol + " ");
            }
            count++;
      }
      //Close the .txt file because it is done reading. 
      fileRead.close();
      
      //Instantiated variables and objects to be used.
      int arraySize = count/2;
      int count2 = 0;
      int freqArrayIndex = 0;
      int[] freqArray = new int[arraySize];
      //Create another new Scanner object of the .txt file(second instance) because first instance of that file cannot be reread.
      Scanner fileRead2 = new Scanner(new File("frequencies.txt"));
      //While loop to make an array of the frequencies in the .txt file.
      while(fileRead2.hasNextLine()){
         String symbol2 = fileRead2.nextLine();
         if(count2%2 == 1){
            int freq = Integer.parseInt(symbol2);
            freqArray[freqArrayIndex] = freq;
            freqArrayIndex++;
         }
         count2++;
      }
      //Close the .txt file because it is done reading.
      fileRead2.close();
      //Instantiated variables and objects to be used.
      int charArrayIndex = 0;
      //Create an array that hold the ASCII decimal for the characters in the .txt file.
      int[] charArray = new int[256];
      //For loop to associate the character with their frequency in the array.
      for (char character : string.toCharArray()) {
            charArray[character] = freqArray[charArrayIndex];
				charArrayIndex++;
      }
      //Create the Huffman tree.
      HTree tree = createHuffmanTree(charArray);
      //Print out the Huffman code. 
      System.out.println("\nCharacters:\tHuffman Code:");
      printHuffmanCode(tree, new StringBuffer());      
         
   }
   
   //Method to create the Huffman tree.
   //@param int array - array that hold the ASCII decimal for the characters.
   //@return HTree - tree that is a priority queue. 
   public static HTree createHuffmanTree(int[] charArray) {      
      PriorityQueue<HTree> priorityQueueTree = new PriorityQueue<HTree>();

      for (int i = 0; i < charArray.length; i++){
         if (charArray[i] > 0){
            priorityQueueTree.offer(new HLeaf(charArray[i], (char)i));
         }
      }
      while (priorityQueueTree.size() > 1) {         
         HTree treePointerReference1 = priorityQueueTree.poll();
         HTree treePointerReference2 = priorityQueueTree.poll();
         priorityQueueTree.offer(new HNode(treePointerReference1, treePointerReference2));
      }
      return priorityQueueTree.poll();
   }  
   
   //Method to print the Huffman code.
   //@param HTree - tree to get the code from.
   //@param StringBuffer - string to be modified.
   public static void printHuffmanCode(HTree tree, StringBuffer value) {
         if (tree instanceof HLeaf) {
            HLeaf leaf = (HLeaf)tree;
            System.out.println(leaf.symbol + "\t\t" + value); 
         }
         //Recursively print to go through the tree and append 0 or 1 for the Huffman code.  
         else if (tree instanceof HNode) {
            HNode node = (HNode)tree;
            value.append('0');
            printHuffmanCode(node.leftNode, value);
            value.deleteCharAt(value.length()-1);
            value.append('1');
            printHuffmanCode(node.rightNode, value);
            value.deleteCharAt(value.length()-1);
         }
   }
}