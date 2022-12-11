package programmers.쿠키구입;

public class Solution {

    /*
     문제 : 쿠키구입
     유형 :
     시간 복잡도 : O(N^2)
     난이도 : 매우 어려움
     시간 : 1h 30m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/12987
     날짜 : 22.11.2
     refer : https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BF%A0%ED%82%A4%EA%B5%AC%EC%9E%85-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
     */
    public int solution(int[] cookie) {
        int answer = 0;
        for (int i = 0; i < cookie.length - 1; i++) {
            int leftIndex = i;
            int leftSum = cookie[leftIndex];
            int rightIndex = i + 1;
            int rightSum = cookie[rightIndex];
            while (true) {
                if (leftSum > rightSum) {
                    if (rightIndex == cookie.length - 1) {
                        break;
                    }
                    rightSum += cookie[++rightIndex];
                }
                if (leftSum < rightSum) {
                    if (leftIndex == 0) {
                        break;
                    }
                    leftSum += cookie[--leftIndex];
                }
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                    if (leftIndex == 0 || rightIndex == cookie.length - 1) {
                        break;
                    }
                    leftSum += cookie[--leftIndex];
                    rightSum += cookie[++rightIndex];
                }
            }
        }
        return answer;
    }

    public int solution2(int[] cookie) {
        int[] dp = new int[cookie.length];
        dp[0] = cookie[0];
        int sum = cookie[0];
        for (int i = 1; i < cookie.length; i++) {
            dp[i] = cookie[i] + dp[i - 1];
            sum += cookie[i];
        }
        for (int i = sum; i > 0; i--) {
            for (int j = 0; j < cookie.length; j++) {
                int start = j;
                int end = cookie.length - 1;
                int index = 0;
                boolean check = false;
                while (start <= end) {
                    index = (start + end) / 2;
                    int nowSum = dp[index];
                    if (j > 0) {
                        nowSum -= dp[j - 1];
                    }
                    if (nowSum == i) {
                        check = true;
                        break;
                    }
                    if (nowSum > i) {
                        end = index - 1;
                    }
                    if (nowSum < i) {
                        start = index + 1;
                    }
                }
                if (check) {
                    int start2 = index + 1;
                    int end2 = cookie.length - 1;
                    while (start2 <= end2) {
                        int index2 = (start2 + end2) / 2;
                        int nowSum2 = dp[index2] - dp[index];
                        if (nowSum2 == i) {
                            return i;
                        }
                        if (nowSum2 > i) {
                            end2 = index2 - 1;
                        }
                        if (nowSum2 < i) {
                            start2 = index2 + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    /*
    배열의 연속되는 요소가 합을 나타내는지 알 수 있는 로직을 어떻게 구현할까?
    DP를 통해 합을 미리 계산하고 사용해서 시간복잡도를 줄인다.

        고려사항
        1. 합보다 집합의 합이 더 크면 시작점을 1 추가한다.
        2. 집합의 합이 합과 같다면 answer를 수정하고 종료한다.

    1 2 3 4 5
    1 3 6 10 15

    i 0     1   2
    j 3~1   3~2 3

    투포인터의 시간복잡도는?
     */
}
