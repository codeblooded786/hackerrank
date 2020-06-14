/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int i = 0;
        int n = c.length;
        int energy = 100;
        do {
            i = (i + k) % n;
            if (c[i] == 0)
                energy--;
            if (c[i] == 1)
                energy -= 3;
        } while (i != 0);

        System.out.println(energy);

        return energy;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arr[] = {0, 0, 1, 0};
        int result = jumpingOnClouds(arr, 2);

    }
}
