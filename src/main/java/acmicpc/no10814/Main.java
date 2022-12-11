package acmicpc.no10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 나이순 정렬
     유형 : 정렬
     시간 복잡도 : O(NlogN)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://www.acmicpc.net/problem/10814
     날짜 : 22.11.7
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(list);
        for (Member member : list) {
            sb.append(member + "\n");
        }
        System.out.println(sb);
    }

    static class Member implements Comparable<Member> {
        int id;
        int age;
        String name;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (age == o.age) {
                return id - o.id;
            }
            return age - o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
