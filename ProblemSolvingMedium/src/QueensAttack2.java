/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.IOException;
import java.util.Scanner;

public class QueensAttack2 {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        int op = 0, queensPosy = 0, queensPosx = 0;

        int arr[][] = new int[n][n];

        queensPosx = getRow(r_q, n);
        queensPosy = getCol(c_q);

        arr[getRow(r_q, n)][getCol(c_q)] = -1;

        //row col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == getRow(r_q, n) || j == getCol(c_q))) {
                    //  if (i != queensPosx && j != queensPosy)
                    arr[i][j] = 1;
                }
            }
        }
        arr[queensPosx][queensPosy] = -1;



        /*for (int i = getRow(r_q, n) + 1; i < n; i++) {
            for (int j = getCol(c_q) + 1; j < n; j++) {
                arr[i][j] = 1;
            }
        }*/

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        int row = getRow(r_q, n) + 1;
        int col = getCol(c_q) + 1;


        //down right
        while (true) {
            if (row == n || col == n)
                break;
            arr[row++][col++] = 1;

        }

        row = getRow(r_q, n) + 1;
        col = getCol(c_q) - 1;

        //down left
        while (true) {
            if (row == n || col == -1)
                break;
            arr[row++][col--] = 1;

        }

        row = getRow(r_q, n) - 1;
        col = getCol(c_q) - 1;

        //up left
        while (true) {
            if (row == -1 || col == -1)
                break;
            arr[row--][col--] = 1;
        }


        row = getRow(r_q, n) - 1;
        col = getCol(c_q) + 1;

        //up right
        while (true) {
            if (row == -1 || col == n)
                break;
            arr[row--][col++] = 1;
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        arr[queensPosx][queensPosy] = -1;

        for (int i = 0; i < obstacles.length; i++) {
            //System.out.print(obstacles[i][0]+" "+obstacles[i][1]+" ");
            row = getRow(obstacles[i][0], n);
            col = getCol(obstacles[i][1]);
            /*System.out.println(row+" "+col);
            System.out.println(checkRow(row, col, n, arr));
            System.out.println(checkCol(row, col, n, arr));
            System.out.println(checkPrimeDiagonal(row, col, n, arr));
            System.out.println(checkOtherDiagonal(row, col, n, arr));*/
            if (checkRow(row, col, n, arr)) {
                if (col < queensPosy) {
                    for (int p = 0; p <= col; p++)
                        arr[row][p] = 0;
                } else {
                    for (int q = col; q < n; q++) {
                        arr[row][q] = 0;
                    }
                }
            }

            if (checkCol(row, col, n, arr)) {
                if (row < queensPosx) {
                    for (int p = 0; p <= row; p++)
                        arr[p][col] = 0;
                } else {
                    for (int q = row; q < n; q++) {
                        arr[q][col] = 0;
                    }
                }
            }

            row = getRow(obstacles[i][0], n);
            col = getCol(obstacles[i][1]);
            if (checkPrimeDiagonal(row, col, n, arr)) {
                if (row < queensPosx) {
                    while (row != -1 && col != -1)
                        arr[row--][col--] = 0;
                } else {
                    while (row != n && col != n)
                        arr[row++][col++] = 0;
                }

            }
            row = getRow(obstacles[i][0], n);
            col = getCol(obstacles[i][1]);
            if (checkOtherDiagonal(row, col, n, arr)) {
                if (row < queensPosx) {
                    while (row != -1 && col != n)
                        arr[row--][col++] = 0;
                } else {
                    while (row != n && col != -1)
                        arr[row++][col--] = 0;
                }

            }

        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != -1)
                    op += arr[i][j];
            }
        }

        return op;
    }

    private static int getRow(int x, int n) {
        return n - x;
    }

    private static int getCol(int x) {
        return x - 1;
    }

    private static boolean checkRow(int x, int y, int n, int arr[][]) {

        for (int j = 0; j < n; j++) {
            if (arr[x][j] == -1)
                return true;
        }
        return false;
    }

    private static boolean checkCol(int x, int y, int n, int arr[][]) {

        for (int i = 0; i < n; i++) {
            if (arr[i][y] == -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPrimeDiagonal(int x, int y, int n, int arr[][]) {
        int row = x - 1;
        int col = y - 1;
        while (row != -1 && col != -1) {
            if (arr[row][col] == -1)
                return true;
            row--;
            col--;
        }
        row = x + 1;
        col = y + 1;

        while (row != n && col != n) {
            if (arr[row][col] == -1)
                return true;
            row++;
            col++;
        }

        return false;
    }

    private static boolean checkOtherDiagonal(int x, int y, int n, int arr[][]) {
        int row = x - 1;
        int col = y + 1;
        while (row != -1 && col != n) {
            if (arr[row][col] == -1)
                return true;
            row--;
            col++;
        }
        row = x + 1;
        col = y - 1;

        while (row != n && col != -1) {
            if (arr[row][col] == -1)
                return true;
            row++;
            col--;
        }

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] obstacles = /*{{5, 5}, {4, 2}, {2, 3}};*/
/*
                {
                        {54, 87},
                        {64, 97},
                        {42, 75},
                        {32, 65},
                        {42, 87},
                        {32, 97},
                        {54, 75},
                        {64, 65},
                        {48, 87},
                        {48, 75},
                        {54, 81},
                        {42, 81},
                        {45, 17},
                        {14, 24},
                        {35, 15},
                        {95, 64},
                        {63, 87},
                        {25, 72},
                        {71, 38},
                        {96, 97},
                        {16, 30},
                        {60, 34},
                        {31, 67},
                        {26, 82},
                        {20, 93},
                        {81, 38},
                        {51, 94},
                        {75, 41},
                        {79, 84},
                        {79, 65},
                        {76, 80},
                        {52, 87},
                        {81, 54},
                        {89, 52},
                        {20, 31},
                        {10, 41},
                        {32, 73},
                        {83, 98},
                        {87, 61},
                        {82, 52},
                        {80, 64},
                        {82, 46},
                        {49, 21},
                        {73, 86},
                        {37, 70},
                        {43, 12},
                        {94, 28},
                        {10, 93},
                        {52, 25},
                        {50, 61},
                        {52, 68},
                        {52, 23},
                        {60, 91},
                        {79, 17},
                        {93, 82},
                        {12, 18},
                        {75, 64},
                        {69, 69},
                        {94, 74},
                        {61, 61},
                        {46, 57},
                        {67, 45},
                        {96, 64},
                        {83, 89},
                        {58, 87},
                        {76, 53},
                        {79, 21},
                        {94, 70},
                        {16, 10},
                        {50, 82},
                        {92, 20},
                        {40, 51},
                        {49, 28},
                        {51, 82},
                        {35, 16},
                        {15, 86},
                        {78, 89},
                        {41, 98},
                        {70, 46},
                        {79, 79},
                        {24, 40},
                        {91, 13},
                        {59, 73},
                        {35, 32},
                        {40, 31},
                        {14, 31},
                        {71, 35},
                        {96, 18},
                        {27, 39},
                        {28, 38},
                        {41, 36},
                        {31, 63},
                        {52, 48},
                        {81, 25},
                        {49, 90},
                        {32, 65},
                        {25, 45},
                        {63, 94},
                        {89, 50},
                        {43, 41}};*/

                {{20001, 20002},
                        {20001, 20004},
                        {20000, 20003},
                        {20002, 20003},
                        {20000, 20004},
                        {20000, 20002},
                        {20002, 20004},
                        {20002, 20002},
                        {564, 323}};
        int result = queensAttack(88587, 9, 20001, 20003, obstacles);

        System.out.println(result);


    }
}


