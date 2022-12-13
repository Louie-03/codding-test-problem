package acmicpc.no6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
     문제 : 골드바흐의 추측
     유형 : 에라토스테네스의 체
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/6588
     날짜 : 22.12.13
     refer :
     */
    public static void main(String[] args) throws IOException {
        boolean[] booleans = new boolean[1000001];
        for (int i = 2; i <= Math.sqrt(1000001); i++) {
            for (int j = 2; i * j < booleans.length; j++) {
                booleans[i * j] = true;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < booleans.length; i++) {
            if (!booleans[i]) {
                list.add(i);
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str = br.readLine()).equals("0")) {
            int num = Integer.parseInt(str);
            boolean check = true;
            for (Integer integer : list) {
                if (integer > num - 2) {
                    break;
                }
                if (!booleans[num - integer]) {
                    check = false;
                    sb.append(num).append(" = ").append(integer)
                        .append(" + ").append(num - integer).append("\n");
                    break;
                }
            }
            if (check) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }
        System.out.println(sb);
    }
}
