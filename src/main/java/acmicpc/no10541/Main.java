package acmicpc.no10541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 순열 사이클
     유형 : 순열 사이클 분할
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/10451
     날짜 : 22.12.15
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {   // T
            Map<Integer, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) { // N
                map.put(j, Integer.parseInt(st.nextToken()));
            }
            int count = 0;
            for (int j = 1; j <= n; j++) { // N
                if (map.containsKey(j)) {
                    removeCycle(j, map);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void removeCycle(Integer num, Map<Integer, Integer> map) {
        while (num != null) {
            Integer temp = map.get(num);
            map.remove(num);
            num = temp;
        }
    }
    /*
    1 -> 3  2 -> 2  4 -> 8 -> 6
    |    |
    5 <- 7
     */
}
