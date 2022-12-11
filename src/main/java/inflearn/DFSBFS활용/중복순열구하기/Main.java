package inflearn.DFSBFS활용.중복순열구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    /*
     문제 : 중복순열 구하기
     유형 : DFS
     시간 복잡도 : O(N^M)
     난이도 : 쉬움
     시간 : 30m
     uri :
     날짜 : 22.10.18
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73399?category=questionDetail&q=342582
     */
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);

        dfs(0, new Stack<>());
    }

    private static void dfs(int count, Stack<Integer> stack) {
        if (count == m) {
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            dfs(count + 1, stack);
            stack.pop();
        }
    }

    /*
    5 3
    1 1 1
    1 1 2
    1 1 3
    1 2 1
    1 2 2
    1 2 3
     */
}
