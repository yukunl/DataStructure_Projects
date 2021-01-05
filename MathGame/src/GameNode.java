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

import java.util.Random;

/**
 * This class represents the linked nodes that are stored in the GameList object.
 * @author Yukun Li
 *
 */
public class GameNode {
  
  private int number;    // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node
  
  /**
   * Creates a GameNode object intialized with a number that's a random int between 1 and 9
   * and next to null.
   * @param rng is a random object used to get a random int.
   */
  public GameNode(Random rng) {
    this.next = null;
    this.number = rng.nextInt(9)+1;
  } 
  
  /**
   * This method returns the number of a GameNode object.
   * @return an int that is the number stored in the GameNode object.
   */
  public int getNumber() {
    return this.number;
  } 
  
  /**
   * This method is a getter for the next field.
   * @return a GameNode object
   */
  public GameNode getNext() {
    return this.next;
  }
  
  /**
   * Setter for the next field of a GameNode object.
   * @param next is a GameNode object that the next field will be set to.
   */
  public void setNext(GameNode next) {
    this.next = next;
  } 
  
  /**
   * Applies the an operator to two GameNodes, updates the first GameNode's number and next 
   * field and removes the second GameNode from the list.
   * @param operator is a GameOperator that will be applied to the GameNodes.
   */
  public void applyOperator(GameOperator operator) {

    int firstOperand = this.getNumber();
    int secondOperand = this.getNext().getNumber();
    
    this.number = operator.apply(firstOperand,secondOperand); // update Number
    
    this.setNext(this.getNext().getNext()); // update Next
  } 

}
