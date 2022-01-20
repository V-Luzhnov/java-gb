package lesson01;
//Vitalii 11.01.2022 les01
import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple\n");
    }
    public static void checkSumSign() {
        Scanner sc = new Scanner(System.in);
        do {
            int pera = 0;
            int perb = 0;
            System.out.print("Введите число a: ");
            pera = sc.nextInt();
            System.out.print("Введите число b: ");
            perb = sc.nextInt();
            System.out.println(((pera + perb) >= 0)? (pera + perb) + " - сумма положительная" : (pera + perb) + " - сумма отрицательная");
            System.out.println("Повторить? Да - 1, Нет - 0");
        } while (sc.nextInt() == 1);
    }
    public static void printColor() {
        Scanner sc = new Scanner(System.in);
        do {
            int value = 0;
            System.out.print("Введите число: ");
            value = sc.nextInt();
            System.out.println((value <= 0)? "Красный" : ((value > 100)? "Зеленый" : "Желтый"));
            System.out.println("Повторить? Да - 1, Нет - 0");
        } while (sc.nextInt() == 1);
    }
    public static void compareNumbers() {
        Scanner sc = new Scanner(System.in);
        do {
            int pera = 0;
            int perb = 0;
            System.out.print("Введите число a: ");
            pera = sc.nextInt();
            System.out.print("Введите число b: ");
            perb = sc.nextInt();
            System.out.println((pera < perb)? "a < b | " + pera + " < " + perb : "a >= b | " + pera + " >= " + perb);
            System.out.println("Повторить? Да - 1, Нет - 0");
        } while (sc.nextInt() == 1);
    }
}

