/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 15/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.IOException;


class Result {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        int cost;
        int black = 0, white = 0, mix = 0;

        if (bc < wc) {

            black = 1;
            if (bc + z < wc) {
                mix = 1;
                black = 1;
            }

        } else {

            white = 1;
            if (wc + z < bc) {
                mix = 1;
                white = 1;
            }
        }

        if (mix == 1 && white == 1) {
            cost = w * wc + (wc + z) * b;
            return cost;
        } else if (mix == 1 && black == 1) {
            cost = bc * b + (bc + z) * w;
            return cost;
        }

        return bc * b + wc * w;


    }

}

public class TaumAndBday {
    public static void main(String[] args) throws IOException {

        long result = Result.taumBday(3, 6, 9, 1, 1);
        System.out.println(result);

    }
}
