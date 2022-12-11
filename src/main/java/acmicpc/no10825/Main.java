package acmicpc.no10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 국영수
     유형 : 정렬
     시간 복잡도 : O(NLogN)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/10825
     날짜 : 22.12.10
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int[] scores = new int[3];
            for (int j = 0; j < 3; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
            students.add(new Student(name, scores));
        }
        Collections.sort(students);
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.name).append("\n");
        }
        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int[] scores;

        public Student(String name, int[] scores) {
            this.name = name;
            this.scores = scores;
        }

        @Override
        public int compareTo(Student o) {
            for (int i = 0; i < 3; i++) {
                if (scores[i] != o.scores[i]) {
                    if (i % 2 == 0) {
                        return o.scores[i] - scores[i];
                    }
                    return scores[i] - o.scores[i];
                }
            }
            return name.compareTo(o.name);
        }
    }
}
