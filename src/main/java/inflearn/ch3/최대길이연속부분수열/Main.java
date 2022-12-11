package inflearn.ch3.최대길이연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int start;
    static int end;
    static int maxLength;
    static int n;
    static int k;
    static int[] ints;

//    6. 최대 길이 연속부분수열 https://cote.inflearn.com/contest/10/problem/03-06
//    투포인터
//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        while (end < n) {
            if (isGood()) {
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                start++;
                if (start > end) {
                    end = start;
                }
            }
        }
        System.out.println(maxLength);
    }

    private static boolean isGood() {
        int zeroCount = 0;
        for (int i = start; i <= end; i++) {
            if (ints[i] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount > k) {
            return false;
        }
        return true;
    }
}
