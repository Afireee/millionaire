package millionaire;
import java.util.Scanner;

public class Questions {

    // Creates a public constructor
    public Questions () {
    }

    public void gameStart() {
        String q1 = "What is the capital of Spain?\n" +
                "[a] Paris\t\t[c] Barcelona\n" +
                "[b] Madrid\t\t[d] Buenos Aires";
        String q2 = "Which of the follow ingredients is not normally used to brew beer?\n" +
                "[a] Hops\t\t[c] Malt\n" +
                "[b] Yeast\t\t[d] Vinegar";
        String q3 = "Which one of the following words does not belong to the group?\n" +
                "[a] For\t\t[c] By\n" +
                "[b] Yet\t\t[d] Near";
        String q4 = "Who directed the film Titanic?\n" +
                "[a] James Cameron   \t\t[c] Oliver Stone\n" +
                "[b] Steven Spielberg\t\t[d] John Woo";
        String q5 = "Which is the biggest island in the world?\n" +
                "[a] New Guinea\t\t[c] New Zealand\n" +
                "[b] Madagascar\t\t[d] Greenland";
        String q6 = "What is the coordinated set of colors, fonts, and other design components of a presentation called?\n" +
                "[a] Background\t\t[c] Transition\n" +
                "[b] Theme     \t\t[d] Animation";
        String q7 = "What is the smallest country in the world?\n" +
                "[a] Vatican City\t\t[c] Iceland\n" +
                "[b] Seychelles  \t\t[d] Spain";
        String q8 = "In what year was the first iPhone released?\n" +
                "[a] 2004\t\t[c] 2007\n" +
                "[b] 2008\t\t[d] 2006";
        String q9 = "How many million miles away is the sun from the Earth?\n" +
                "[a] 136 million\t\t[c] 200 million\n" +
                "[b] 93 million\t\t[d] 72 million";
        String q10 = "Who won the 2000 Formula 1 World Championship?\n" +
                "[a] Mika Hakkinen     \t\t[c] Eddie Irvine\n" +
                "[b] Jacques Villenueve\t\t[d] Michael Schumacher";
        String q11 = "How many meters is Mt. Kilimanjaro?\n" +
                "[a] 5,895 meters\t\t[c] 8,848 meters\n" +
                "[b] 4,897 meters\t\t[d] 6,696 meters";
        String q12 = "What colour were the Pyramid of Giza originally?\n" +
                "[a] Orange\t\t[c] Yellow\n" +
                "[b] Red   \t\t[d] White";
        String q13 = "Which month of the year was named after Julius Caesar?\n" +
                "[a] July\t\t[c] June\n" +
                "[b] January\t\t[d] October";
        String q14 = "Which of these famous landmarks was completed first?\n" +
                "[a] Empire State Building\t\t[c] Big Ben\n" +
                "[b] Royal Albert Hall    \t\t[d] Eiffel Tower";
        String q15 = "What scientist first determined that human sight results from images projected into the retina?\n" +
                "[a] Galileo        \t\t[c] Copernicus\n" +
                "[b] Johannes Kepler\t\t[d] Isaac Newton";

        // Creating 15 objects in an array with the question and its answers
        Sheet[] questions = {
                new Sheet(q1, "b"),
                new Sheet(q2, "d"),
                new Sheet(q3, "b"),
                new Sheet(q4, "a"),
                new Sheet(q5, "d"),
                new Sheet(q6, "b"),
                new Sheet(q7, "a"),
                new Sheet(q8, "c"),
                new Sheet(q9, "b"),
                new Sheet(q10, "d"),
                new Sheet(q11, "a"),
                new Sheet(q12, "d"),
                new Sheet(q13, "a"),
                new Sheet(q14, "c"),
                new Sheet(q15, "b")};

        int score = 0, count = 0;
        String answer;
        char confirm;
        boolean loop;
        Scanner input = new Scanner(System.in);
        Database num = new Database();

        for (int i = 0; i < questions.length; i++) {
            System.out.println("------------------------------------------");
                if (score == 4) { // Reminds the contestant if he/she answer this right, will reach a specific haven
                    System.out.println("Answer this next question correctly will secure your first safe haven!");
                } else if (score == 9) {
                    System.out.println("Answer this next question correctly will secure your second safe haven!");
                } else if (score == 14) {
                    System.out.println("Answer this final question and you will win 1 Million pesos!");
                }
            System.out.print("This question is worth: ₱");
            System.out.printf("%,d%n", num.moneyTree[i]); // Displays the integer as radix character
            System.out.println(questions[i].prompt); // Displays the question from the first index

            if (count < 3) { // Tells the contestant if the 50/50 lifeline is available or not
                System.out.println("You have " + Math.abs(count - 3) + " 50/50's left (Type \"50\" to use)");
            } else {
                System.out.println("(50/50 is no longer available)");
            }

            do {
                System.out.print("Answer: ");
                answer = input.nextLine();

                if (answer.equals("50")) { // If the contestant uses a 50/50
                    if (count > 2) {
                        System.out.println("You cannot use this lifeline anymore.");
                    } else {
                        count++;
                        questions[i].fiftyFifty(i); // Displays the 50/50 output from the specific question
                    }
                    System.out.print("Answer: ");
                    answer = input.nextLine();
                }

                System.out.print("Is that your final answer? (y/n): "); // Asks the user if that is his/her final answer
                confirm = input.next().charAt(0);

                if (confirm == 'n') {
                    loop = true;
                    answer = ""; // Sets the answer to blank so the contestant can re-answer
                } else {
                    loop = false;
                }
                input.nextLine();
            } while (loop);
            if (answer.equals(questions[i].answer)) { // Checks if the answer is correct
                System.out.println(answer + " is correct!");
                score++;
                    if (score == 5) {
                        System.out.println("You have reached your first safe haven!"); // Displays when Q5 is answered correctly
                        num.finalCount(score);
                    } else if (score == 10) {
                        System.out.println("You have reached your second safe haven!"); // Displays when Q10 is answered correctly
                        num.finalCount(score);
                    }
            } else { // If it's incorrect, the game ends
                System.out.println(answer + " is wrong! Game Over!");
                break; // Stops the for-loop statement
            }
        }
        if (score == 15) { // Displays when Q15 is answered correctly
            System.out.println("------------------------------------------");
            System.out.println("YOU WON WHO WANTS TO BE A MILLIONAIRE! CONGRATULATIONS!");
            System.out.println("------------------------------------------");
        }
        num.finalCount(score); // Display the final earnings that the contestant won
    }
}