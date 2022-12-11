package inflearn.ch3.최대길이연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int maxSize = 0;
        int zeroCount = 0;
        for (int end = 0; end < n; end++) {
            if (ints[end] == 0) {
                zeroCount++;
            }
            while (k < zeroCount) {
                if (ints[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxSize = Math.max(maxSize, end - start + 1);
        }
        System.out.println(maxSize);
    }
}
