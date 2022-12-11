package acmicpc.no7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 덩치
     유형 : BFS
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/7568
     날짜 : 22.11.21
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for (Person person : list) {
            int rank = 1;
            for (Person person1 : list) {
                if (person.height < person1.height && person.weight < person1.weight) {
                    rank++;
                }
            }
            sb.append(rank + " ");
        }
        System.out.println(sb);
    }

    static class Person {

        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

    }
}
