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
 * This class runs tests to make sure the most important methods are working correctly.
 * @author Yukun Li
 *
 */
public class GameTests {
  // tests for gameNode getNext method
  /**
   * This text checks when setNext is called if the method is setting the next node correctly
   * 
   * @return true if setNext returns correctly
   */
  public static boolean testSetNext() {
    boolean nextNumber = false;
    Random random = new Random();
    GameList list = new GameList();
    // set two gamenodes for testing
    GameNode gameNode1 = new GameNode(random);
    GameNode gameNode2 = new GameNode(random);
    // add the two gameNode in the list
    list.addNode(gameNode1);
    list.addNode(gameNode2);
    // check if the nextNode in the list is
    // the same as the node got from getNext method
    if (gameNode1.getNext() == gameNode2) {
      nextNumber = true;
    }

    return nextNumber;
  }


  /**
   * This test checks when applyOperator is called is the correct number is returned correctly
   * 
   * @return true when the right operation is performed
   */
  public static boolean testApplyOperator() {
    boolean applyCorrectly = false;
    Random random = new Random();
    GameList list = new GameList();
    // set two gamenodes for testing
    GameNode gamenode1 = new GameNode(random);
    GameNode gamenode2 = new GameNode(random);
    list.addNode(gamenode1);
    list.addNode(gamenode2);
    int target = gamenode1.getNumber() * gamenode2.getNumber();
    // see if the gamenode after applyoperator is equals to target
    gamenode1.applyOperator(GameOperator.ALL_OPERATORS.get(2));
    if (target == gamenode1.getNumber()) {
      applyCorrectly = true;
    }
    return applyCorrectly;
  }


  /**
   * this test is for checking if the addnode method works
   * 
   * @return true when addnode adds a gamenode correctly
   */
  public static boolean testAddNode() {
    boolean testNode = false;
    Random random = new Random();
    GameList list = new GameList();
    // create two nodes for test
    GameNode gameNode1 = new GameNode(random);
    GameNode gameNode2 = new GameNode(random);
    // adds two nodes to the list with addNode method
    list.addNode(gameNode1);
    list.addNode(gameNode2);
    // check if the node added is the correct node value
    if (gameNode1.getNext() == gameNode2) {
      testNode = true;
    }
    return testNode;
  }


  /**
   * this test checks if the method contains works
   * 
   * @return true if contains correctly 
   * returns if the list contains the node
   */
  public static boolean testContains() {
    boolean testContains = false;
    Random random = new Random();
    GameList list = new GameList();
    // add 2 nodes in the list
    GameNode gameNode1 = new GameNode(random);
    GameNode gameNode2 = new GameNode(random);
    list.addNode(gameNode1);
    list.addNode(gameNode2);
    // check if these nodes are "contained" in the list
    if (list.contains(gameNode1.getNumber()) && list.contains(gameNode2.getNumber())) {
      testContains = true;
    }
    return testContains;
  }

  
  /**
   * This method calls and displays the results of the tests.
   * @param args
   */
  public static void main(String[] args) {


    // TODO Call your test methods here
    System.out.println("testSetNext(): " + testSetNext());
    System.out.println("testApplyOperator(): " + testApplyOperator());
    System.out.println("testAddNode(): " + testAddNode());
    System.out.println("testContains(): " + testContains());



  }

}