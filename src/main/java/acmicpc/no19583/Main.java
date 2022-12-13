package acmicpc.no19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /*
     문제 : 싸이버개강총회
     유형 : 구현, 해시
     시간 복잡도 : O(N)
     난이도 : 조금 쉬움
     시간 : 45m
     uri : https://www.acmicpc.net/problem/19583
     날짜 : 22.12.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        LocalTime S = toLocalTime(strings[0]);
        LocalTime E = toLocalTime(strings[1]);
        LocalTime Q = toLocalTime(strings[2]);

        Map<String, List<LocalTime>> map = new HashMap<>();
        Map<String, boolean[]> checkMap = new HashMap<>();
        String str;
        while ((str = br.readLine()) != null) {
            String[] split = str.split(" ");
            String name = split[1];
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
                checkMap.put(name, new boolean[2]);
            }
            LocalTime localTime = toLocalTime(split[0]);
            map.get(name).add(localTime);
        }

        for (String name : map.keySet()) {
            for (LocalTime localTime : map.get(name)) {
                if (localTime.isBefore(S) || localTime.equals(S)) {
                    checkMap.get(name)[0] = true;
                }
                if (localTime.equals(E) || localTime.equals(Q) ||
                    (localTime.isAfter(E) && localTime.isBefore(Q))) {
                    checkMap.get(name)[1] = true;
                }
            }
        }

        int count = 0;
        for (String name : checkMap.keySet()) {
            boolean[] booleans = checkMap.get(name);
            if (booleans[0] && booleans[1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static LocalTime toLocalTime(String str) {
        String[] strings = str.split(":");
        int hour = Integer.parseInt(strings[0]);
        int minute = Integer.parseInt(strings[1]);
        return LocalTime.of(hour, minute);
    }
}
