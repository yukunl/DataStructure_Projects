//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park
// Files: Seuqencek.java, FibonacciSequence.java, DigitProductSequence.java,
// SeuqenceGenerateTests.java, ArithmeticSequenceGenerator.java,
// GeometricSequenceGenerator.java
//
// Course: CS300, Fall, 2018
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: https://stackoverflow.com/questions
/// 14743165/simple-number-to-array-with-individual-digits
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


public class SequenceGeneratorTests {
  /**
   * This class tests geomtricSequenceGenerator, FibonacciSequenceGenerator,
   * ArithmeticSequenceGenerator and digitProductSequenceGenerator
   * 
   * prints out "Sorry" if not all tests are passed
   * 
   * @author Yukun
   *
   */

  public static void main(String[] args) {
    int testPassed = 0; // variable to keep track of total testpassed numbers
    if (geometricSequenceGeneratorTest()) {
      System.out.println("geometricSequenceGeneratorTest(): " + geometricSequenceGeneratorTest());
      testPassed++;
    }
    if (FibonacciSequenceGeneratorTest()) {
      System.out.println("FibonacciSequenceGenerator(): " + FibonacciSequenceGeneratorTest());
      testPassed++;
    }
    if (ArithmeticSequenceGeneratorTest()) {
      System.out.println("ArithmeticSequenceGeneratorTest(): " + ArithmeticSequenceGeneratorTest());
      testPassed++;
    }
    if (DigitProductSequenceGeneratorTest()) {
      System.out
          .println("DigitProductSequenceGeneratorTest(): " + DigitProductSequenceGeneratorTest());
      testPassed++;
    }
    if (testPassed != 4) { // if not all tests are passed
      int testnotPassed = 4 - testPassed;
      System.out.println("Sorry! please try again!" + testnotPassed + "to go");
    }

  }

  /**
   * @return true if the method geometricSequenceGenerator returns the correct sequence
   */
  public static boolean geometricSequenceGeneratorTest() {
    boolean returnCorrect = false;
    int[] test1 = new int[] {1, 5, 2, 6}; // test values
    Sequence geoSeq = new Sequence(test1);
    if ("GEOMETRIC sequence: 5 10 20 40 80 160 ".equals(geoSeq.toString())) { 
      returnCorrect = true;
    }
    return returnCorrect;
  }

  /**
   * @return true if the method fibonacciSequenceGenerator returns the correct sequence
   */
  public static boolean FibonacciSequenceGeneratorTest() {
    boolean returnCorrect = false;
    int[] test2 = new int[] {2, 10};// test values
    Sequence fibSeq = new Sequence(test2);
    if ("FIBONACCI sequence: 0 1 1 2 3 5 8 13 21 34 ".equals(fibSeq.toString())) {
      returnCorrect = true;
    }
    return returnCorrect;
  }

  /**
   * @return true if the method arithmeticSequenceGenerator returns the correct sequence
   */
  public static boolean ArithmeticSequenceGeneratorTest() {
    boolean returnCorrect = false;
    int[] test3 = new int[] {0, 2, 3, 5};// test values
    Sequence arthSeq = new Sequence(test3);
    if ("ARITHMETIC sequence: 2 5 8 11 14 ".equals(arthSeq.toString())) {
      returnCorrect = true;
    }
    return returnCorrect;
  }

  /**
   * @return true if the method digitProductSequenceGenerator returns the correct sequence
   */
  public static boolean DigitProductSequenceGeneratorTest() {
    boolean returnCorrect = false;
    int[] test4 = new int[] {3, 13, 5};// test values
    Sequence digSeq = new Sequence(test4);
    if ("DIGIT_PRODUCT sequence: 13 16 22 26 38 ".equals(digSeq.toString())) {
      returnCorrect = true;
    }
    return returnCorrect;
  }
}
