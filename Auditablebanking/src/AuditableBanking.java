
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Auditable Banking
// Files:           AuditableBanking.java, AuditableBankingTests
// Course:          CS300, FALL, 2018
//
// Author:          Yukun Li
// Email:           yli757@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class AuditableBanking {

	/**
	 * Adds a transaction group to an array of transaction groups. If the
	 * allTransactions array is already full then this method will do nothing other
	 * than return allTransactionCount.
	 * 
	 * @param newTransactions
	 *            is the new transaction group being added (perfect size).
	 * @param allTransactions
	 *            is the collection that newTransactions is being added to
	 *            (oversize).
	 * @param allTransactionsCount
	 *            is the number of transaction groups within allTransactions (before
	 *            newTransactions is added.
	 * @return the number of transaction groups within allTransactions after
	 *         newTransactions is added.
	 */
	public static int submitTransactions(int[] newTransactions, int[][] allTransactions, int allTransactionsCount) {
		// the current number of all transactionsCount is equal to the y of the current
		// newTransaction
		if (allTransactions.length == allTransactionsCount) {
			return allTransactionsCount;
		}
		allTransactions[allTransactionsCount] = newTransactions;
		allTransactionsCount++;
		return allTransactionsCount;
	}

	public static int processCommand(String command, int[][] allTransactions, int allTransactionsCount) {
		// System.out.println(command);
		String[] stringCommand = command.split(" ");
		// System.out.println(stringCommand[0]);
		int[] intCommand = new int[stringCommand.length];
		for (int i = 0; i < stringCommand.length; i++) {
			intCommand[i] = Integer.parseInt(stringCommand[i]);
			// System.out.println(intCommand[i]);
		}
		allTransactionsCount = submitTransactions(intCommand, allTransactions, allTransactionsCount);
		return allTransactionsCount;
	}

	// method 3 Calculate current balance
	public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
		// System.out.println("we entered here 1 !");
		int currentBalance = 0;
		for (int i = 0; i < allTransactionsCount; i++) {
			// System.out.println("the value of i " + i);
			// if the user use BINARY AMOUNT TRANSACTION
			if (allTransactions[i][0] == 0) {
				for (int j = 1; j < allTransactions[i].length; j++) {
					// System.out.println("index j = "+j);
					if (allTransactions[i][j] == 0) {
						// if 0, withdraw 1 dollar
						currentBalance--;
					}
					if (allTransactions[i][j] == 1) {
						// if 1, deposit 1 dollar
						currentBalance++;
					}
				}
			}

			// if the user use INTEGER AMOUNT TRANSACTIONs
			if (allTransactions[i][0] == 1) {
				for (int j = 1; j < allTransactions[i].length; j++) {
					// positive deposit of specific amount
					if (allTransactions[i][j] > 0) {
						// System.out.println("Here is [" + i + "][" + j + "]");
						currentBalance += allTransactions[i][j];
					}
					// negative withdraw of specific amount}
					else if (allTransactions[i][j] <= 0) {
						currentBalance += allTransactions[i][j];
					}
				}
			}
			// if we use QUICK WITHDRAW TRANSACTIONS
			if (allTransactions[i][0] == 2) {
				// make a new array to store the values of quick withdraw transactions in order
				int[] button = new int[4];
				button[0] = 20;
				button[1] = 40;
				button[2] = 80;
				button[3] = 100;
				for (int j = 1; j < allTransactions[i].length; j++) {
					currentBalance -= allTransactions[i][j] * button[j - 1];
				}
			}
		}
		return currentBalance;
	}

	// idea of overdraft is similar to currentBalance
	public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
		int numberofOverdraft = 0;
		int currentBalance = 0;
		for (int i = 0; i < allTransactionsCount; i++) {
			// if the user use binary
			if (allTransactions[i][0] == 0) {
				for (int j = 1; j < allTransactions[i].length; j++) {
					if (allTransactions[i][j] == 1) {
						// if 1, deposit 1 dollar
						currentBalance++;
					}
					if (allTransactions[i][j] == 0) {
						currentBalance--;
						// if currentBalance is negative, increment numberofOverdraft
						if (currentBalance < 0) {
							numberofOverdraft++;
						}
					}
				}
			}

			// if the user use integer amount transaction
			if (allTransactions[i][0] == 1) {
				for (int j = 1; j < allTransactions[i].length; j++) {
					if (allTransactions[i][j] > 0) {
						currentBalance += allTransactions[i][j];
						// System.out.println("This is current balance " + currentBalance);
					}
					// negative withdraw of specific amount
					if (allTransactions[i][j] < 0) {
						// System.out.println("check point 1");
						currentBalance += allTransactions[i][j];
						if (currentBalance < 0) {
							// System.out.println("This is current balance " + currentBalance);
							numberofOverdraft++;
						}
					}
				}
			}
			// quick withdraw
			if (allTransactions[i][0] == 2) {
				int[] button = new int[4];
				button[0] = 20;
				button[1] = 40;
				button[2] = 80;
				button[3] = 100;
				for (int j = 1; j < allTransactions[i].length; j++) {
					currentBalance -= allTransactions[i][j] * button[j - 1];
					// if current balance smaller than 0 , increment overdraft
					if (currentBalance < 0) {
						numberofOverdraft++;
					}
				}
			}
		}
		return numberofOverdraft;
	}

	// main method
	public static void main(String[] args) {
		// initialize and declaration
		int[][] allTransactions = new int[999][];
		int allTransactionsCount = 0;

		// program header
		System.out.println("========== Welcome to the Auditable Banking App==========");
		Boolean programOver = false;
		// Scanner
		Scanner scanner = new Scanner(System.in);
		while (!programOver) {

			// program instructions
			System.out.println("COMMAND MENU:");
			System.out.println("  Submit a Transaction (enter sequence of integers separated by spaces)");
			System.out.println("  Show Current [B]alance");
			System.out.println("  Show Number of [O]verdrafts");
			System.out.println("  [Q]uit Program");
			System.out.print("ENTER COMMAND: ");
			// scan in response
			String command = scanner.nextLine().trim();
			System.out.println("");
			// System.out.println("C1");
			// if the command is a transaction
			char firstDigit = command.charAt(0);
			// if the first command is a digit
			if (Character.isDigit(firstDigit) == true) {
				allTransactionsCount = processCommand(command, allTransactions, allTransactionsCount);
			}
			// if the command is to retrieve information
			else {
				// if the command is B, program show current Balance
				command = command.toUpperCase();
				if (command.equals("B")) {
					// System.out.println("we entered here!");
					System.out.println(calculateCurrentBalance(allTransactions, allTransactionsCount));
				}
				// if the command is O
				else if (command.equals("O")) {
					System.out.println(calculateNumberOfOverdrafts(allTransactions, allTransactionsCount));
				}
				// if the command is Q, program over is true, quit program
				else if (command.equals("Q")) {
					programOver = true;
					System.out.print("============ Thank you for using this App!!!! ============");
				}

			}

		}
		scanner.close();

	}
}
