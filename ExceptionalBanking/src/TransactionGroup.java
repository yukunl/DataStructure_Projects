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
import java.util.zip.DataFormatException;

public class TransactionGroup {

  private enum EncodingType {
    BINARY_AMOUNT, INTEGER_AMOUNT, QUICK_WITHDRAW
  };

  private EncodingType type;
  private int[] values;


  // take in an array of group codes,
  // take out the first integer for type, and store the other
  // integers for value array

  /**
   * @param groupEncoding
   * @throws DataFormatException specific data format requirements to check
   */
  public TransactionGroup(int[] groupEncoding) throws DataFormatException {
    // if there is a transaction group that is null
    if (groupEncoding == null) {
      throw new DataFormatException("transaction group encoding cannot be null or empty");
    }
    // type is not valid if the first element is not 0,1 or 2
    if (groupEncoding[0] != 0 && groupEncoding[0] != 1 && groupEncoding[0] != 2) {
      throw new DataFormatException(
          "the first element within a transaction group must be 0, 1, or 2");
    }
    this.type = EncodingType.values()[groupEncoding[0]];
    this.values = new int[groupEncoding.length - 1];
    for (int i = 0; i < values.length; i++) {
      this.values[i] = groupEncoding[i + 1];
      // when transaction is binary
      if (groupEncoding[0] == 0) {
        if (this.values[i] != 0 && this.values[i] != 1) {
          throw new DataFormatException(
              "binary amount transaction groups may only contain 0s and 1s");
        }
      } // when integer amount
      else if (groupEncoding[0] == 1) {
        if (this.values[i] == 0) {
          throw new DataFormatException("integer amount transaction groups may not contain 0s");
        }
      } // when quick withdraw
      else if (groupEncoding[0] == 2) {
        if (groupEncoding.length != 5) {
          throw new DataFormatException(
              "quick withdraw transaction groups must contain 5 elements");
        }
        if (this.values[i] < 0) {
          throw new DataFormatException(
              "quick withdraw transaction groups may not contain negative numbers");
        }
      }
    }


  }



  // count how many transactions are conducted, serves as a modification method
  // for binary, if the previous value doesnt equal to the current value
  // for integer amount, just how many members in the value array
  // for quick withdraw, the amount of money taken out
 
  public int getTransactionCount() {
    int transactionCount = 0;
    switch (this.type) {
      case BINARY_AMOUNT:
        int lastAmount = -1;
        for (int i = 0; i < this.values.length; i++) {
          if (this.values[i] != lastAmount) {
            transactionCount++;
            lastAmount = this.values[i];
          }
        }
        break;
      case INTEGER_AMOUNT:
        transactionCount = values.length;
        break;
      case QUICK_WITHDRAW:
        for (int i = 0; i < this.values.length; i++)
          transactionCount += this.values[i];
    }
    return transactionCount;
  }

  /**
   * @param transactionIndex
   * @throws IndexOutOfBoundsException user might try to get access to an index outside of
   *         transaction amount
   */
  public int getTransactionAmount(int transactionIndex) throws IndexOutOfBoundsException {
    if (transactionIndex > values.length) {
      // System.out.println("Check point of index out of bound enter.");
      throw new IndexOutOfBoundsException(
          transactionIndex + "is being accessed while maximum storage is only " + values.length);
    }
    int transactionCount = 0;
    switch (this.type) {
      case BINARY_AMOUNT:
        int lastAmount = -1;
        int amountCount = 0;
        for (int i = 0; i <= this.values.length; i++) {
          if (i == this.values.length || this.values[i] != lastAmount) {
            if (transactionCount - 1 == transactionIndex) {
              if (lastAmount == 0)
                return -1 * amountCount;
              else
                return +1 * amountCount;
            }
            transactionCount++;
            lastAmount = this.values[i];
            amountCount = 1;
          } else
            amountCount++;
          lastAmount = this.values[i];
        }
        break;
      case INTEGER_AMOUNT:
        return this.values[transactionIndex];
      case QUICK_WITHDRAW:
        final int[] QW_AMOUNTS = new int[] {-20, -40, -80, -100};
        for (int i = 0; i < this.values.length; i++)
          for (int j = 0; j < this.values[i]; j++)
            if (transactionCount == transactionIndex)
              return QW_AMOUNTS[i];
            else
              transactionCount++;
    }
    return -1;
  }
}
