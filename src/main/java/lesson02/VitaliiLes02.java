package lesson02;
/*
 * Java 1. HomeWork 2
 *
 * @author Vitalii L.
 * @version 13.01.2022
 */
public class VitaliiLes02 {
    public static void main(String[] args) {
        rezSumm();
        rezWhatNumber();
        rezNegativeNumber();
        rezPrintWord();
        rezLeapYear();
    }
    //Задание 1 +
    public static void rezSumm() {
        System.out.println(summ(2, 10));
    }
    public static boolean summ(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }
    //Задание 1 -

    //Задание 2 +
    public static void rezWhatNumber() {
        whatNumber(-10);
    }
    public static void whatNumber(int a) {
        System.out.println (a >= 0 ? "Положительное" : "Отрицательное");
    }
    //Задание 2 -

    //Задание 3 +
    public static void rezNegativeNumber() {
        System.out.println (negativeNumber(-10));
    }
    public static boolean negativeNumber(int a) {
        return a < 0;
    }
    //Задание 3 -

    //Задание 4 +
    public static void rezPrintWord() {
        printWord("Какая-то строка", 3);
    }
    public static void printWord(String wrd, int a) {
        for (int i = 0; i < a; i++){
            System.out.println(wrd);
        }
    }
    //Задание 4 -

    //Задание 5 +
    public static void rezLeapYear() {
        System.out.println(leapYear(2020));
    }
    public static boolean leapYear(int a) {
        if (a % 4 != 0) { //Остаток от деления на 4 не равен 0, значит год невисокосный.
            return false;
        }
        else if (a % 400 == 0) { //Остаток от деления на 400 равен 0, значит год високосный.
            return true;
        }
        else if (a % 100 == 0) { //Остаток от деления на 100 равен 0, значит год високосный.
            return false;
        }
        else {
            return true; // Во всех других случаях год високосный.
        }
    }
    //Задание 5 -
}

