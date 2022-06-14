package millionaire;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        char again;
        boolean loop;

        System.out.println("------------------------------------------");
        System.out.println("Welcome to Who Wants to be a Millionaire!");
        System.out.println("\t\t\t1. Start game\n\t\t\t2. Exit");
        System.out.print("Enter option: ");
        choice = input.nextInt();

        if (choice == 1) {
            do {
                Introduction player = new Introduction("");
                player.introFlow();

                Questions game = new Questions();
                game.gameStart();

                System.out.print("Do you want to play again? (y/n): "); // Asks the user to play again or not
                again = input.next().charAt(0);

                loop = again == 'y'; // Loop returns true if user enters 'y'
            } while (loop);
            System.out.println("Thank you for playing!");
        } else {
            System.out.println("You have exited the program.");
        }
    }
}