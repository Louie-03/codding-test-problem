package inflearn.ch3.두배열합치기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

//    1. 두 배열 합치기 https://cote.inflearn.com/contest/10/problem/03-01
//    투포인터
//    O(N) : 투포인터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n1 = Integer.parseInt(br.readLine());
        int[] ints1 = new int[n1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n1; i++) {
            ints1[i] = Integer.parseInt(st.nextToken());
        }

        int n2 = Integer.parseInt(br.readLine());
        int[] ints2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n2; i++) {
            ints2[i] = Integer.parseInt(st.nextToken());
        }

        int pointer1 = 0;
        int pointer2 = 0;
        for (int i = 0; i < n1 + n2; i++) {
            if (pointer1 == n1) {
                bw.write(ints2[pointer2++] + " ");
                continue;
            }
            if (pointer2 == n2) {
                bw.write(ints1[pointer1++] + " ");
                continue;
            }

            int num1 = ints1[pointer1];
            int num2 = ints2[pointer2];
            if (num1 < num2) {
                bw.write(num1 + " ");
                pointer1++;
            } else {
                bw.write(num2 + " ");
                pointer2++;
            }
        }
        bw.flush();
    }
}
