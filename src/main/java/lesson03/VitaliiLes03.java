package lesson03;
/*
 * Java 1. HomeWork 3
 *
 * @author Vitalii L.
 * @version 20.01.2022
 */
import java.util.Arrays;

public class VitaliiLes03 {
    public static void main(String[] args) {
        taskNumber(1); invertArray();
        taskNumber(2); fillArray();
        taskNumber(3); changeArray();
        taskNumber(4); fillDiagonal();
        taskNumber(5); createArr();
        taskNumber(6); elementArrayMinMax();
        taskNumber(7); checkBalance();
        taskNumber(8); arrayShift();
    }
    public static void taskNumber(int tn) {
        System.out.println((tn == 1?"":"\n") + "Задание " + tn + ".");
    }
    //Задание 1 +
    public static void invertArray() {
        int[] arr = { 1, 0, 1, 0, 0, 1 };

        System.out.println("Old array - " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0? 1 : 0);
        }

        System.out.println("New array - " + Arrays.toString(arr));
    }
    //Задание 1 -

    //Задание 2 +
    public static void fillArray() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println("Array - " + Arrays.toString(arr));
    }
    //Задание 2 -

    //Задание 3 +
    public static void changeArray() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println("Old array - " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6? arr[i] * 2 : arr[i]);
        }

        System.out.println("New array - " + Arrays.toString(arr));
    }
    //Задание 3 -

    //Задание 4 +
    public static void fillDiagonal() {
        int n = 5;
        int[][] arr = new int[n][n];
//        System.out.println("Old array - " + Arrays.deepToString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println("New array - " + Arrays.deepToString(arr));
    }
    //Задание 4 -

    //Задание 5 +
    public static void createArr() {
        int len = 5;
        int initialValue = 17;

        System.out.println("len = " + len);
        System.out.println("initialValue = " + initialValue);
        System.out.println("Array - " + Arrays.toString(newArr(len, initialValue)));
    }
    public static int[] newArr(int len, int initialValue) {
        int[] arr = new int[len];

        Arrays.fill(arr, initialValue);

//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = initialValue;
//        }

        return arr;
    }
    //Задание 5 -

    //Задание 6 +
    public static void elementArrayMinMax() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int minVal = arr[0];
        int maxVal = arr[0];

        for (int a : arr) {
            minVal = (minVal > a? a : minVal);
            maxVal = (maxVal < a? a : maxVal);
        }

        System.out.println("Array - " + Arrays.toString(arr));
        System.out.println("Min - " + minVal);
        System.out.println("Min - " + maxVal);
    }
    //Задание 6 -

    //Задание 7 +
    public static void checkBalance() {
//        int[] arr = { 3, 2, 0, 5, 7, 1, 3, 4 }; //false
//        int[] arr = { 3, 2, 0, 5, 7, 1, 3, 5 }; //[3, 2, ||| 5]
        int[] arr = { 3, 2, 0, 5, 7, 1, 3, 6 }; //[3, 2, 0, 5, ||| 1, 3, 6]
//        int[] arr = { 3, 2, 0, 5, 7, 1, 3, 7 }; //[3, 2, 0, 5, ||| 3, 7]

        System.out.println("Array - " + Arrays.toString(arr));
        System.out.println("Result - " + resultCheckBalance(arr));
    }
    public static boolean resultCheckBalance(int[] arr) {
        int l = 0; //Для хранения значений левой части
        int r = 0; //Для хранения значений правой части
        String sl = ""; //Для вывода строкового значения левой части checkBalance
        String sr = ""; //Для вывода строкового значения правой части checkBalance

        //Перебор элементов массива от большего к меньшему, кроме индекса [0]
        for (int iR = arr.length - 1; iR > 0; iR--) {
            //iR == arr.length - 1 - если первый цикл
            r = (iR == arr.length - 1? arr[iR] : r + arr[iR]);
            sr = (iR == arr.length - 1? arr[iR] + "]" : arr[iR] + ", " + sr);

            //Перебор элементов массива от меньшего к большему, кроме индекса [iR]
            for (int i = 0; i < iR; i++) {
                //i == 0 - если первый цикл
                l = (i == 0? arr[i] : l + arr[i]);
                sl = (i == 0? "[" + arr[i] : sl + ", " + arr[i]);

                if (l == r) {
                    System.out.println("checkBalance = " + sl + ", ||| " + sr);
                    return true;
                }
            }
        }
        return false;
    }
    //Задание 7 -

    //Задание 8 +
    public static void arrayShift() {
        int n = 9;
//        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] arr = { 1, 2, 3, 4, 5};

        System.out.println("Old array - " + Arrays.toString(arr));
        System.out.println("New array if n = " + n + " - " + Arrays.toString(resultArrayShift(arr, n)));
        resultArrayShift(arr, -n);
        System.out.println("New array if n = " + (-n) + " - " + Arrays.toString(resultArrayShift(arr, -n)));
    }
    public static int[] resultArrayShift(int[] arr, int n) {
        if (n % arr.length == 0){ //при таком количестве циклов результат не изменится
            return arr;
        }
        int storage = 0; //для хранения переносимого значения

        n = n % arr.length; //исключаем количество полных циклов, где результат не изменится

        //Если n положительное, то смещаем вправо
        if (n > 0) {
            for (int in = 1; in <= n; in++) {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (i == arr.length - 1) {
                        storage = arr[i];
                    }
                    arr[i] = (i == 0? storage : arr[i - 1]);
                }
            }
        }
        //Если n отрицательное, то смещаем влево
        if (n < 0) {
            for (int in = 1; in <= -n; in++) {
                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        storage = arr[i];
                    }
                    arr[i] = (i == arr.length - 1? storage : arr[i + 1]);
                }
            }
        }
        return arr;
    }
    //Задание 8 -
}

