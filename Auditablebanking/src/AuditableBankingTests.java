import java.util.Arrays;

public class AuditableBankingTests {
	public static void main(String[] args) {
		testProcessCommand();
		testCalculateCurrentBalance();
		testCalculateNumberOfOverdrafts();
	}

	public static boolean testProcessCommand() {
		int[][] allTransactions = {};
		int allTransactionsCount = 0;
		String command = "0 1 1 0";
		int calculation = AuditableBanking.processCommand(command, allTransactions, allTransactionsCount);
		if (calculation == 0) {
			System.out.println("Passed testProcessCommand");
			return true;
		} else {
			
			System.out.println("Failed testProcessCommand");
			return false;
		}
	}

	public static boolean testCalculateCurrentBalance() {
		boolean foundProblem = false;
		int[][]transactions = new int[][] {
			{1,10,-20},
			{0,1,1,0,0},
			{1,100},
			{2,3,1,0,1},
		};
		int transactionCount = 4;
		int currentBalance= AuditableBanking.calculateCurrentBalance(transactions, transactionCount);
		if (currentBalance != -110) {
			System.out.println("FAILURE: calcultureCurrentBalance did not return correctly, should return -110 instead of  " + currentBalance);
			foundProblem = true;
		}
		else {
			System.out.println("Test passed!");
		}
		return false;
	}

	public static boolean testCalculateNumberOfOverdrafts() {
		boolean foundProblem = false;
		int[][] transactions = new int[][] { { 1, 10, -20, +30, -20, -20 }, // +2 overdrafts (ending balance: -20)
				{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 1 }, // +2 overdrafts (ending balance: -15)
				{ 1, 115 }, // +0 overdrafts (ending balance: +100)
				{ 2, 3, 1, 0, 1 }, // +1 overdrafts (ending balance: -100)
		};

		// test with a single transaction of the Integer Amount encoding
		int transactionCount = 1;
		int overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
		if (overdrafts != 2) {
			System.out.println(
					"FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

		// test with four transactions: including one of each encoding
		transactionCount = 4;
		overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
		if (overdrafts != 5) {
			System.out.println(
					"FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

		return !foundProblem;
	}
}
