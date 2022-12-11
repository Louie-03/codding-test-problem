package inflearn.정렬.좌표정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 좌표 정렬
     유형 : 정렬
     시간 복잡도 : O(N Log N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/06-07
     날짜 : 22.10.26
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72760?category=questionDetail&tab=community
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Position[] positions = new Position[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            positions[i] = new Position(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(positions);
        for (Position position : positions) {
            System.out.println(position);
        }
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if (x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
