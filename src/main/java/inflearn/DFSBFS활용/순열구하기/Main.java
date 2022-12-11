package inflearn.DFSBFS활용.순열구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 순열 구하기
     유형 : DFS
     시간 복잡도 : O(N^M)
     난이도 : 쉬움
     시간 : 30m
     uri :
     날짜 : 22.10.18
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73401?category=questionDetail&tab=community
     */
    static int n;
    static int m;
    static int[] ints;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
    }

    private static void dfs(int count) {
        if (count == m) {
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            int integer = ints[i];
            if (!check[i]) {
                check[i] = true;
                stack.push(integer);
                dfs(count + 1);
                stack.pop();
                check[i] = false;
            }
            i++;
        }
    }

}

// 3 2
// 3 6 9
//
