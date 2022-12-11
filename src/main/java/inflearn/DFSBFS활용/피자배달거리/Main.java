package inflearn.DFSBFS활용.피자배달거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 피자 배달 거리
     유형 : DFS
     시간 복잡도 : O(?)
     난이도 : 조금 어려움
     시간 : 70m
     uri : https://cote.inflearn.com/contest/10/problem/08-14
     날짜 : 22.10.20
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73410?category=questionDetail
     */
    static int n;
    static int m;
    static int[][] ints;
    static boolean[][] booleans;
    static Stack<PizzaPosition> stack = new Stack<>();
    static int cityShortestDistance = Integer.MAX_VALUE;
    static List<HomePosition> homes = new ArrayList<>();
    static List<PizzaPosition> pizzas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        ints = new int[n][n];
        booleans = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    homes.add(new HomePosition(j, i, homes.size()));
                }
                if (num == 2) {
                    pizzas.add(new PizzaPosition(j, i));
                }
                ints[i][j] = num;
            }
        }

        for (PizzaPosition pizza : pizzas) {
            for (HomePosition home : homes) {
                pizza.addDistance(pizza.calculateDistance(home));
            }
//            System.out.println(pizza);
//            for (Integer distance : pizza.distances) {
//                System.out.print(distance + " ");
//            }
//            System.out.println();
        }

        dfs(0, 0);
        System.out.println(cityShortestDistance);
    }

    private static void dfs(int depth, int index) {
        if (depth == m) {
            int nowShortestDistance = 0;
            for (HomePosition home : homes) {
                int shortestDistance = Integer.MAX_VALUE;
                for (PizzaPosition pizza : stack) {
                    shortestDistance = Math.min(shortestDistance, pizza.distances.get(home.index));
                }
                nowShortestDistance += shortestDistance;
            }
            cityShortestDistance = Math.min(cityShortestDistance, nowShortestDistance);
            return;
        }

        for (int i = index; i < pizzas.size(); i++) {
            PizzaPosition pizza = pizzas.get(i);
            if (!booleans[pizza.y][pizza.x]) {
                booleans[pizza.y][pizza.x] = true;
                stack.push(pizza);
                dfs(depth + 1, i + 1);
                stack.pop();
                booleans[pizza.y][pizza.x] = false;
            }
        }
    }

    static abstract class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calculateDistance(Position position) {
            return Math.abs(x - position.x) + Math.abs(y - position.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static class HomePosition extends Position {
        int index;

        public HomePosition(int x, int y, int index) {
            super(x, y);
            this.index = index;
        }
    }

    static class PizzaPosition extends Position {
        List<Integer> distances = new ArrayList<>();

        public PizzaPosition(int x, int y) {
            super(x, y);
        }

        public void addDistance(Integer distance) {
            distances.add(distance);
        }
    }

    /*
    시간 복잡도 줄이기
    1. 같은 피자집의 조합이지만 순서만 다를 경우 순회하지 않는다.
    -> 실제로 구현하기 힘들 것 같음 & 이미 사용한 조합인지 확인하기 위한 로직 때문에 극적인 성능 변화가 없을 것 같다.

    2. 각 피자집마다 모든 집까지의 거리의 총합을 구한다.
    -> 구현했지만 시간 복잡도에 큰 변화는 없었다.

    3. 순열이 아닌 조합이니까 4 3 2 1... 이렇게 구하는 조합의 개수를 하나씩 줄여보자
    -> 입력값이 큰 경우에는 성능이 10배정도 좋아졌다

    10
    8
    12
    15
    10
    15

    2 0 11
    2 1 8
    1 2 10
    3 2 12
    0 3 16
    3 3 15

    2 0
    2 1
    3 3
     */
}
