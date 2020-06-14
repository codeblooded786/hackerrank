/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        int i;
        for (i = 0; i < s.length(); i++) {
            if (i >= t.length() || s.charAt(i) != t.charAt(i))
                break;
        }

        int deletions = s.length() - i;

        int addition = t.length() - i;

        if (k == deletions + addition)
            return "Yes";
        else if (k>deletions+addition)

        {
            if (k>(s.length()-deletions)*2+addition)
            {
                return "Yes";
            }
            else if ((k-addition-deletions)%2==0)
                return "Yes";
        }

            return "No";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String result = appendAndDelete("aaaaaaaaaa", "aaaaa", 7);
        System.out.print(result);
    }
}
