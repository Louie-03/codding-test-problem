package acmicpc.no11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
    }
    /*
    268435.456 2.19274240
    49161216

    4
    1 5 6 7

    1   1   ints[1]
    5   2   max(DP[1] * 2, ints[2])
    6   3   max(DP[1] + DP[2], DP[1] * 3, ints[3])
    10  4   max(DP[1] + DP[3], DP[2] * 2, DP[1] * 2 + DP[2], DP[1] * 4, ints[4])
    11  5   max(DP[1] + DP[4], DP[2] + DP[3], DP[1] * 2 + DP[3], DP[2] * 2 + DP[1],
            DP[1] * 3 + DP[2], DP[1] * 5, ints[5])

    ints[1] + DP[2] or DP[1] + ints[2] or DP[1] + DP[2]     vs ints[3]

    ints[1] + DP[3] or DP[1] + ints[3] or DP[1] + DP[3]     vs ints[4]
    ints[2] + DP[2] or DP[2] + ints[2] or DP[2] + DP[2]

    arr[2] < arr[1] * 2라면 DP[2] = arr[1] * 2이고
    DP[3] = DP[2] + DP[1] = max(arr[2], arr[1] * 2) + arr[1](=DO[1]), arr[3]) 이므로
    arr[2] < arr[1] * 2라면 DP[3] = max(arr[1] * 3, arr[3])이 된다.
    결국 아래의 점화식은 자연스럽게 정답이 구해진다.
    점화식 : max(DP[n] + DP[n - j], arr[i])

      1 5   6   7
    1 2 6   7   8
    5 6 10  11  12
    6 7 11  12  13
    7 8 12  13  14

    4
    3 5 15 16

    3   1
    6   2
    15  3
    18  4
     */
}
