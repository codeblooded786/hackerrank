/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 15/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] arr) {
        int i = 0;
        int count = 0;
        while (i < arr.length - 2) {
            if (arr[i + 1] == 1) {
                count++;
                i += 2;
            } else if (arr[i + 2] == 1) {
                count++;
                i += 1;
            } else {
                count++;
                i += 2;
            }
        }
        //System.out.println(count);
        if (i<arr.length-1)
            count++;
        return count;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        //int c[]={0,1,0,0,0,1,0};
        //int c[] = {0, 0, 1, 0, 0, 1, 0};
        int c[] = {0, 0, 0, 1, 0, 0};
        int result = jumpingOnClouds(c);
        System.out.println(result);

        scanner.close();
    }
}
