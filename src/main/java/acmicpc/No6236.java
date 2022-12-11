package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ints = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            ints[i] = num;
            if (num > max) {
                max = num;
            }
        }

        int start = 1;
        int end = max * M;
        int n = (int) (Math.log(end) / Math.log(2));
        int money = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int x = (start + end) / 2;
            int count = 0;
            int nowMoney = 0;
            boolean check = true;
            for (int anInt : ints) {
                if (anInt > x) {
                    check = false;
                    break;
                }
                if (nowMoney < anInt) {
                    count++;
                    nowMoney = x;
                }
                nowMoney -= anInt;
            }
            if (check && count <= N && money > x) {
                money = x;
                end = x - 1;
            } else {
                start = x + 1;
            }
        }
        System.out.println(money);
    }
}
