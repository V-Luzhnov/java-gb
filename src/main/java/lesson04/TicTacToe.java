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
                System.out.println("AI WON!");
                break;
            }
            if (isTableFull()){
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
            System.out.print("Enter x| y_ [1.." + SIZE + "]: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x,y));
        table[x][y] = CHAR_X;
    }

    void turnAI(){
        if (itFirstMoveAI()) {
            makeFirstMoveAI();
        } else{
            makeMoveAI();
        }
    }

    //Определение первого хода ИИ
    boolean itFirstMoveAI() {
        int quantity = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (table[x][y] == CHAR_O) {
                    quantity++;
                }
            }
        }
        return quantity == 0;
    }

    //Первый ход ИИ - если это первый ход ИИ, то он ходит в центр, если тот свободен, иначе ходит вверх справа от центра
    void makeFirstMoveAI(){
        if (table[SIZE / 2][SIZE / 2] != CHAR_X){
            table[SIZE / 2][SIZE / 2] = CHAR_O;
        } else {
            table[(SIZE / 2)-1][(SIZE / 2)-1] = CHAR_O;
        }
    }

    //Последний ход ИИ - если ИИ видит, что до победы ему остался 1 ход, то он его сделает
    void makeMoveAI() {
        int x,y,quantity;
        boolean check = false;

        //Строки (последний)
        for (x = 0; x < SIZE; x++) {
            if (!check) {
                quantity = 0;
                for (y = 0; y < SIZE; y++) {
                    if (table[x][y] == CHAR_O) {
                        quantity++;
                    } else if (table[x][y] == CHAR_X) {
                        quantity = 0;
                    }
                    if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                        for (y = 0; y < SIZE; y++) {
                            if (table[x][y] == CHAR_EMPTY  && !check  && (table[x][(y-1<0?0:y-1)] == CHAR_O || table[x][(y+1>SIZE-1?SIZE-1:y+1)] == CHAR_O)) {
                                table[x][y] = CHAR_O;
                                check = true;
                            }
                        }
                    }
                }
            }
        }

        //Столбцы (последний)
        for (y = 0; y < SIZE; y++) {
            if (!check) {
                quantity = 0;
                for (x = 0; x < SIZE; x++) {
                    if (table[x][y] == CHAR_O) {
                        quantity++;
                    } else if (table[x][y] == CHAR_X) {
                        quantity = 0;
                    }
                    if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                        for (x = 0; x < SIZE; x++) {
                            if (table[x][y] == CHAR_EMPTY  && !check && (table[(x-1<0?0:x-1)][y] == CHAR_O || table[(x+1>SIZE-1?SIZE-1:x+1)][y] == CHAR_O)) {
                                table[x][y] = CHAR_O;
                                check = true;
                            }
                        }
                    }
                }
            }
        }

        //Главная диагональ (последний)
        quantity = 0;
        for (int i = 0; i < SIZE; i++) {
            if(!check) {
                if (table[i][i] == CHAR_O) {
                    quantity++;
                } else if (table[i][i] == CHAR_X) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                    for (i = 0; i < SIZE; i++) {
                        if (table[i][i] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(i-1<0?0:i-1)] == CHAR_O || table[(i+1>SIZE-1?SIZE-1:i+1)][(i+1>SIZE-1?SIZE-1:i+1)] == CHAR_O)) {
                            table[i][i] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Главная диагональ слева (последний)
        quantity = 0;
        for (int i = 1, j = 0; i < SIZE; i++, j++) {
            if(!check) {
                if (table[i][j] == CHAR_O) {
                    quantity++;
                } else if (table[i][j] == CHAR_X) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                    for (i = 1, j = 0; i < SIZE; i++, j++) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j-1<0?0:j-1)] == CHAR_O || table[(i+1>SIZE-1?SIZE-1:i+1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_O)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Главная диагональ справа (последний)
        quantity = 0;
        for (int i = 0, j = 1; i < SIZE - 1; i++, j++) {
            if(!check) {
                if (table[i][j] == CHAR_O) {
                    quantity++;
                } else if (table[i][j] == CHAR_X) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                    for (i = 0, j = 1; i < SIZE - 1; i++, j++) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j-1<0?0:j-1)] == CHAR_O || table[(i+1>SIZE-1?SIZE-1:i+1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_O)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Второстепенная диагональ (последний)
        quantity = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if(!check) {
                if (table[i][j] == CHAR_O) {
                    quantity++;
                } else if (table[i][SIZE - i - 1] != CHAR_X) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                    for (i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_O || table[(i+1>SIZE-1?SIZE-1:i+1)][(j-1<0?0:j-1)] == CHAR_O)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Второстепенная диагональ слева (последний)
        quantity = 0;
        for (int i = 0, j = SIZE - 2; i < SIZE - 1; i++, j--) {
            if(!check) {
                if (table[i][j] == CHAR_O) {
                    quantity++;
                } else if (table[i][SIZE - i - 1] != CHAR_X) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                    for (i = 0, j = SIZE - 2; i < SIZE - 1; i++, j--) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_O || table[(i+1>SIZE-1?SIZE-1:i+1)][(j-1<0?0:j-1)] == CHAR_O)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Второстепенная диагональ справа (последний)
        quantity = 0;
        for (int i = 1, j = SIZE - 1; i < SIZE; i++, j--) {
            if(!check) {
                if (table[i][j] == CHAR_O) {
                    quantity++;
                } else if (table[i][SIZE - i - 1] != CHAR_X) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 2)) {
                    for (i = 1, j = SIZE - 1; i < SIZE; i++, j--) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_O || table[(i+1>SIZE-1?SIZE-1:i+1)][(j-1<0?0:j-1)] == CHAR_O)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Если последнего хода нет, то выполнить блокирующий ход
        if (!check) {
            blockMakeMoveAI();
        }
    }

    //Блокирующий ход ИИ
    void blockMakeMoveAI(){
        int x,y,quantity;
        boolean check = false;

        //Строки (блокирующий)
        for (x = 0; x < SIZE; x++) {
            if (!check) {
                quantity = 0;
                for (y = 0; y < SIZE; y++) {
                    if (table[x][y] == CHAR_X) {
                        quantity++;
                    } else if (table[x][y] == CHAR_O) {
                        quantity = 0;
                    }
                    if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                        for (y = 0; y < SIZE; y++) {
                            if (table[x][y] == CHAR_EMPTY  && !check  && (table[x][(y-1<0?0:y-1)] == CHAR_X || table[x][(y+1>SIZE-1?SIZE-1:y+1)] == CHAR_X)) {
                                table[x][y] = CHAR_O;
                                check = true;
                            }
                        }
                    }
                }
            }
        }

        //Столбцы (блокирующий)
        for (y = 0; y < SIZE; y++) {
            if (!check) {
                quantity = 0;
                for (x = 0; x < SIZE; x++) {
                    if (table[x][y] == CHAR_X) {
                        quantity++;
                    } else if (table[x][y] == CHAR_O) {
                        quantity = 0;
                    }
                    if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                        for (x = 0; x < SIZE; x++) {
                            if (table[x][y] == CHAR_EMPTY  && !check && (table[(x-1<0?0:x-1)][y] == CHAR_X || table[(x+1>SIZE-1?SIZE-1:x+1)][y] == CHAR_X)) {
                                table[x][y] = CHAR_O;
                                check = true;
                            }
                        }
                    }
                }
            }
        }

        //Главная диагональ (блокирующий)
        quantity = 0;
        for (int i = 0; i < SIZE; i++) {
            if(!check) {
                if (table[i][i] == CHAR_X) {
                    quantity++;
                } else if (table[i][i] == CHAR_O) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                    for (i = 0; i < SIZE; i++) {
                        if (table[i][i] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(i-1<0?0:i-1)] == CHAR_X || table[(i+1>SIZE-1?SIZE-1:i+1)][(i+1>SIZE-1?SIZE-1:i+1)] == CHAR_X)) {
                            table[i][i] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Главная диагональ слева (блокирующий)
        quantity = 0;
        for (int i = 1, j = 0; i < SIZE; i++, j++) {
            if(!check) {
                if (table[i][j] == CHAR_X) {
                    quantity++;
                } else if (table[i][j] == CHAR_O) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                    for (i = 1, j = 0; i < SIZE; i++, j++) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j-1<0?0:j-1)] == CHAR_X || table[(i+1>SIZE-1?SIZE-1:i+1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_X)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Главная диагональ справа (блокирующий)
        quantity = 0;
        for (int i = 0, j = 1; i < SIZE - 1; i++, j++) {
            if(!check) {
                if (table[i][j] == CHAR_X) {
                    quantity++;
                } else if (table[i][j] == CHAR_O) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                    for (i = 0, j = 1; i < SIZE - 1; i++, j++) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j-1<0?0:j-1)] == CHAR_X || table[(i+1>SIZE-1?SIZE-1:i+1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_X)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Второстепенная диагональ (блокирующий)
        quantity = 0;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            if(!check) {
                if (table[i][j] == CHAR_X) {
                    quantity++;
                } else if (table[i][SIZE - i - 1] != CHAR_O) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                    for (i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_X || table[(i+1>SIZE-1?SIZE-1:i+1)][(j-1<0?0:j-1)] == CHAR_X)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Второстепенная диагональ слева (блокирующий)
        quantity = 0;
        for (int i = 0, j = SIZE - 2; i < SIZE - 1; i++, j--) {
            if(!check) {
                if (table[i][j] == CHAR_X) {
                    quantity++;
                } else if (table[i][SIZE - i - 1] != CHAR_O) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                    for (i = 0, j = SIZE - 2; i < SIZE - 1; i++, j--) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_X || table[(i+1>SIZE-1?SIZE-1:i+1)][(j-1<0?0:j-1)] == CHAR_X)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Второстепенная диагональ справа (блокирующий)
        quantity = 0;
        for (int i = 1, j = SIZE - 1; i < SIZE; i++, j--) {
            if(!check) {
                if (table[i][j] == CHAR_X) {
                    quantity++;
                } else if (table[i][SIZE - i - 1] != CHAR_O) {
                    quantity = 0;
                }
                if (quantity == (SIZE <= 3 ? SIZE - 1 : SIZE - 3)) {
                    for (i = 1, j = SIZE - 1; i < SIZE; i++, j--) {
                        if (table[i][j] == CHAR_EMPTY  && !check && (table[(i-1<0?0:i-1)][(j+1>SIZE-1?SIZE-1:j+1)] == CHAR_X || table[(i+1>SIZE-1?SIZE-1:i+1)][(j-1<0?0:j-1)] == CHAR_X)) {
                            table[i][j] = CHAR_O;
                            check = true;
                        }
                    }
                }
            }
        }

        //Если блокирующего хода нет, то ходить рандомно
        if (!check) {
            randomMakeMoveAI();
        }
    }

    //Рандомный ход ИИ
    void randomMakeMoveAI(){
        int x,y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        table[x][y] = CHAR_O;
    }

    boolean isCellValid(int x, int y){
        if (x < 0 || y < 0 || x > SIZE - 1 || y > SIZE - 1) {
            return false;
        }
        return table[x][y] == CHAR_EMPTY;
    }

    boolean checkWin(char ch){
        if (checkRow(ch) || checkColumn(ch) || checkDiagonal(ch)) {
            return true;
        }
        return false;
    }

    boolean checkRow(char ch){
        for (int x = 0; x < SIZE; x++) {
            int quantity = 0;
            for (int y = 0; y < SIZE; y++) {
                if (table[x][y] == ch) {
                    quantity++;
                    if (winCondition(quantity)) {
                        return true;
                    }
                } else {
                    quantity = 0;
                }
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
                    if (winCondition(quantity)) {
                        return true;
                    }
                } else {
                    quantity = 0;
                }
            }
        }
        return false;
    }

    boolean checkDiagonal(char ch) {
        int quantity = 0;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][i] == ch) {
                quantity++;
                if (winCondition(quantity)) {
                    return true;
                }
            } else {
            quantity = 0;
            }
        }
        quantity = 0;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][SIZE - i - 1] == ch) {
                quantity++;
                if (winCondition(quantity)) {
                    return true;
                }
            } else {
                quantity = 0;
            }
        }
        return false;
    }

    boolean winCondition(int quantity){
        if (quantity == SIZE && SIZE <= 3) {
            return true;
        }
        if (quantity == SIZE - 1 && SIZE > 3) {
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
