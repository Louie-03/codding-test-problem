package inflearn.정렬.이분검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 이분검색
     유형 : 이분탐색
     시간 복잡도 : O(N Log N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://cote.inflearn.com/contest/10/problem/06-08
     날짜 : 22.10.26
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72761?category=questionDetail&tab=curriculum
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        int[] ints = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints);

        int start = 0;
        int end = n - 1;
        int index = n / 2;
        while (start <= end) {
            int num = ints[index];
            if (num == m) {
                break;
            }
            if (num > m) {
                end = index - 1;
            }
            if (num < m) {
                start = index + 1;
            }
            index = (start + end) / 2;
        }
        System.out.println(index + 1);
    }

    /*
    1 ~ 9
    2
    0 4
    2

    1 ~ 10
    1

9 1
1 2 3 4 5 6 7 8 9
     */
}
