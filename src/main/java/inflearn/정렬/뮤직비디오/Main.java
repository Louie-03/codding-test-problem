package inflearn.정렬.뮤직비디오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 뮤직비디오(결정알고리즘)
     유형 : 이분탐색
     시간 복잡도 : O(N Log N)
     난이도 : 보통
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/06-09
     날짜 : 22.10.26
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72762?category=questionDetail&tab=community&q=335601
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        int[] ints = new int[n];
        int sum = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ints[i] = num;
            sum += num;
            max = Math.max(max, num);
        }
        int answer = 0;
        int start = max;
        int end = sum;
        int num;
        while (start <= end) {
            num = (start + end) / 2;
            int answersSum = 0;
            int index = 0;
            int i;
            for (i = 0; i < n; i++) {
                int anInt = ints[i];
                if (answersSum + anInt > num) {
                    index++;
                    answersSum = anInt;
                } else {
                    answersSum += anInt;
                }
            }
            if (index < m) {
                answer = num;
                end = num - 1;
            } else {
                start = num + 1;
            }
        }
        System.out.println(answer);
    }
}
