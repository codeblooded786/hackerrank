/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {

        List<Integer> result = new ArrayList<>();

        Integer brr[] = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(brr));

        while (!integerList.isEmpty()) {
            Integer min = integerList.stream().sorted().collect(Collectors.toList()).get(0);

            for (int i = 0; i < integerList.size(); i++)
                integerList.set(i, integerList.get(i) - min);

            System.out.println(integerList.size());
            result.add(integerList.size());

            if (integerList.contains(0)) {
                integerList.removeAll(Collections.singleton(0));
            }

        }
        int finalArray [] = result.stream().mapToInt(i->i).toArray();

        return finalArray;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //int arr[] = {5, 4, 4, 2, 2, 8};
        int arr[] ={1 ,2 ,3, 4, 3, 3, 2, 1};

        int[] result = cutTheSticks(arr);


    }
}
