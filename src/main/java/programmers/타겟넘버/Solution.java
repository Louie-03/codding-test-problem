package programmers.타겟넘버;

public class Solution {

    /*
     문제 : 타겟 넘버
     유형 : DFS
     시간 복잡도 : O(2^N)
     난이도 : 매우 쉬움
     시간 : 5m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/43165
     날짜 : 22.11.21
     refer :
     */
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0, 0);
    }

    int dfs(int[] numbers, int target, int sum, int index, int answer) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return answer;
        }
        answer = dfs(numbers, target, sum + numbers[index], index + 1, answer);
        answer = dfs(numbers, target, sum - numbers[index], index + 1, answer);
        return answer;
    }
}
