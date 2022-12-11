package acmicpc.no15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    /*
    문제 : 치킨 배달
    유형 : DFS,
    시간 복잡도 : O((nCr)N M)
    난이도 : 조금 쉬움
    시간 : 40m
    uri : https://www.acmicpc.net/problem/15686
    날짜 : 22.11.21
    refer :
    */
    static int n;
    static int m;
    static List<Position> houses = new ArrayList<>();
    static List<Store> stores = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    houses.add(new Position(i, j));
                }
                if (num == 2) {
                    stores.add(new Store(i, j));
                }
            }
        }
        for (Position house : houses) {
            for (Store store : stores) {
                store.addHouseDistance(calculateDistance(house, store));
            }
        }
        System.out.println(dfs(0, new Stack<>()));
    }

    private static int dfs(int index, Stack<Store> stack) {
        if (stack.size() == m) {
            int cityDistance = 0;
            for (int i = 0; i < houses.size(); i++) {
                int minDistance = Integer.MAX_VALUE;
                for (Store store : stack) {
                    minDistance = Math.min(minDistance, store.houseDistances.get(i));
                }
                cityDistance += minDistance;
            }
            return cityDistance;
        }
        int cityDistance = Integer.MAX_VALUE;
        for (int i = index; i < stores.size(); i++) {
            stack.push(stores.get(i));
            cityDistance = Math.min(cityDistance, dfs(i + 1, stack));
            stack.pop();
        }
        return cityDistance;
    }

    private static int calculateDistance(Position house, Store store) {
        return Math.abs(store.x - house.x) + Math.abs(store.y - house.y);
    }
    /*
    치킨집이 각 집에 걸리는 거리를 보관
    m개의 치킨집의 조합으로 도시의 치킨 거리를 구함
        이때 치킨집들마다 각 집에 걸리는 거리의 최소값을 구하여 더하면 된다.
     */

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + " " + x;
        }

    }

    static class Store extends Position {

        List<Integer> houseDistances = new ArrayList<>();

        public Store(int y, int x) {
            super(y, x);
        }

        public void addHouseDistance(int houseDistance) {
            houseDistances.add(houseDistance);
        }

    }
}
