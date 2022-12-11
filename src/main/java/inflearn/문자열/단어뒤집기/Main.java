package inflearn.문자열.단어뒤집기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

//    4. 단어 뒤집기 https://cote.inflearn.com/contest/10/problem/01-04
//    문자열
//    O(NM) M = StringBuilder.reverse의 시간 복잡도
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(new StringBuilder(br.readLine()).reverse() + "\n");
        }
        bw.flush();
    }
}
