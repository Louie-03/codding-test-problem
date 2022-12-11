package inflearn.스택큐.크레인인형뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /*
     문제 : 크레인 인형뽑기
     유형 : 스택
     시간 복잡도 : O(N^2)
     난이도 : 보통
     시간 : 50m
     uri : https://cote.inflearn.com/contest/10/problem/05-03
     날짜 : 22.10.10
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Stack<Integer>> board = Stream.generate(Stack<Integer>::new)
            .limit(n)
            .collect(Collectors.toList());
        StringTokenizer[] stringTokenizers = new StringTokenizer[n];
        for (int k = n - 1; k >= 0; k--) {
            stringTokenizers[k] = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(stringTokenizers[i].nextToken());
                if (num != 0) {
                    board.get(j).push(num);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = board.get(moves[i] - 1);
            if (!stack.isEmpty()) {
                bucket.push(stack.pop());
                if (bucket.size() != 1 && bucket.peek() == bucket.get(bucket.size() - 2)) {
                    bucket.pop();
                    bucket.pop();
                    count += 2;
                }
            }
        }
        System.out.println(count);
    }
}
