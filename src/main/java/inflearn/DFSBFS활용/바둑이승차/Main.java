package inflearn.DFSBFS활용.바둑이승차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 바둑이 승차(DFS)
     유형 : DFS
     시간 복잡도 : O(2^N)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://cote.inflearn.com/contest/10/problem/08-02
     날짜 : 22.10.17
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73397?tab=curriculum&category=questionDetail
     */
    static int c;
    static int n;
    static int[] ints;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        c = Integer.parseInt(strings[0]);
        n = Integer.parseInt(strings[1]);

        ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        dfs(-1, 0, false);
        System.out.println(max);
    }

    private static void dfs(int num, int sum, boolean check) {
        if (num == n) {
            return;
        }
        if (check) {
            sum += ints[num];
            if (max < sum && sum <= c) {
                max = sum;
            }
        }
        dfs(num + 1, sum, true);
        dfs(num + 1, sum, false);
    }
}
