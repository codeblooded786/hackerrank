/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {

            String temp="";
            String result="";
            s = s.replaceAll("\\s+", "");

            int stringLength = s.length();

            int x = (int) Math.floor(Math.sqrt(stringLength));

            int y = (int) Math.ceil(Math.sqrt(stringLength));

            if (x * y < stringLength)
                x++;


            char arr[][] = new char[x][y];
            int k = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (k < s.length())
                        arr[i][j] = s.charAt(k++);
                    else
                        arr[i][j] = '\0';
                }
            }

            for (int i = 0; i < y; i++) {
                temp="";
                for (int j = 0; j < x; j++) {
                    temp +=arr[j][i];
                }
                result+=temp.trim()+" ";
            }

            return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = "if man was meant to stay on the ground god would have given us roots";
       // String s ="haveaniceday";
        String result = encryption(s);
        System.out.println(result);
    }
}
