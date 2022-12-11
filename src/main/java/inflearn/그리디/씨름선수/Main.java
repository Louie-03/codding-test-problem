package inflearn.그리디.씨름선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 씨름 선수
     유형 : 그리디
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/09-01
     날짜 : 22.10.20
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73412?category=questionDetail&tab=curriculum&q=491021
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            players.add(new Player(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }
        Collections.sort(players, Collections.reverseOrder());
        int count = 1;
        int maxWeight = players.get(0).weight;
        for (int i = 1; i < n; i++) {
            Player player = players.get(i);
            maxWeight = Math.max(maxWeight, player.weight);
            if (player.isNotGreaterWeight(maxWeight)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static class Player implements Comparable {
        int height;
        int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public boolean isNotGreaterWeight(int weight) {
            return this.weight >= weight;
        }

        @Override
        public int compareTo(Object o) {
            Player target = (Player) o;
            if (height > target.height) {
                return 1;
            }
            if (height < target.height) {
                return -1;
            }
            return 0;
        }
    }
}
