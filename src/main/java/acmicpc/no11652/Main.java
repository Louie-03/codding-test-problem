package acmicpc.no11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
     문제 : 카드
     유형 : 정렬, 해시
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/11652
     날짜 : 22.12.10
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long answer = 0;
        int maxCount = 0;
        for (Long aLong : map.keySet()) {
            Integer count = map.get(aLong);
            if (maxCount == count) {
                answer = Math.min(answer, aLong);
            }
            if (maxCount < count) {
                answer = aLong;
                maxCount = count;
            }
        }
        System.out.println(answer);
    }
}
