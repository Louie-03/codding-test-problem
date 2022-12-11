package inflearn.DFSBFS활용.합이같은부분집합DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 합이 같은 부분집합(DFS : 아마존 인터뷰)
     유형 : DFS
     시간 복잡도 : ?
     난이도 : 보통
     시간 : 50m
     uri : https://cote.inflearn.com/contest/10/problem/08-01
     날짜 : 22.10.17
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73396?tab=curriculum&category=questionDetail
     */

    static int[] ints;
    static int n;
    static boolean[] check;
    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ints = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dfs(1, i);
        }

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(int size, int index) {
        if (size >= n / 2 + 1) {
            return;
        }

        check[index] = true;
        for (int i = index + 1; i < n; i++) {
            dfs(size + 1, i);
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                a += ints[i];
            } else {
                b += ints[i];
            }
        }
        if (a == b) {
            result = true;
        }
        check[index] = false;
    }

    /*
    1개 : 1 3 5 6 7 10
    2개 : 1/3 1/5 1/6 1/7 1/10 3/5 3/6 3/7 3/10 5/6 5/7 5/10 6/7 6/10 7/10
    -> 자기랑 자기 뒤에꺼만 하나씩 묶으면 될듯
    3개 : 1/3/5 1/3/6 1/3/7 1/3/10 ...


     */
}
