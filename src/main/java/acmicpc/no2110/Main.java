package acmicpc.no2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 공유기 설치
     유형 : 이분탐색
     시간 복잡도 : O(NlogN)
     난이도 : 보통
     시간 : 30m
     uri : https://www.acmicpc.net/problem/2110
     날짜 : 22.12.19
     refer : https://st-lab.tistory.com/277
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int answer = Integer.MIN_VALUE;
        int start = 1;
        int end = list.get(list.size() - 1) - list.get(0);
        while (start <= end) {
            int index = (start + end) / 2;
            int count = 1;
            int sum = 0;
            for (int i = 1; i < list.size(); i++) {
                sum += list.get(i) - list.get(i - 1);
                if (sum >= index) {
                    sum = 0;
                    count++;
                }
            }
            if (count >= c) {
                answer = Math.max(answer, index);
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        System.out.println(answer);
    }
}
