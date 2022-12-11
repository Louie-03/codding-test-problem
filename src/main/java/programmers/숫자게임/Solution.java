package programmers.숫자게임;

import java.util.Arrays;

public class Solution {

    /*
     문제 : 숫자게임
     유형 : 정렬
     시간 복잡도 : O(N^2)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/12987
     날짜 : 22.11.2
     refer :
     */
    public int solution(int[] A, int[] B) {
        Arrays.sort(A); // N^2
        Arrays.sort(B); // N^2
        int answer = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) { // N
            while (A[i] >= B[index]) { // N
                index++;
                if (B.length == index) {
                    return answer;
                }
            }
            answer++;
            index++;
            if (B.length == index) {
                return answer;
            }
        }
        return answer;
    }

    /*
    정답을 얻을려면 B가 A보다 큰 수를 내는 상황이 가장 많아야한다.
    -> B의 출전하지 않은 수 중에서 A의 출전하지 않은 수 중에 가장 작은 수보다 더 큰 수들 중에 가장 작은 수를 출전시키면 된다.
     */
}
