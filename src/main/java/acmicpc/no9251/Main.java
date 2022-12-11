package acmicpc.no9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string1 = br.readLine();
        String string2 = br.readLine();
//        new boolean[string1.length() + 1][string2.length() + 1];
        int[][] ints = new int[string1.length() + 1][string2.length() + 1];
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    ints[i][j] = ints[i- 1][j - 1] + 1;
                } else {
                    ints[i][j] = Math.max(ints[i][j - 1], ints[i - 1][j]);
                }
            }
        }
//        for (int[] anInt : ints) {
//            for (int i : anInt) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
        System.out.println(ints[string1.length()][string2.length()]);
    }
    /*
      A C A Y K P
    C 0 1 1 1 1 1 int[y][x -1] + 1 할당, 동일하지 않다면 int[y][x - 1] 할당
    A 1 1 2 2 2 2
    P 1 1 2 2 2 3
    C 1 2 2 2 2 3
    A 1 2 3 3 3 3
    K 1 2 3 3 4 4

    CA A    1
    CA AC   1
    CA ACA  2

    CA AC + 1
    C ACA + 1

      C A Y C P
    C 1 1 1 1 1
    A 1 2 2 2 2
    P 1 2 2 2 3
    C 1 2 2 3 3

      0 0 0 0 0 0
    0 0 1 1 1 1 1
    0 1 1 2 2 2 2
    0 1 1 2 2 2 3
    0 1 2 2 2 2 3
    0 1 2 3 3 3 3
    0 1 2 3 3 4 4

    C   A
    C   AC
    C   ACA
    C   ACAY
    C   ACAYK
    C   ACAYKP

    CA   A
    CA   AC
    CA   ACA
    CA   ACAY
    CA   ACAYK
    CA   ACAYKP

    CAP   A
    CAP   AC
    CAP   ACA
    CAP   ACAY
    CAP   ACAYK
    CAP   ACAYKP
     */
}
