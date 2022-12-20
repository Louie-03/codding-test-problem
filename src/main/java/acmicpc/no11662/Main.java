package acmicpc.no11662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 민호와 강호
     유형 : 기하학
     시간 복잡도 : O(1)
     난이도 : 보통
     시간 : 30m
     uri : https://www.acmicpc.net/problem/11662
     날짜 : 22.12.20
     refer : https://log-laboratory.tistory.com/71
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double ax = Double.parseDouble(st.nextToken());
        double ay = Double.parseDouble(st.nextToken());
        double bx = Double.parseDouble(st.nextToken());
        double by = Double.parseDouble(st.nextToken());
        double cx = Double.parseDouble(st.nextToken());
        double cy = Double.parseDouble(st.nextToken());
        double dx = Double.parseDouble(st.nextToken());
        double dy = Double.parseDouble(st.nextToken());
        double answer = Double.MAX_VALUE;
        for (int i = 0; i <= 1000000; i++) {
            double x1 = ax + (bx - ax) / 1000000 * i;
            double y1 = ay + (by - ay) / 1000000 * i;
            double x2 = cx + (dx - cx) / 1000000 * i;
            double y2 = cy + (dy - cy) / 1000000 * i;
            double distance = getDistance(x1, y1, x2, y2);
            answer = Math.min(answer, distance);
        }
        System.out.println(answer);
    }

    private static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    /*
    0 0 2 2     2 2 3 3
    1 0 3 2 or 1 0 2 3 or 0 1 3 2 or 0 1 2 3
    1 1 3 3

    0 0 1 0     1 1 0 1
    0 1 1 1 or 0 1 0 0 or 1 0 1 1 or 1 0 0 0

     0 1
   0 a c
   1 d b

       5 7 10     20
    2    c
    5  a

    10     b
    30            d

       0 5 10   20     30
    0  a               c

    10   d

    20     b

    30

     */
}
