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
// Partner Name:NONE
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
import java.util.Scanner;
import java.util.zip.DataFormatException;
import java.io.FileNotFoundException;



public class Account {

  private static final int MAX_GROUPS = 10000;
  private static int nextUniqueId = 1000;

  private String name;
  private final int UNIQUE_ID;
  private TransactionGroup[] transactionGroups;
  private int transactionGroupsCount;


  // constructor, the default name, account id
  // created an oversize array to store transaction groups
  public Account(String name) {
    this.name = name;
    this.UNIQUE_ID = Account.nextUniqueId;
    Account.nextUniqueId++;
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    this.transactionGroupsCount = 0;
  }

  
  /**
   * @param file 
   * @throws FileNotFoundException file may not exist
   * @throws DataFormatException formating problem when calling addtransaction
   *         want to handle this within the method
   */
  public Account(File file) throws FileNotFoundException {
    // NOTE: THIS METHOD SHOULD NOT BE CALLED MORE THAN ONCE, BECAUSE THE
    // RESULTING BEHAVIOR IS NOT DEFINED WITHIN THE JAVA SPECIFICATION ...
    // try {
    if (file == null) {
      throw new FileNotFoundException("File not found ! ");
    }
    Scanner in = new Scanner(file);
    // } catch (FileNotFoundException e) {
    // throw new FileNotFoundException(file.getName() + "does not exist");
    // }

    // ... THIS WILL BE UPDATED TO READ FROM A FILE INSTEAD OF SYSTEM.IN.

    this.name = in.nextLine();
    this.UNIQUE_ID = Integer.parseInt(in.nextLine());
    Account.nextUniqueId = this.UNIQUE_ID + 1;
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    this.transactionGroupsCount = 0;
    String nextLine = "";
    while (in.hasNextLine())
      try {
        this.addTransactionGroup(in.nextLine());

      } catch (DataFormatException e) {
        System.out.println("DataFormatException");
      }
    in.close();
  }

  // get id as title
  public int getId() {
    return this.UNIQUE_ID;
  }

  // add command into a new array
  /**
   * @param command
   * @throws DataFormatException user might not put integer value
   * @throws NumberFormatException user might not separated by space
   */
  public void addTransactionGroup(String command) throws DataFormatException {
     if (!command.contains(" ")) {
     throw new DataFormatException("Please enter spaces between each command");
     }
    String[] parts = command.split(" ");
    int[] newTransactions = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {

      try {
        newTransactions[i] = Integer.parseInt(parts[i]);
      } catch (NumberFormatException e) {
        throw new DataFormatException("addTransactionGroup requires"
            + " string commands that contain " 
            + "only space separated integer values");
      }
    }
    TransactionGroup t = new TransactionGroup(newTransactions);
    this.transactionGroups[this.transactionGroupsCount] = t;
    this.transactionGroupsCount++;
  }

  //
  public int getTransactionCount() {
    int transactionCount = 0;
    for (int i = 0; i < this.transactionGroupsCount; i++)
      transactionCount += this.transactionGroups[i].getTransactionCount();
    return transactionCount;
  }

  public int getTransactionAmount(int index) {
    int transactionCount = 0;
    for (int i = 0; i < this.transactionGroupsCount; i++) {
      int prevTransactionCount = transactionCount;
      transactionCount += this.transactionGroups[i].getTransactionCount();
      if (transactionCount > index) {
        index -= prevTransactionCount;
        return this.transactionGroups[i].getTransactionAmount(index);
      }
    }
    return -1;
  }

  public int getCurrentBalance() {
    int balance = 0;
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++)
      balance += this.getTransactionAmount(i);
    return balance;
  }

  public int getNumberOfOverdrafts() {
    int balance = 0;
    int overdraftCount = 0;
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++) {
      int amount = this.getTransactionAmount(i);
      balance += amount;
      if (balance < 0 && amount < 0)
        overdraftCount++;
    }
    return overdraftCount;
  }

}
