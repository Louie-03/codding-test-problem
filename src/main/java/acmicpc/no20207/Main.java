package acmicpc.no20207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ints[i][0] = Integer.parseInt(st.nextToken());
            ints[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] counts = new int[366];
        for (int[] anInt : ints) {
            for (int i = anInt[0]; i <= anInt[1]; i++) {
                counts[i]++;
            }
        }

        int answer = 0;
        int continueCount = 0;
        int depth = 0;
        for (int i = 0; i < 366; i++) {
            if (counts[i] > 0) {
                continueCount++;
            }
            if (counts[i] > depth) {
                depth = counts[i];
            }

            if (counts[i] == 0) {
                answer += continueCount * depth;
                continueCount = 0;
                depth = 0;
            }
        }

        if (counts[365] != 0) {
            answer += continueCount * depth;
        }

        System.out.println(answer);

    }

}
