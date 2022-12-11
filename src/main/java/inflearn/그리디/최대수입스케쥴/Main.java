package inflearn.그리디.최대수입스케쥴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 최대 수입 스케쥴
     유형 : 그리디
     시간 복잡도 : O(N log N)
     난이도 : 조금 어려움
     시간 : 50m
     uri : https://cote.inflearn.com/contest/10/problem/09-04
     날짜 : 22.10.24
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73414?category=questionDetail&tab=community
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<LectureInfo> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new LectureInfo(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        PriorityQueue<LectureInfo> queue = new PriorityQueue<>((x, y) -> y.money - x.money);
        int maxDay = list.get(0).day;
        Queue<LectureInfo> queue2 = new LinkedList<>(list);
        int answer = 0;
        for (int i = maxDay; i >= 1; i--) {
            if (queue2.isEmpty() && queue.isEmpty()) {
                break;
            }
            int count2 = 0;
            for (LectureInfo lectureInfo : queue2) {
                if (lectureInfo.day != i) {
                    break;
                }
                count2++;
            }

            for (int j = 0; j < count2; j++) {
                queue.add(queue2.poll());
            }
            if (!queue.isEmpty()) {
                answer += queue.poll().money;
            }
        }
        System.out.println(answer);
    }

    static class LectureInfo implements Comparable {

        int money;
        int day;

        public LectureInfo(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Object o) {
            return ((LectureInfo) o).day - day;
        }

        @Override
        public String toString() {
            return "LectureInfo{" +
                "money=" + money +
                ", day=" + day +
                '}';
        }
    }

    /* 10 8    7   6   5  4  3  2  1
       68 72   48  15  13 11    41 34
     */
}
