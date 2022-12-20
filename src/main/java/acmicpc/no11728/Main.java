package acmicpc.no11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 배열 합치기
     유형 : 분할정복
     시간 복잡도 : O(NlogN)
     난이도 : 매우 쉬움(S5)
     시간 : 5m
     uri : https://www.acmicpc.net/problem/11728
     날짜 : 22.12.20
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
