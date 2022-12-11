package inflearn.정렬.중복확인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 중복 확인
     유형 : ?
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 3m
     uri : https://cote.inflearn.com/contest/10/problem/06-05
     날짜 : 22.10.24
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72758?tab=curriculum&category=questionDetail
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        if (set.size() == n) {
            System.out.println("U");
        } else {
            System.out.println("D");
        }
    }
}
