package inflearn.ch3.공통원소구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

//    2. 공통원소 구하기 https://cote.inflearn.com/contest/10/problem/03-02
//    투포인터
//    O(N^2) Arrays.sort
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

        Arrays.sort(ints1);
        Arrays.sort(ints2);
        int pointer1 = 0;
        int pointer2 = 0;
        while (n1 != pointer1 && n2 != pointer2) {
            int num1 = ints1[pointer1];
            int num2 = ints2[pointer2];
            if (num1 == num2) {
                bw.write(num1 + " ");
                pointer1++;
                pointer2++;
            } else if (num1 > num2) {
                pointer2++;
            } else if (num2 > num1) {
                pointer1++;
            }
        }
        bw.flush();
    }
}
