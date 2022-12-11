package inflearn.재귀트리그래프.송아지찾기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
     문제 : 송아지 찾기 1
     유형 : BFS
     시간 복잡도 : ?
     난이도 : 조금 어려움
     시간 : 50m
     uri : https://cote.inflearn.com/contest/10/problem/07-08
     날짜 : 22.10.15
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72774
     */

//    최대 2000^3 = 8000000000 80억
//    depth 직접 정의, 이미 방문한 숫자는 재실행하지 않도록 구현해서 시간복잡도 개선
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int s = Integer.parseInt(strings[0]);
        int e = Integer.parseInt(strings[1]);

        if (s >= e) {
            System.out.println(s - e);
        } else {
            int subtract = e - s;
            int depth = subtract / 5 - 1;
            int value = depth * 5 + s;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(value);
            int L = depth;
            boolean[] booleans = new boolean[10001];
            booleans[value] = true;
            int[] ints = {1, -1, 5};

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    value = queue.poll();
                    if (value == e) {
                        System.out.println(L);
                        return;
                    }
                    for (int anInt : ints) {
                        int childValue = value + anInt;
                        if (!booleans[childValue] && 1 <= childValue && childValue <= 10000) {
                            queue.add(childValue);
                        }
                    }
                }
                L++;
            }
        }
    }

}
