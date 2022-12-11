package inflearn.DFSBFS활용.수열추측하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class Main {

    /*
     문제 : 수열 추측하기
     유형 : DFS
     시간 복잡도 : O(N!)
     난이도 : 조금 어려움
     시간 : 70m
     uri : https://cote.inflearn.com/contest/10/problem/08-08
     날짜 : 22.10.18
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73403?category=questionDetail
     */
    static int n;
    static int m;
    static boolean[] check;
    static int[] ints;
    static Stack<Integer> stack = new Stack<>();
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        check = new boolean[n + 1];
        ints = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = nCr(n - 1, i - 1);
        }
        dfs(0, 0);
    }

    private static void dfs(int count, int sum) {
        if (flag) {
            return;
        }
        if (count == n) {
            if (sum == m) {
                flag = true;
                for (Integer integer : stack) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
//            if (a(count - 1, new LinkedList<>(stack))) {
//                flag = true;
//                for (Integer integer : stack) {
//                    System.out.print(integer + " ");
//                }
//                System.out.println();
//            }
        }
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                stack.push(i);
//                System.out.println(count + "\t" + sum + "\t" + (sum + ints[i] * i) + "\t" + i);
                dfs(count + 1, sum + ints[count + 1] * i);
                stack.pop();
                check[i] = false;
            }
        }
    }

    private static boolean a(int count, Queue<Integer> queue) {
        Integer integer = queue.poll();
        for (int i = 0; i < count; i++) {
            Integer pop = queue.poll();
            queue.add(integer + pop);
            integer = pop;
        }
        if (count == 1) {
            return queue.poll() == m;
        }
        return a(count - 1, queue);
    }

    private static int nCr(int n, int r) {
        if (n == r || r == 1) {
            return n / r;
        }
        if (r == 0) {
            return 1;
        }
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
    /*
    1 2 3 4
    1 2 4 3
    1 3 2 4
    1 3 4 2
    1 4 2 3
    1 4 3 2

    3 5 7
     3
     */

//    16
//    4 : 1
//    3 : 2
//    2 : 3
//    4 : 4
    /*
    8
    2 6 / 3 5 / 4 4 / 5 3 / 6 2
    1 2

    1 1 1 1 2^0 = 2^n - 1 - x
    2 2 2   2^1 = 2^n - 1 - x
     4 4    2^2 = 2^(n - 1 - x)
      8     2^3 = 2^n - 1 - x

     1 1 1 9
      2 2 10
       4 12
        6

    a   b   c   d
     a+b b+c c+d
     a+2b+c b+2c+d
      a+3b+3c+d

            1331
    1234    1694    20
    2134    18
    2143    20
    2314    22
    2341    24
    2413    20
    2431    24
    3124
    3142
     */
}
