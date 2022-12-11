package acmicpc.no16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    문제 : 뱀과 사다리 게임
    유형 : BFS
    시간 복잡도 : O(
    난이도 : 조금 어려움
    시간 : 1h 40m
    uri : https://www.acmicpc.net/problem/16928
    날짜 : 22.11.22
    refer :
    */
    static int[] ladderAndSnake;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ladderAndSnake = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            ladderAndSnake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs());
        System.out.println(count);
    }

    static int bfs() {
        boolean[] check = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currentLocation = queue.poll();
                if (currentLocation == 100) {
                    return count;
                }
                for (int j = 1; j <= 6; j++) {
                    count++;
                    int nextLocation = currentLocation + j;
                    if (nextLocation > 100 || check[nextLocation]) {
                        continue;
                    }
                    if (ladderAndSnake[nextLocation] != 0) {
                        nextLocation = ladderAndSnake[nextLocation];
                    }
                    check[nextLocation] = true;
                    queue.add(nextLocation);
                }
            }
            count++;
        }
        throw new RuntimeException("경로를 찾을 수 없습니다.");
    }

/*
반례
2 1
30 100
2 50
51 29

1 2->50 51->29 30->100
    1     2       3
 */

}
