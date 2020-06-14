/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {

        for (int i = 0; i < matrix.size() / 2; i++) {
            int j = i + 1;
            int temp1 = matrix.get(i).get(j - 1);
            for (; j < matrix.size() - i; j++) {
                matrix.get(i).set(j - 1, matrix.get(i).get(j));
            }
            int temp2 = matrix.get(matrix.size() - i - 1).get(i);
            for (j = i + 2; j < matrix.size() - i; j++) {
                matrix.get(j).set(i, matrix.get(j - 1).get(i));
            }
            matrix.get(i + 1).set(i, temp1);

            int temp3 = matrix.get(matrix.size() - i - 1).get(matrix.size() - i - 1);
            for (j = i + 2; j < matrix.size() - i; j++)
                matrix.get(matrix.size() - i - 1).set(j, matrix.get(matrix.size() - i - 1).get(j - 1));

            matrix.get(matrix.size() - i - 1).set(matrix.size() - i - 2, temp2);

            for (j = i; j < matrix.size() - i - 2; j++)
                matrix.get(j).set(matrix.size() - i - 1, matrix.get(j + 1).get(matrix.size() - i - 1));

            matrix.get(matrix.size() - i - 2).set(matrix.size() - i - 1, temp3);


        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++)
                System.out.print(matrix.get(i).get(j) + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) throws IOException {


        List<List<Integer>> matrix = new ArrayList<>();

        matrix.add(Arrays.asList(1, 2, 3, 4, 5));
        matrix.add(Arrays.asList(6, 7, 8, 9, 10));
        matrix.add(Arrays.asList(11, 12, 13, 14, 15));
        matrix.add(Arrays.asList(16, 17, 18, 19, 20));
        matrix.add(Arrays.asList(21, 22, 23, 24, 25));

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++)
                System.out.print(matrix.get(i).get(j) + " ");
            System.out.println();
        }

        matrixRotation(matrix, 1);


    }
}
