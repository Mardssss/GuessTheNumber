package org.example;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {
            int maxTries = 0;
            String difficulty;

            System.out.println("Choose the difficulty level: (easy, hard, pro)");
            difficulty = sc.nextLine();

            switch (difficulty) {
                case "easy":
                    maxTries = 25;
                    break;
                case "hard":
                    maxTries = 15;
                    break;
                case "pro":
                    maxTries = 5;
                    break;
                default:
                    System.out.println("\u001B[31mOops! That's not a valid difficulty level. Let's make it easy and have some fun!\u001B[0m");
                    maxTries = 25;
                    break;
            }

            int number = random.nextInt(100) + 1;
            int i, guess;
            System.out.println("Alright, let's have some fun! I've chosen a number between 1 and 100. You have " + maxTries + " attempts to guess it.");

            for (i = 0; i < maxTries; i++) {
                System.out.print("Take a guess: ");
                guess = sc.nextInt();

                if (number == guess) {
                    System.out.println("\u001B[32mCongratulations! You nailed it! You have a true talent for guessing!\u001B[0m");
                    break;
                } else if (number > guess && i != maxTries - 1) {
                    System.out.println("\u001B[33mOh, so close! But the number I chose is bigger than " + guess + ". Keep trying!\u001B[0m");
                } else if (number < guess && i != maxTries - 1) {
                    System.out.println("\u001B[33mNot quite there yet! The number I chose is less than " + guess + ". You can do it!\u001B[0m");
                }
            }

            if (i == maxTries) {
                System.out.println("\u001B[31mGame Over! Better luck next time. The number I chose was: " + number + "\u001B[0m");
            }

            System.out.println("Do you want to play again? Type 'yes' or 'no'");
            playAgain = sc.next();
            sc.nextLine(); // Consume the newline character
        }
    }
}