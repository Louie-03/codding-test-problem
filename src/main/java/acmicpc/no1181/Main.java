package acmicpc.no1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    /*
     문제 : 단어 정렬
     유형 : 정렬
     시간 복잡도 : O(NlogN)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/1181
     날짜 : 22.11.6
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer, (a, b) -> {
            if (a.length() == b.length()) {
                for (int i = 0; i < a.length(); i++) {
                    char charA = a.charAt(i);
                    char charB = b.charAt(i);
                    if (charA != charB) {
                        return charA - charB;
                    }
                }
            }
            return a.length() - b.length();
        });
        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
