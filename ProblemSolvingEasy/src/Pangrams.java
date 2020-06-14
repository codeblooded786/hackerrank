/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 15/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pangrams {

    // Complete the pangrams function below.
    static String pangrams(String s) {

        s = s.replaceAll("\\s+", "");
        s = s.toLowerCase();
        Boolean flag = false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }

            if (map.size() == 26) {
                flag = true;
            }


        }


        return flag ? "pangram" : "not pangram";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String result = pangrams("We promptly judged antique ivory buckles for the prize");

        System.out.println(result);

    }
}
