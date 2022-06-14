package millionaire;

public class Database {
    // Initialize the money prize integers (Source: https://en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F_(Philippine_game_show)#Game_rules)
    public int moneyTree[] = {1000, 2000, 3000, 5000, 10000, 20000, 30000, 40000, 50000, 100000, 200000, 300000, 400000, 500000, 1000000 };

    public Database () { // Declares a blank constructor
    }

    // Displays the money tree of the game
    public void displayTree() {
        System.out.println("The Money Tree:");
        for (int i = 0; i < moneyTree.length; i++) {
            int num = Math.abs(i - 14); // This makes it to start from the last index

            // Calls the last index first, descending to the first index
            if (moneyTree[num] == 1000000) { // 3rd safe haven
                System.out.print("₱");
                System.out.printf("%,d", moneyTree[num]);
                System.out.print(" \t3RD SAFE HAVEN + GRAND PRIZE\n");
            } else if (moneyTree[num] == 100000) { // 2nd safe haven
                System.out.print("₱");
                System.out.printf("%,d", moneyTree[num]);
                System.out.print(" \t2ND SAFE HAVEN\n");
            } else if (moneyTree[num] == 10000) { // 1st safe haven
                System.out.print("₱");
                System.out.printf("%,d", moneyTree[num]);
                System.out.print(" \t1ST SAFE HAVEN\n");
            } else {
                System.out.print("₱");
                System.out.printf("%,d%n", moneyTree[num]);
            }
        }
    }

    public void finalCount(int score) { // Gets the score from Question.java and check how much the contestant will earn based on the safe haven
        if (score < 5) {
            System.out.println("Winnings: ₱0");
        } else if (score < 10) {
            System.out.println("Winnings: ₱10,000");
        } else if (score < 15) {
            System.out.println("Winnings: ₱100,000");
        } else {
            System.out.println("Winnings: ₱1,000,000");
        }
    }
}