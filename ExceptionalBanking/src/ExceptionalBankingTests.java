//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ExceptionalBanking
// Files: TransactionGroup.java, Account.java, ExceptionalBankingTests.java
// Course: CS300
//
// Author: Yukun Li
// Email: yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: 
// Partner Lecturer's Name: 
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understand the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Online Sources:
// https://docs.oracle.com/javase/7/docs/api/java/io/FileNotFoundException.html
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;

public class ExceptionalBankingTests {
  /**
   * @param args
   * @throws DataFormatException tests would throw dataFormatException
   */
  public static void main(String[] args) throws DataFormatException {
    int testPassed = 0;

    if (!testAccountBalance()) {
      System.out.println("Account Balance not passed, suppose to return the value of -110.");
    } else {
      testPassed++;
    }

    if (!testOverdraftCount()) {
      System.out.println("OverDraft test not passed, suppose to return the value of 4.");
    } else {
      testPassed++;
    }

    if (!testTransactionGroupEmpty()) {
      System.out.println("TransactionGroupEmpty test not passed.");
    } else {
      testPassed++;
    }

    if (!testTransactionGroupInvalidEncoding()) {
      System.out.println("TransactionGroupInvalidEncoding test not passed.");
    } else {
      testPassed++;
    }

    if (!testAccountAddNegativeQuickWithdraw()) {
      System.out.println("AccountAddNegativeQuickWithdraw test not passed.");
    } else {
      testPassed++;
    }

    if (!testAccountIndexOutOfBounds()) {
      System.out.println("AccountIndexOutOfBounds test not passed.");
    } else {
      testPassed++;
    }

    if (!testAccountBadTransactionGroup()) {
      System.out.println("BadTransactionGroup test not passed.");
    } else {
      testPassed++;
    }
    if (!testAccountMissingFile()) {
      System.out.println("testAccountMissingFile test not passed.");
    } else {
      testPassed++;
    }

    System.out.println("Congratulations! test passed " + testPassed + " out of 8");
  }

  /**
   * @return if test passed
   * @throws DataFormatException use to handle addTransactionGroup
   */
  public static boolean testAccountBalance() throws DataFormatException {
    Account userAccount = new Account("userAccount");
    userAccount.addTransactionGroup("1 10 -20");
    userAccount.addTransactionGroup("0 1 1 0 0");
    userAccount.addTransactionGroup("1 100");
    userAccount.addTransactionGroup("2 3 1 0 1");
    int currentBalance = userAccount.getCurrentBalance();
    if (currentBalance == -110) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @return if test passed
   * @throws DataFormatException use to handle addTransactionGroup
   */
  public static boolean testOverdraftCount() throws DataFormatException {
    Account userAccount = new Account("userAccount");
    userAccount.addTransactionGroup("1 10 -20 +30 -20 -20");// 2 overdraft
    userAccount.addTransactionGroup("0 1 1 1 0 0 1 1 1 1");// 1 overdraft
    userAccount.addTransactionGroup("1 115"); // 0 overdraft
    userAccount.addTransactionGroup("2 3 1 0 1"); // 1 overdraft
    int currentOverdraft = userAccount.getNumberOfOverdrafts();
    if (currentOverdraft == 4) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with 
   * an appropriate message, when it is passed an empty int[].
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws DataFormatException use to handle problem creating a new transaction group
   */
  public static boolean testTransactionGroupEmpty() {
    int[] nullArray = null;
    try {
      TransactionGroup group1 = new TransactionGroup(nullArray);
    } catch (DataFormatException e) {
      System.out.println("transaction group encoding cannot be null or empty");
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when then first int in the provided array is not 0, 1, or 2.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws DataFormatException use to handle problem creating a new TransactionGroup
   */
  public static boolean testTransactionGroupInvalidEncoding() {
    int[] array1 = {8, 8, 8, 8};
    try {
      TransactionGroup group2 = new TransactionGroup(array1);
    } catch (DataFormatException e) {
      System.out.println("the first element within a transaction group must be 0, 1, or 2");
      return true;
    }
    return false;
  }



  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a quick withdraw encoded group that contains negative
   * numbers of withdraws.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   *  @throws DataFormatException use to handle problem creating a new TransactionGroup
   */
  public static boolean testAccountAddNegativeQuickWithdraw() {
    int[] array2 = {2, -1, -1};
    try {
      TransactionGroup group3 = new TransactionGroup(array2);
    } catch (DataFormatException e) {
      System.out.println("quick withdraw transaction groups may not contain negative numbers");
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a string with space separated English words (non-int).
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   *  @throws DataFormatException use to handle problem creating a new TransactionGroup
   */

  public static boolean testAccountBadTransactionGroup() {

    Account userAccount = new Account("userAccount");

    try {
      userAccount.addTransactionGroup("1 zwei deux tres");
    } catch (DataFormatException e) {
      System.out.println(
          "addTransactionGroup requires string commands that contain only space separated integer values");
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.getTransactionAmount method throws an exception with an
   * appropriate message, when it is passed an index that is out of bounds.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws DataFormatException use to handle problem creating a new TransactionGroup
   * @throws IndexOutOfBoundsException use to handle given index that's not in array 
   */

  public static boolean testAccountIndexOutOfBounds() throws DataFormatException {
    int[] array3 = {0, 1, 1, 0};
    TransactionGroup group1 = new TransactionGroup(array3);
    try {
      group1.getTransactionAmount(5);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("5 is being accessed while maximum storage is only 3");
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account constructor that takes a File parameter throws an
   * exception with an appropriate message, when it is passed a File object that does not correspond
   * to an actual file within the file system.
   *
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws FileNotFoundException use to handle if file does not exist
   */
  public static boolean testAccountMissingFile()  {
    File file1 = null;
    try {
      Account userAccount = new Account(file1);
    } catch (FileNotFoundException e) {
      System.out.println(" file is not found!");
      return true;
    }
    return false;
  }
}
