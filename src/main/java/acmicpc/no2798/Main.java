package acmicpc.no2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 블랙잭
     유형 : 브루트포스
     시간 복잡도 : O(N^3)
     난이도 : 쉬움
     시간 : 25m
     uri : https://www.acmicpc.net/problem/2798
     날짜 : 22.11.5
     refer : https://st-lab.tistory.com/97
     */
    static boolean[] check;
    static int[] ints;
    static int n;
    static int m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ints[i] = num;
            max = Math.max(num, max);
        }
        check = new boolean[max + 1];
        System.out.println(DFS(new Stack<>()));
    }

    private static int DFS(Stack<Integer> stack) {
        if (stack.size() == 3) {
            int sum = 0;
            for (Integer integer : stack) {
                sum += integer;
            }
            return sum > m ? 0 : sum;
        }
        int max = 0;
        for (int anInt : ints) {
            if (!check[anInt]) {
                check[anInt] = true;
                stack.push(anInt);
                max = Math.max(max, DFS(stack));
                stack.pop();
                check[anInt] = false;
            }
        }
        return max;
    }
}
