package inflearn.ch3.연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//    4. 연속 부분수열 https://cote.inflearn.com/contest/10/problem/03-04
//    투포인터
//    O(N)

//    m과 합이 같다면 합을 다시 계산하고 두 포인터의 값을 모두 1씩 증가시키면 된다.
//    큰 숫자가 나오면 총 합에서 맨 앞의 값을 빼고 start 포인터를 증가시키면 된다.
//    작은숫자가 나오면 end 포인터를 증가시키고 총 합에서 맨 끝의 값을 증가시키면 된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ints = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int sum = ints[0];
        int start = 0;
        int end = 0;
        int count = 0;
        while (start != n && end != n) {
            if (sum == m) {
                count++;
                sum -= ints[start++];

                if (end == n - 1) {
                    break;
                }
                sum += ints[++end];
            } else if (sum < m) {
                if (end == n - 1) {
                    break;
                }
                sum += ints[++end];
            } else {
                if (start == n - 1) {
                    break;
                }
                sum -= ints[start++];
            }
        }
        System.out.println(count);
    }
}
