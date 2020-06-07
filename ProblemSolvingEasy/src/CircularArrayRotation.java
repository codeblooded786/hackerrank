/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 08/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CircularArrayRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] arr, int k, int[] queries) {

        int i,l;
        int leftRotate = arr.length-k;
        int temp[] = new int[leftRotate];

        for ( i = 0; i < leftRotate; i++) {
            temp[i] = arr[i];
        }

        for ( i=0;i<arr.length-leftRotate;i++)
        {
            arr[i]=arr[i+leftRotate];
        }
        l=0;
        for (int j =i;j<arr.length;j++)
        {
            arr[j]=temp[l++];
        }

        for ( i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        for (i=0;i<queries.length;i++)
            System.out.println(arr[queries[i]]);
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }*/

        int arr[] = {1, 2, 3,4,5};
        int queries[] = {0, 1, 2};


        int[] result = circularArrayRotation(arr, 2, queries);

        /*for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}

