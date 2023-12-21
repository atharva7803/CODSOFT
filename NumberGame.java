import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        Random rd = new Random();

        System.out.println("Welcome to the Guessig number game!");

        while (true) {
            int guessNumber = rd.nextInt(100) + 1;

            int noOfAttempts = 7;
            int attemptTaken = 0;

            while (true) {
                System.out.println("Enter your guess number between 1 to 100: ");
                int userGuessNo = sc.nextInt();

                attemptTaken++;
                if(userGuessNo == guessNumber){
                    System.out.println("Congratulations you guessed the number " + guessNumber + " in " + attemptTaken +" attempts!");
                    break;
                }
                else if(userGuessNo < guessNumber){
                    System.err.println("Guessed number is too Low! Try again");
                }
                else{
                    System.out.println("Guessed number is too High! Try again");
                }

                if(noOfAttempts == attemptTaken){
                    System.out.println("Sorry you have reached the Limit! The correct number is: "+ guessNumber);
                    break;
                }
            }

            System.out.println("Do you want to play again? (y/n): ");
            String playAgain = sc.next();
            if(!playAgain.equalsIgnoreCase("y")){
                break;
            }
             
        }
    }
}