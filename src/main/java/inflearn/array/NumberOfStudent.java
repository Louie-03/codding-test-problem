package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfStudent {

//    2. 보이는 학생 https://cote.inflearn.com/contest/10/problem/02-02
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        int maxHeight = ints[0];
        for (int i = 1; i < n; i++) {
            if (maxHeight < ints[i]) {
                count++;
                maxHeight = ints[i];
            }
        }
        System.out.println(count);
    }
}
