package inflearn.ch4.K번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

//    5. K번째 큰 수 https://cote.inflearn.com/contest/10/problem/04-05
//    O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][][] booleans = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (i == j || j == l || i == l || booleans[i][j][l]) {
                        break;
                    }
                    booleans[i][j][l] = booleans[j][i][l] = booleans[j][l][i]
                        = booleans[i][l][j] = booleans[l][i][j] = booleans[l][j][i]
                        = true;
                    int sum = ints[i] + ints[j] + ints[l];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        Integer[] list = map.keySet().toArray(new Integer[map.keySet().size()]);
        if (list.length < k) {
            System.out.println(-1);
        } else {
            System.out.println(list[k - 1]);
        }
    }
}
