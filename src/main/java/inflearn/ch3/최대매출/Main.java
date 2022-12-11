package inflearn.ch3.최대매출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//    3. 최대 매출 https://cote.inflearn.com/contest/10/problem/03-03
//    슬라이딩 윈도우
//    O(N) 슬라이딩 윈도우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int amount = 0;
        for (int i = 0; i < range; i++) {
            amount += ints[i];
        }
        int maxAmount = amount;
        for (int i = 1; i <= n - range; i++) {
            amount += ints[i + range - 1] - ints[i - 1];
            if (amount > maxAmount) {
                maxAmount = amount;
            }
        }
        System.out.println(maxAmount);
    }
}
