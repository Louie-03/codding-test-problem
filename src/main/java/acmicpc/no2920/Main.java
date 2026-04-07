package acmicpc.no2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[8];
        for (int i = 0; i < 8; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for (int i = 1; i <= 8; i++) {
            if (ints[i - 1] != i) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("ascending");
            return;
        }

        flag = true;
        for (int i = 8; i >= 1; i--) {
            if (ints[8 - i] != i) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("descending");
            return;
        }

        System.out.println("mixed");

    }

}
