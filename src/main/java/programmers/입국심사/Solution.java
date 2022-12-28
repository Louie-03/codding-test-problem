package programmers.입국심사;

public class Solution {

    /*
     문제 : 입국심사
     유형 : 이분탐색
     시간 복잡도 : O(NlogN)
     난이도 : 매우 쉬움
     시간 : 40m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/43238
     날짜 : 22.12.28
     refer :
     */

    public long solution(int n, int[] times) {
        long max = getMax(times);
        long start = 0;
        long end = n * max / times.length;
        while (start <= end) {
            long num = (start + end) / 2;
            long count = 0;
            for (int time : times) {
                count += num / time;
            }
            if (n <= count) {
                end = num - 1;
            } else {
                start = num + 1;
            }
        }
        return start;
    }

    private static long getMax(int[] times) {
        long max = 0;
        for (int time : times) {
            max = Math.max(time, max);
        }
        return max;
    }

    // O(answer * 심사관의 수)
    // O((10억(n) * 10만(심사관의 수)) * 심사관의 수)
    // O(N)
    public long solution1(int n, int[] times) {
        long answer = 0;
        while (n != 0) {
            answer++;
            for (int time : times) {
                if (answer % time == 0) {
                    n--;
                }
            }
        }
        return answer;
    }

    /*      a   b
    7   1   7   10
    10  2   14  20
    14  3   21  30
    20  4   28
    21  5
    28  6

    심사관이 1명인데 심사하는데 10억분이 걸리고 기다리는 사람은 10억명이면
    10억 * 10억

    최대 answer 값 = n * 최대 심사 시간 / 심사원 수
     */
}
