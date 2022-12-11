package programmers.배달;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    /*
     문제 : 배달
     유형 : 다익스트라 알고리즘
     시간 복잡도 : O(ElogV)
     난이도 : 보통
     시간 : 50m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/12978
     날짜 : 22.11.3
     refer :
     */
    public int solution(int N, int[][] road, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Position>> roadMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            roadMap.put(i, new ArrayList<>());
            map.put(i, Integer.MAX_VALUE);
        }
        for (int[] ints : road) {
            roadMap.get(ints[0]).add(new Position(ints[1], ints[2]));
            roadMap.get(ints[1]).add(new Position(ints[0], ints[2]));
        }
        PriorityQueue<Position> queue = new PriorityQueue<>();
        boolean[] booleans = new boolean[N + 1];
        booleans[1] = true;
        map.put(1, 0);
        queue.addAll(roadMap.get(1));
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int destination = position.destination;
            if (!booleans[destination]) {
                booleans[destination] = true;
                map.put(destination, position.cost);
                for (Position position1 : roadMap.get(destination)) {
                    int cost = position.cost + position1.cost;
                    if (!booleans[position1.destination] && map.get(position1.destination) > cost) {
                        queue.add(new Position(position1.destination, cost));
                    }
                }
            }
        }
        int answer = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) <= K) {
                answer++;
            }
        }
        return answer;
    }

    static class Position implements Comparable<Position> {
        int destination;
        int cost;

        public Position(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return cost - o.cost;
        }
    }
}
