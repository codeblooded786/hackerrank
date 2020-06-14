/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String line, long n) {

        long count = line.length() - line.replace("a", "").length();

        long x = 0;

        /*if (n <= line.length() || n % line.length() == 0)
            System.out.println();
*/
        for (int i = 0; i < n % line.length(); i++)
            if (line.charAt(i) == 'a')
                x++;


        return count * (n / line.length()) + x;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        long result = repeatedString("aba", 10);

        System.out.println(result);


    }
}
