package inflearn.DFSBFS활용.최대점수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 최대점수 구하기(DFS)
     유형 : DFS
     시간 복잡도 : O(2^N)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://cote.inflearn.com/contest/10/problem/08-03
     날짜 : 22.10.17
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73398?tab=curriculum&category=questionDetail
     */
    static int n;
    static int maxTime;
    static int maxScore;
    static int[][] ints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        maxTime = Integer.parseInt(strings[1]);
        ints = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ints[i][0] = Integer.parseInt(st.nextToken());
            ints[i][1] = Integer.parseInt(st.nextToken());
        }

        bfs(0, 0, 0);
        System.out.println(maxScore);
    }

    private static void bfs(int num, int time, int score) {
        if (time > maxTime) {
            return;
        }
        if (num == n) {
            maxScore = Math.max(score, maxScore);
            return;
        }
        bfs(num + 1, time, score);
        bfs(num + 1, time + ints[num][1], score + ints[num][0]);
    }
}
