package inflearn.DP.동전교환;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    static int n, m;
    static int[] dy;

    static int solution(int[] coin) {
        Arrays.fill(dy, 501);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        m = kb.nextInt();
        dy = new int[m + 1];
        System.out.print(solution(arr));
    }
}
