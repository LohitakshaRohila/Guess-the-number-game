import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        // Declaring scanner object

        String playAgain = "";                      // Declaring variables
        int won = 0;
        int lost = 0;
        do {
            int number = (int) (Math.random() * 10);                // Selecting random number for game

            System.out.println("Enter the number of chances you want.");
            int chance = sc.nextInt();
            // To do in case of high number of "chance"
           do {
               if (chance > 4){
                   System.out.println("Please enter chances between 1-4");
                   chance = sc.nextInt();;
               }
           }while(chance > 4);

            int num;            // Declaring int num. num to be used to take input

            do {
                System.out.println("Guess the number. The number is between 0-10. You have " + chance + " chances");
                num = sc.nextInt(); //Taking value of "num" from user
                sc.nextLine(); // Consume the newline character
                chance--;
                // To do in case "num" does not equal "number"
                if (num != number) {
                    if (num > number) {
                        System.out.println("Your input is greater");
                    } else {
                        System.out.println("Your input is smaller");
                    }
                    System.out.println("You have " + chance + " chances left");
                }
                // Game end with lose
                if (chance == 0 && num != number) {
                    System.out.println("You lost the game. Correct answer is " + number);
                    lost++;
                    System.out.println("To play again type yes");
                    System.out.println("To see your result and quit type result");
                    playAgain = sc.nextLine(); // Use the play_ag scanner
                }
            } while (num != number && chance <= 4);

            // Game end with win
            if (num == number) {
                System.out.println("You won the game with " + chance + " chances left");
                System.out.println("To play again type yes.");
                System.out.println("To see your result and quit type result");
                playAgain = sc.nextLine(); // Use the play_ag scanner
                won++;
            }

            // See the result
            if (playAgain.equalsIgnoreCase("Result")){
                System.out.println("You won "+won+" times and lost "+lost+" times");
                System.out.println("To play again type yes");
                playAgain = sc.nextLine();          // To play again
            }
        } while (playAgain.equalsIgnoreCase("Yes"));

        // Exit
        if (playAgain.equalsIgnoreCase("No")) {
            System.out.println("Thanks for playing");
        }

        sc.close(); // Close the main Scanner object
    }
}
