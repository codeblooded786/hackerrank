/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 15/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EqualizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int i = 0, max = 1;

        Arrays.sort(arr);

        while (i < arr.length) {
            int count = 1;
            while (true) {
                i++;
                if (i >= arr.length || arr[i - 1] != arr[i]) {
                    break;
                }
                count++;
            }

            if (count > max)
                max = count;

        }

        System.out.println(max);

        return arr.length - max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arr[] = {10, 20, 10, 20, 30, 20, 20};

        int result = equalizeArray(arr);

    }
}
