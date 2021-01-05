//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: BadgersSettleDown
// Files: Badger.java, Sett.java, P9Tests.java, BadgersSettleDown.java
// Course: CS300, Fall 2018
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Will Cady
// Partner Email: wcady@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Online Sources: https://www.geeksforgeeks.org/write-a-c-program-to-find-the-
//                 maximum-depth-or-height-of-a-tree/
//                 Used the above to link to learn about the logic of finding 
//                 the height of a tree.
//                 https://stackoverflow.com/questions/13756605/counting-the-
//                 nodes-in-a-binary-search-tree
//
//                 Used the above link to determine how to count the number of 
//                 Badgers in the sett.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.List;

/**
 * This class runs test to determine if the Badger and Sett classes are working properly.
 * @author Will and Yukun
 *
 */
public class P9Tests {

  /**
   * Tests badgerConstructor() method in the Badger class
   * 
   * @return true if badgerConstructor() sets getLeftLowerNeighbor to null, getRightLowerNeighbor to
   *         null, and size to the same as parameter
   */
  private static boolean testBadgerConstructor() {
    boolean testPassed = true;
    Badger test = new Badger(7);

    if (test.getLeftLowerNeighbor() != null) {
      testPassed = false;
      System.out.println("Left neighbor of Badger not constructed properly.");
    }

    if (test.getRightLowerNeighbor() != null) {
      System.out.println("Right neighbor of Badger not constructed properly.");
      testPassed = false;
    }

    if (test.getSize() != 7) {
      System.out.println("Size of Badger not constructed properly.");
      testPassed = false;
    }

    return testPassed;
  }

  /**
   * Tests badgerSetLeft() method in the Badger class
   * 
   * @return true when badgerSetLeft() set the right badger on the left
   */
  private static boolean testBadgerSetLeft() {
    boolean testPassed = true;
    Badger testTop = new Badger(10);
    Badger testLeft = new Badger(8);
    testTop.setLeftLowerNeighbor(testLeft);
    if (testTop.getLeftLowerNeighbor().getSize() != 8) {
      testPassed = false;
    }
    return testPassed;
  }



  /**
   * this test runs all the private tests for badger class
   * 
   * @return true if all tests past
   */
  public static boolean runAllBadgerTests() {
    boolean allTests = true;
    if (!testBadgerConstructor())
      allTests = false;
    if (!testBadgerSetLeft())
      allTests = false;
    // if allTest passes
    if (allTests) {
      System.out.println("All tests passed!");
    }

    return allTests;

  } // returns true when all Badger tests pass

  /**
   * Tests SettConstructor() method in the Sett class
   * 
   * @return true when constructor() set the root node to null
   */
  private static boolean testSettConstructor() {
    boolean testPassed = true;
    Sett test = new Sett();
    if (test.getTopBadger() != null) {
      testPassed = false;
      System.out.println("Sett Constructor failed.");
    }

    return testPassed;
  }

  /**
   * Tests countBadger() method in the Sett class
   * 
   * @return true when countBadger() returns the correct height
   */
  private static boolean testCountBadger() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    if (testSett2.countBadger() != 4) {
      runAll = false;
      System.out.println("Sett CountBadger failed.");
    }

    return runAll;
  }
  // private static boolean test


  /**
   * Tests getHeight() method in the Sett class
   * 
   * @return true when getHeight() returns the correct height
   */
  private static boolean testGetHeight() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    if (testSett2.getHeight() != 3) {
      runAll = false;
      System.out.println("Sett getHeight failed.");
    }

    return runAll;
  }

  /**
   * Tests getSettleBadger() method in the Sett class
   * 
   * @return true when getSettleBadger() Setts the badger correctly
   */
  private static boolean testSettleBadger() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    if (testSett2.getTopBadger().getSize() != 7) {
      runAll = false;
      System.out.println("Sett testSettleBadger failed.");
    }

    return runAll;
  }

  /**
   * Tests testFindBadger() method in the Sett class
   * 
   * @return true when findBadger() finds the badger correctly
   */
  private static boolean testFindBadger() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    if (testSett2.findBadger(testSett2.getTopBadger().getSize()).getSize() != 7) {
      runAll = false;
      System.out.println("Sett findBadger failed.");
    }

    return runAll;
  }

  /**
   * Tests getAllBadgers() method in the Sett class
   * 
   * @return true when getAllBadgers() returns the correct sequence
   */
  private static boolean testGetAllBadgers() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);


    if (testSett2.getAllBadgers().get(0).getSize() != 7
        || testSett2.getAllBadgers().get(3).getSize() != 11) {
      runAll = false;

      System.out.println("Sett getAllBadgers failed.");
    }

    return runAll;
  }

  /**
   * Tests getLargestBadgers() method in the Sett class
   * 
   * @return true when getLargestBadgers() returns the largest Badger in the Sett
   */
  private static boolean testGetLargestBadgers() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    if (testSett2.getLargestBadger().getSize() != 11) {
      runAll = false;
      System.out.println("Sett getLargestBadger failed.");
    }

    return runAll;
  }

  /**
   * Tests clear() method in the Sett class
   * 
   * @return true when clear() clears the sett and No Badger is in the sett
   */
  private static boolean testClear() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    testSett2.clear();
    if (testSett2.getHeight() != 0) {
      runAll = false;
      System.out.println("Sett clear() failed.");
    }

    return runAll;
  }

  /**
   * Tests isEmpty() method in the Sett class
   * 
   * @return true when isEmpty() returns true when the Sett is empty
   */
  private static boolean testIsEmpty() {
    boolean runAll = true;
    Sett testSett2 = new Sett();
    testSett2.settleBadger(7);
    testSett2.settleBadger(10);
    testSett2.settleBadger(11);
    testSett2.settleBadger(8);
    testSett2.clear();
    if (!testSett2.isEmpty()) {
      runAll = false;
      System.out.println("Sett isEmpty() failed.");
    }

    return runAll;
  }

  /**
   * Tests if tests for set classes
   * testSettConstructor(),testGetHeight(),testCountBadger(),testSettleBadger(),
   * testFindBadger(),testGetAllBadgers(),testClear(),testIsEmpty() returns true
   * 
   * @return true when all Sett tests pass
   */
  public static boolean runAllSettTests() {
    boolean allTests = true;

    if (!testSettConstructor())
      allTests = false;
    if (!testGetHeight())
      allTests = false;
    if (!testCountBadger())
      allTests = false;
    if (!testSettleBadger())
      allTests = false;
    if (!testFindBadger())
      allTests = false;
    if (!testGetAllBadgers())
      allTests = false;
    if (!testGetLargestBadgers())
      allTests = false;
    if (!testClear())
      allTests = false;
    if (!testIsEmpty())
      allTests = false;

    if (allTests) {
      System.out.println("All tests passed!");
    }

    return allTests;

  } // returns true when all Sett tests pass

  /**
   * runs runAllBadgerTests(), runAllSettTests()
   */
  public static void main(String[] args) {
    runAllBadgerTests();
    runAllSettTests();
  }
}
