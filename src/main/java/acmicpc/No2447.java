package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class No2447 {

    static char[][] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        chars = new char[num][num];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '*');
        }
        a(num, 0, 0);
        for (char[] aChar : chars) {
            for (char c : aChar) {
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static void a(int n, int x, int y) {
        if (n == 1) {
            return;
        }
        int n1 = n / 3;
        for (int i = x; i < x + n; i += n1) {
            for (int j = y; j < y + n; j += n1) {
                if (i == x + n1 && j == y + n1) {
                    clear(n1, i, j);
                } else {
                    a(n1, i, j);
                }
            }
        }
    }

    private static void clear(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                chars[i][j] = ' ';
            }
        }
    }
}
