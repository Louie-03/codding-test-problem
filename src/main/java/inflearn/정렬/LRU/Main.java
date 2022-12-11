package inflearn.정렬.LRU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : LRU
     유형 : ?
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/06-04
     날짜 : 22.10.24
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72757?tab=curriculum
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            Integer num = Integer.valueOf(st.nextToken());
            if (set.contains(num)) {
                set.remove(num);
            } else if (set.size() == s) {
                set.remove(set.toArray()[0]);
            }
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        if (set.size() != s) {
            for (int i = 0; i < s - set.size(); i++) {
                System.out.print("0 ");
            }
        }
    }

}
