//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P08 ASCII Art
// Files: AsciiArt.java, AsciiTest.java, Canvas.java DrawingChange.java,
//        DrawingStack.java, DrawingStackIterator.java
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
// Online Sources: http://cs300-www.cs.wisc.edu/wp/index.php/2018/10/29/week09
//                 -stacks-and-queues/
//                 These notes helped us to create the DrawingStack class
//
//                 https://dzone.com/articles/prefer-systemlineseparator-for-writing
//                 -system-depe
//                 This link was used to help understand how to use
//                 System.linesepartor
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Iterator;
/**
 * This class is used to test all of the methods within the DrawingStack class
 * @author Will and Yukun
 *
 */
public class AsciiTest {
  
  /**
   * This method checks to see if Push and Peek methods are working correctly
   * @return a boolean that is true if both methods are working correctly and false if
   *         otherwise.
   */
  public static boolean testStackPushPeek() {
    boolean testPassed = true;
    
    // Create a test stack
    DrawingChange change1 = new DrawingChange(1, 1, 'a', 'b');
    DrawingChange change2 = new DrawingChange(1, 2, 'c', 'd');

    DrawingStack testStack = new DrawingStack();
    
    // Check to see if push and size are working correctly
    testStack.push(change1);
    if (testStack.size() != 1) {
      System.out.println("Failed to add node to stack or size() is working incorrectly");
      testPassed = false;
    }
    
    // Check to see if peek and push are working correctly
    if(testStack.peek()!=change1) {
      System.out.println("Failed to add Node or Peek is working incorreclty");
      testPassed = false;
    }

    testStack.push(change1);
    testStack.push(change2);
    
    // Check to see if peek is working correctly
    if (testStack.peek() != change2) {
      System.out.println("Peek method failed.");
      testPassed = false;
    }

    System.out.println("All tests passed!");
    return testPassed;
  }
  
  
  /**
   * This method tests to see if Pop() is working correctly.
   * @return a boolean that is true if Pop() method is working correctly and false if
   *         otherwise.
   */
  public static boolean testStackPop() {
    boolean testPassed = true;
    
    // Create testStack
    DrawingChange change1 = new DrawingChange(1, 1, 'a', 'b');
    DrawingChange change2 = new DrawingChange(1, 2, 'c', 'd');

    DrawingStack testStack = new DrawingStack();
    
    testStack.push(change1);
    testStack.push(change2);
    
    // Check to see if pop() works correctly
    DrawingChange testPop = testStack.pop();
    if(testPop != change2) {
      System.out.println("Pop method test 1 failed.");
      testPassed = false;
    }
    
    // Check to see if pop() works correclty when called more than once
    DrawingChange testPop1 = testStack.pop();
    if(testPop1 != change1) {
      System.out.println("Pop method test 2 failed.");
      testPassed = false;
    }
    
    DrawingStack testStackNull = new DrawingStack();
    
    DrawingChange testPopNull = testStackNull.pop();
    // Check to see if pop works when the stack is empty
    if(testPopNull != null) {
      System.out.println("Pop method test 3 failed.");
      testPassed = false;
    }
    
    
    return testPassed;
    
  }
  
  /**
   * This method checks to see isEmpty() is working correctly.
   * @return a boolean that is true if isEmpty() method is working correctly and false if
   *         otherwise.
   */
  public static boolean testStackIsEmpty() {
    boolean testPassed = true;
    DrawingStack testStack = new DrawingStack();
    
    // Check to see if isEmpty correctly identifies an empty stack
    if(!testStack.isEmpty()) {
      System.out.println("isEmpty method failed test 1.");
      testPassed = false;
    }
    
    // Create a testStack
    DrawingChange change1 = new DrawingChange(1, 1, 'a', 'b');
    DrawingChange change2 = new DrawingChange(1, 2, 'c', 'd');

    DrawingStack testStack1 = new DrawingStack();
    
    testStack1.push(change1);
    testStack1.push(change2);
    
    // Check to see if isEmpty identifies a non-empty testStack.
    if(testStack1.isEmpty()) {
      System.out.println("isEmpty method failed test 2.");
      testPassed = false;
    }
    return testPassed;
    
  }
  
  /**
   * Checks to see if iterator() is working correctly
   * @return a boolean that is true if iterator() method is working correctly and false if
   *         otherwise.
   */
  public static boolean testStackIterator() {
    boolean testPassed = false;
    
    DrawingStack testStack = new DrawingStack();
    
    // Check to see if iterator() creates an iterator object.
    if(testStack.iterator() instanceof DrawingStackIterator) {
      testPassed = true;
      return testPassed;
    }
    System.out.println("StackIterator method failed test.");

    return testPassed;
  }
  

  /**
   * Runs all the tests and checks to see if all have passed or if one or more has failed.
   * @return a boolean that is true if all methods are working correctly and false if
   *         otherwise.
   */
  public static boolean runStackTestSuite() {
    int testPassed = 0;
    int testTotal = 4;
    if (testStackPushPeek()) {
      testPassed++;
    }
    if (testStackPop()) {
      testPassed++;
    }
    if(testStackIsEmpty()) {
      testPassed++;
    }
    if(testStackIterator()) {
      testPassed++;
    }
    if (testPassed == testTotal) {
      return true;
    }
    return false;
  }
  
  /**
   * Driver method for this class.
   * @param args
   */
  public static void main(String[] args) {
    //testStackPushPeek();
    runStackTestSuite();
  }

}

