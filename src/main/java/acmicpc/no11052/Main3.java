package acmicpc.no11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int anInt : ints) {
            map.put(anInt, new ArrayList<>());
        }
        map.get(1).add(ints[0]);
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) { //(0,0), (1,0), (0,1)
//                map.put(ints[i])
            }
        }
    }
}
