package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EratosthenesSieve {

//    5. 에라토스테네스 체 https://cote.inflearn.com/contest/10/problem/02-05
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        boolean[] booleans = new boolean[n + 1];
        Arrays.fill(booleans, true);
        for (int i = 2; i <= n; i++) {
            if (booleans[i]) {
                count++;
                for (int j = i * 2; j <= n; j += i) {
                    booleans[j] = false;
                }
            }
        }
        System.out.println(count);
    }
}
