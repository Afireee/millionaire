package millionaire;
import java.util.Scanner;

public class Introduction {
    private String name;

    public Introduction (String name) {
        this.name = name;
    }

    // Gets the name of the contestant
    private void getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.print("May I know your name?: ");
        name = input.nextLine();
        input.reset();
        System.out.println("Hello " + name + " and welcome to the show!");
        System.out.println("------------------------------------------");
    }

    // Asks the user to press 'Enter' to proceed to the next section of every introduction (gameMechanics(), lifelineGuide())
    private void promptEnterKey() {
        Scanner input = new Scanner(System.in);
        System.out.print("(Press \"Enter\" to continue)");
        input.nextLine();
    }

    // Displays the mechanics of the game. (Source: https://wwbm.com/rules)
    private void gameMechanics() {
        System.out.println("Here are the mechanics of this game:");
        System.out.println("* There are 15 multiple-choice questions increasing in difficulty, and you must answer them correctly in a row to get a grand prize of 1M Pesos!\n" +
                "* There are three \"safe havens\" in the question structure which are questions five, ten and fifteen." +
                "\nYou accumulate money with each correct answer, but if you answer incorrectly before reaching the specific safe haven, \nyou will lose a large amount of winnings.\n");
        promptEnterKey();
        System.out.println("------------------------------------------");
    }

    // Displays the lifeline rules of the game. (Source: https://en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F_(Philippine_game_show))
    public void lifelineGuide() {
        System.out.println("* There is only 1 lifeline but it can be used up to 3 times:");
        System.out.println("50:50: The computer removes two random incorrect answers, leaving the correct answer and one incorrect answer.\n");
        promptEnterKey();
        System.out.println("------------------------------------------");
    }

    // Asks the contestant if he/she is ready to play
    public void gameConfirm() {
        boolean confirm;
        char response;
        Scanner input = new Scanner(System.in);

        do {
                System.out.print("Are you ready to play who wants to be a millionaire? (y/n): ");
            response = input.next().charAt(0);

            if (response == 'n') {
                System.out.println("It seems to be that you are not ready yet.");
                confirm = true;
            } else {
                confirm = false;
            }
        } while (confirm);
            System.out.println("Once again " + name + ", welcome to Who wants to be a Millionaire.");
    }

    // The method that is going to be called from the main class which calls every method from this class
    public void introFlow() {
        Database info = new Database();
        getName();
        gameMechanics();
        lifelineGuide();
        info.displayTree();
        gameConfirm();
    }
}