package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1074 {

    static int r;
    static int c;
    static boolean check = false;
    static int[][] ints = {{0, 0}, {1, 0}, {-1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(a(n, 0, 0, 0));
    }

    private static int a(int n, int x, int y, int count) {
        if (n == 1) {
            if (x <= c && c <= x + 1 && y <= r && r <= y + 1) {
                for (int[] anInt : ints) {
                    x += anInt[0];
                    y += anInt[1];
                    if (x == c && y == r) {
                        check = true;
                        return count;
                    }
                    count++;
                }
                return count;
            } else {
                return count + 4;
            }
        } else {
            int pow = (int) Math.pow(2, n) / 2;
            int pow2 = (int) Math.pow(pow, 2);

            if (r < y + pow && c < x + pow) {
                count = a(n - 1, x, y, count);
                if (check) {
                    return count;
                }
            }
            count += pow2;

            if (pow + x <= c && r < pow + y) {
                count = a(n - 1, pow + x, y, count);
                if (check) {
                    return count;
                }
            }
            count += pow2;

            if (c < pow + x && r >= pow + y) {
                count = a(n - 1, x, pow + y, count);
                if (check) {
                    return count;
                }
            }
            count += pow2;

            if (c >= pow + x && r >= pow + y) {
                count = a(n - 1, pow + x, pow + y, count);
                if (check) {
                   return count;
                }
            }
            count += pow2;
        }
        return count;
    }
}
