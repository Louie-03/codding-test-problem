package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ScoreCalculator {

    //    7. 점수계산 https://cote.inflearn.com/contest/10/problem/02-07
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) { // O(N)
            if (Integer.parseInt(st.nextToken()) == 1) {
                count++;
                sum += count;
                continue;
            }
            count = 0;
        }
        System.out.println(sum);
    }
}
