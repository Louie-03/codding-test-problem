package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int max = 1;
        boolean check = false;
        while (n != count) {
            for (int i = 1; i <= max; i++) {
                count++;
                if (count == n) {
                    if (check) {
                        System.out.println(i + "/" + (max - i + 1));
                    } else {
                        System.out.println((max - i + 1) + "/" + i);
                    }
                    break;
                }
            }
            check = check ? false : true;
            max++;
        }
    }
}
