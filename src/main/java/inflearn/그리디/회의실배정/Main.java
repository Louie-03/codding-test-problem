package inflearn.그리디.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 회의실 배정
     유형 : 그리디, 활동 선택 문제
     시간 복잡도 : O(N)
     난이도 : 조금 어려움
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/09-02
     날짜 : 22.10.24
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72758?tab=curriculum&category=questionDetail
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Meeting(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list, Collections.reverseOrder());
        int count = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            Meeting meeting = list.get(i);
            if (meeting.start >= time) {
                count++;
                time = meeting.end;
            }
        }
        System.out.println(count);
    }

    static class Meeting implements Comparable {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            Meeting meeting = (Meeting) o;
            if (end < meeting.end) {
                return 1;
            }
            if (end > meeting.end) {
                return -1;
            }
            if (start < meeting.start) {
                return 1;
            }
            if (start > meeting.start) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
        }
    }
}
