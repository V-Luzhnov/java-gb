package lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final char CHAR_O = 'o';
    final char CHAR_X = 'x';
    final char CHAR_EMPTY = '.';
    final int SIZE = 3;
    Random random;
    Scanner scanner;
    char [][] table;

    public static void main (String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        table = new char[SIZE][SIZE];
        random = new Random();
        scanner = new Scanner(System.in);
    }
    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (checkWin(CHAR_X)){
                printTable();
                System.out.println("YOU WON!");
                break;
            }
            if (isTableFull()){
                printTable();
                System.out.println("Sorry, WRAW...");
                break;
            }
            turnAI();
            printTable();
            if (checkWin(CHAR_O)){
                printTable();
                System.out.println("AI WON!");
                break;
            }
            if (isTableFull()){
                printTable();
                System.out.println("Sorry, WRAW...");
                break;
            }
        }
        System.out.println("Game Over");

    }

    void initTable(){
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                table[x][y] = CHAR_EMPTY;
            }
        }
    }

    void printTable() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                System.out.print(table[y][x] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman(){
        int x,y;
        do {
            System.out.print("Enter x| y_ [1..3]: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x,y));
        table[x][y] = CHAR_X;
    }

    void turnAI(){
        int x,y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x,y));
        table[x][y] = CHAR_O;

    }

    boolean isCellValid(int x, int y){
        if (x < 0 || y < 0 || x > SIZE - 1 || y > SIZE - 1) {
            return false;
        }
        return table[x][y] == CHAR_EMPTY;
    }

    boolean checkWin(char ch){
        //Luzhnov 22.01.22 +
        if (checkRow(ch) || checkColumn(ch) || checkDiagonal(ch)) {
            return true;
        }
//        if (table[0][0] == ch && table[0][1] == ch && table[0][2] == ch) return true;
//        if (table[1][0] == ch && table[1][1] == ch && table[1][2] == ch) return true;
//        if (table[2][0] == ch && table[2][1] == ch && table[2][2] == ch) return true;
//
//        if (table[0][0] == ch && table[1][0] == ch && table[2][0] == ch) return true;
//        if (table[0][1] == ch && table[1][1] == ch && table[2][1] == ch) return true;
//        if (table[0][2] == ch && table[1][2] == ch && table[2][2] == ch) return true;
//
//        if (table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
//        if (table[2][0] == ch && table[1][1] == ch && table[0][2] == ch) return true;
        //Luzhnov 22.01.22 -
        return false;
    }

    boolean checkRow(char ch){
        for (int x = 0; x < SIZE; x++) {
            int quantity = 0;
            for (int y = 0; y < SIZE; y++) {
                if (table[x][y] == ch) {
                    quantity++;
                }
            }
            if (quantity == SIZE) {
                return true;
            }
        }
        return false;
    }

    boolean checkColumn(char ch){
        for (int y = 0; y < SIZE; y++) {
            int quantity = 0;
            for (int x = 0; x < SIZE; x++) {
                if (table[x][y] == ch) {
                    quantity++;
                }
            }
            if (quantity == SIZE) {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonal(char ch) {
        int quantity = 0;

        for (int i = 0; i < SIZE; i++) {
            if (table[i][i] == ch) {
                quantity++;
            }
        }

        if (quantity == SIZE) {
            return true;
        }

        quantity = 0;
//        int j = SIZE - 1;
        for (int x = 0, y = SIZE - 1; x < SIZE; x++, y--) {
            if (table[x][y] == ch) {
                quantity++;
            }
        }

        if (quantity == SIZE) {
            return true;
        }
        return false;
    }

    boolean isTableFull() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (table[x][y] == CHAR_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
