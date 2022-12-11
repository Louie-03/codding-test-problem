package inflearn.스택큐.응급실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 응급실
     유형 : 큐
     시간 복잡도 : O(N^3)
     난이도 : 보통
     시간 : 35m
     uri : https://cote.inflearn.com/contest/10/problem/05-08
     날짜 : 22.10.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        Integer n = Integer.valueOf(strings[0]);
        Integer k = Integer.valueOf(strings[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        while (true) {
            Integer peek = queue.peek();
            boolean check = true;
            for (Integer integer : queue) {
                if (peek < integer) {
                    check = false;
                }
            }
            if (check) {
                count++;
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            if (k == 0) {
                if (check) {
                    break;
                } else {
                    k = queue.size() - 1;
                }
            } else {
                k--;
            }
        }
        System.out.println(count);
    }

    /*
    60 50 70 80 90
    50 70 80 90 60
    70 80 90 60 50
    80 90 60 50 70
    90 60 50 70 80
    60 50 70 80
    80 60 50 70
    60 50 70
    70 60 50
    60 50
    50
     */
}
