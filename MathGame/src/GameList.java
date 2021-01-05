//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P06 Math Game
// Files: GameApplication.java, GameList.java, GameNode.java, GameTests.java
// Course: CS 300, Fall 2018
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: William Cady
// Partner Email: wcady@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x_ Write-up states that pair programming is allowed for this assignment.
// _x_ We have both read and understand the course Pair Programming Policy.
// _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Online Sources: https://www.tutorialspoint.com/java/java_string_charat.htm
//                 Above link was used to determine how to implement Atchar() 
//                 method.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * This class represents the list that the GameNodes are stored in.
 * @author Yukun Li
 *
 */
public class GameList {
  
  private GameNode list; // reference to the first GameNode in this list
  
  /**
   * Creates a GameList object with no nodes in ita.
   */
  public GameList() {
    this.list = null;
  }
  
  /**
   * This method adds a new GameNode object to the end of the GameList object
   * @param newNode is a GameNode that will be added to the end of GameList
   */
  public void addNode(GameNode newNode) {
    if(this.list == null) {
      this.list = newNode;
    }else {
      GameNode lastNode = this.list;
      while(lastNode.getNext() != null) {
        lastNode = lastNode.getNext();
      }
      lastNode.setNext(newNode);
    }
    
  }
  
  /**
   * This method checks to see if an certain int is in one of the GameNodes within the 
   * GameList object.
   * @param number is an int that will be looked for in the GameNodes.
   * @return a boolean that is true if the int is in one of GameNodes and false if it is
   *         not.
   */
  public boolean contains(int number) {
    boolean contains = false;
    if (this.list == null) { // First check to see if the GameList has any GameNodes
      return contains;
    } else {
      GameNode lastNode = this.list;
      while (lastNode.getNext() != null) { // Loop through each node and check it's number
                                           // against the int parameter.
        if (lastNode.getNumber() == number) {
          contains = true;
          return contains;
        }
        lastNode = lastNode.getNext();
        if(lastNode.getNumber() == number) { // Allows us to check the last node in the list 
          contains = true;
          return contains;
        }   
      }
    }
    return contains;
  } 
  
  /**
   * returns a string with each number in the list separated by " -> "s, and ending 
   * with " -> END"
   */
  public String toString() {
    if (this.list == null) {
      String null_string = "";
      return null_string;
    } else {
      GameNode lastNode = this.list;
      String printString = "";
      while(lastNode.getNext() != null) {
        printString = printString + lastNode.getNumber() +" -> ";
        lastNode = lastNode.getNext();
      }
      printString += lastNode.getNumber() + " -> END";
      return printString; 
    }
  } 
  
  /**
   * Applies an operator to GameNodes held within GameList.
   * @param number is an int used to identify the GameNode the operator should be applied
   *        to.
   * @param operator is a GameOperator object that specifies which operator should be applied.
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {
    GameNode lastNode = this.list;
    while(lastNode.getNext() != null) {
      if(lastNode.getNumber() == number) {
        lastNode.applyOperator(operator);
        break;
      }
      lastNode = lastNode.getNext();
    }    
  }
}
