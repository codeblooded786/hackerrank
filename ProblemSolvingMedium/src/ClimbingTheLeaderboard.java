/**
 * @project hackerrank
 * Created by @author Rahul Dev Gupta on 14/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int result[] = new int[alice.length];
        Set<Integer> integerSet = Arrays.stream(scores).boxed().collect(Collectors.toSet());
        List<Integer> integerList = integerSet.stream().collect(Collectors.toList());
        Collections.sort(integerList);
        Arrays.sort(alice);
        for (Integer x : integerList)
            System.out.println(x);
        int j=0, k = 0;

        for (int i = 0; i < alice.length; i++) {

            for (; j < integerList.size(); j++) {
                if (integerList.get(j) >= alice[i]) {
                    break;
                }
            }
            if (j != integerList.size() && integerList.get(j) == alice[i])
                result[k++] = integerList.size() - j;
            else
                result[k++] = integerList.size() - j + 1;
        }
        for (int i=0;i<result.length;i++)
            System.out.println(result[i]);
        return result;

    }

    static int[] climbingLeaderboard2(int[] scores, int[] alice) {

        int result[] = new int[alice.length];
        Set<Integer> integerSet = Arrays.stream(scores).boxed().collect(Collectors.toSet());
        List<Integer> integerList = integerSet.stream().collect(Collectors.toList());
        Collections.sort(integerList);
       /* for (Integer x : integerList)
            System.out.println(x);*/
        int j, k = 0;

        Map<Integer,Integer> rankMap = new HashMap<>();
        int x = integerList.size();

        for (int i=0;i<integerList.size();i++)
        {
            rankMap.put(x--, integerList.get(i));
        }

        for (Map.Entry entry : rankMap.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        for (int i = 0; i < alice.length; i++) {

            for (j = 0; j < integerList.size(); j++) {
                if (integerList.get(j) >= alice[i]) {
                    break;
                }
            }
            if (j != integerList.size() && integerList.get(j) == alice[i])
                result[k++] = integerList.size() - j;
            else
                result[k++] = integerList.size() - j + 1;
        }
/*
        for (int i=0;i<result.length;i++)
            System.out.println(result[i]);*/
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int scores[] = {100, 90, 90, 80, 75, 60};
        int alice[] = {50, 65, 77, 90, 102};

        int[] result = climbingLeaderboard(scores, alice);

    }
}

