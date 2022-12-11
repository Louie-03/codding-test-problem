package inflearn.DFSBFS활용.조합의경우수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /*
     문제 : 조합의 경우수(메모이제이션)
     유형 : DFS
     시간 복잡도 : ?
     난이도 : 보통
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/08-07
     날짜 : 22.10.18
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73402?category=questionDetail&tab=community
     */
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }
        System.out.println(recursion(n, m));
    }

    private static int recursion(int n, int m) {
        if (m == 1 || n == m) {
            return n / m;
        }
        if (map.get(n).containsKey(m)) {
            return map.get(n).get(m);
        }
        int num = recursion(n - 1, m - 1) + recursion(n - 1, m);
        map.get(n).put(m, num);
        return num;
    }

    /*
    3 2
    1 2
    1 3
    2 3

    2 1 / 2 2
    2 1
    1 2 : 2
    1 2 : 1
     */
}
