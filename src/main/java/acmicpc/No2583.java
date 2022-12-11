package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2583 {

    /*
     문제 : 영역 구하기
     유형 :
     시간 복잡도 : O(N * M)
     난이도 : 보통
     시간 : 30m
     uri : https://www.acmicpc.net/problem/2583
     날짜 : 22.10.25
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] booleans = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int l = m - y2; l < m - y1; l++) {
                    booleans[l][j] = true;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!booleans[i][j]) {
                    Queue<Position> queue = new LinkedList<>();
                    queue.add(new Position(j, i));
                    booleans[i][j] = true;
                    int size = 1;
                    while (!queue.isEmpty()) {
                        Position position = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int x = position.x + dx[l];
                            int y = position.y + dy[l];
                            if (0 <= x && x < n && 0 <= y && y < m && !booleans[y][x]) {
                                queue.add(new Position(x, y));
                                booleans[y][x] = true;
                                size++;
                            }
                        }
                    }
                    list.add(size);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
    m = 세로 길이
    n = 가로 길이
    k = 직사각형 개수
    첫번째 좌표 : 직사각형의 왼쪽 아래 꼭짓점
    두번째 좌표 : 직사각형의 오른쪽 위 꼭짓점
    여기서 좌표는 맨 왼쪽 아래가 (0, 0)이다.
    앞의 좌표가 가로 위치를 나타내고
    뒤의 좌표가 세로 위치를 나타낸다.
    x  y
    0, 2
    4, 4
    0  1~2
    3  1~2
    원래 2~3

     */
}
