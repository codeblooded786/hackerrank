/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 08/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CircularArrayRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] arr, int k, int[] queries) {

        k = k % arr.length;
        int i, l;
        int leftRotate = arr.length - k;
        int temp[] = new int[leftRotate];

        for (i = 0; i < leftRotate; i++) {
            temp[i] = arr[i];
        }

        for (i = 0; i < arr.length - leftRotate; i++) {
            arr[i] = arr[i + leftRotate];
        }
        l = 0;
        for (int j = i; j < arr.length; j++) {
            arr[j] = temp[l++];
        }

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (i = 0; i < queries.length; i++)
            System.out.print(arr[queries[i]] + " ");
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int queries[] = {0, 1, 2};

        int[] result = circularArrayRotation(arr, 12, queries);
    }
}

