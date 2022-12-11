package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No11729 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getCount(N));
        a(N, 1, 3);
        bw.flush();
    }

    private static int  getCount(int n) {
        if (n == 1) {
            return 1;
        } else {
            return getCount(n - 1) * 2 + 1;
        }
    }

    private static void a(int n, int start, int to) throws IOException {
        if (n == 1) {
            bw.write(start + " " + to + "\n");
        } else {
            a(n - 1, start, 6 - start - to);
            bw.write(start + " " + to + "\n");
            a(n - 1, 6 - start - to, to);
        }
    }

}
