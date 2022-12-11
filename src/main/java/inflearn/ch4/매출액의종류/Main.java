package inflearn.ch4.매출액의종류;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

//    3. 매출액의 종류 https://cote.inflearn.com/contest/10/problem/04-03
//    슬라이딩 윈도우
//    O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int num = ints[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        bw.write(map.size() + " ");

        for (int i = 1; i <= n - k; i++) {
            int num1 = ints[i - 1];
            int num2 = ints[i + k - 1];
            Integer value1 = map.getOrDefault(num1, 0);
            if (value1 <= 1) {
                map.remove(num1);
            } else {
                map.put(num1, value1 - 1);
            }
            map.put(num2, map.getOrDefault(num2, 0) + 1);
            bw.write(map.size() + " ");
        }
        bw.flush();
    }
}
