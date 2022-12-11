package programmers.스티커모으기;

public class Solution {

    /*
     문제 : 스티커 모으기(2)
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 어려움
     시간 : 1h
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/12971
     날짜 : 22.11.4
     refer : https://latte-is-horse.tistory.com/231
     */
    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[sticker.length];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }

        int[] dp2 = new int[sticker.length];
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }

        int answer1 = 0;
        for (int i : dp1) {
            answer1 = Math.max(answer1, i);
        }

        int answer2 = 0;
        for (int i : dp2) {
            answer2 = Math.max(answer2, i);
        }

        return Math.max(answer1, answer2);
    }

    /*
    1 2 3 5 6

    하나를 쓰면 양쪽을 못씀
    x o x o x

    x o x
    o x o
    o x x o
    14, 6, 5, 11, 3, 9, 2, 10
    x o                 6
    x o x               6
    x o x o x           17
    x o x o x o         26
    x o x o x o x       36
    x o x x o x         9

    o x         x 14
    o x x o x o x x 34
    i가 o라면 o 뒤의 값이 기회비용
    i가 x라면 i와 i + 2 값이 i + 1의 기회비용
    -> 두 기회비용이 같으면 어떡하지?

    o x
     */
}
