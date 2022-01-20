package lesson00;

import java.util.Random;
import java.util.Scanner;

public class les00 {
    public static void main(String[] args)
    {
        HelloWorld();
        Variables();
        Kettle();
        Stairs();
        Hammer();
        RandomInt();
        GuessTheNumber();
    }
    public static void HelloWorld() {
        System.out.println("Hello, world!");
    }
    public static void Variables() {
        int first = 10;
        float second1, second2;
        second1 = first / 4f + 5;
        second2 = first / 4 + 5;
        String username = "Vitalii";
        System.out.println(first);
        System.out.println(second1);
        System.out.println(second2);
        System.out.println(username);
    }
    public static void Kettle() {
        int water = 0;
        System.out.println("Take a kettle");
        // if (water == 0) {
        // System.out.println("Pour water");
        // } else {
        // System.out.println("No need to pour");
        // }
        System.out.println(water == 0? "Pour water" : "No need to pour");
        System.out.println("Put the kettle on fire");
    }
    public static void Stairs() {
        for (int i = 1; i < 11; i++) {
            System.out.println("Go down a stair step #" + i);
        }
    }
    public static void Hammer() {
        int count = 0;
        float nail = 10f;
        float cmPerHit = 1.95f;
        while (nail > 0) {
            count++;
            nail = nail - cmPerHit;
            System.out.println("Hit #" + count);
        }
    }
    public static void RandomInt() {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.print(random.nextInt(10) + " ");
        }
    }
    public static void GuessTheNumber() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        do {
            int count = 0;
            int guess = -1;
            int number = random.nextInt(10);
            while (count < 3 && guess != number) {
                System.out.println("Attempts: " + (3 - count));
                System.out.print("Guess the number (0..9): ");
                guess = sc.nextInt();
                if (number != guess) {
                    System.out.println("Your number is " + ((guess > number)? "greater" : "less"));
                    count++;
                }
            }
            System.out.println("You " + ((guess == number)? "WIN: " + number : "Lose: " + number));
            System.out.println("Repeat game? Yes - 1, No - 0");
        } while (sc.nextInt() == 1);
    }
}

