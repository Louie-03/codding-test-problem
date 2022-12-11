package acmicpc.no1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 연속합
     유형 : DP
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/1912
     날짜 : 22.12.5
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(ints));
    }

    static int solution(int[] ints) {
        int[] dp = new int[ints.length];
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
            answer = Math.max(answer, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return answer;
    }
    /*
    자기 자신이 음수여도 멈추셈

    10 6 9 10 15 21  12 33
    10 -4 3 1 5 6 -35 12 21 -1

    10
    3 -4 7 -4 11 -5 1

    자신보다 자신 뒤의 빼는 수가 더 크면 그건 뒤의 수에게 더 낮은 합을 주기 때문에 가장 큰 연속합이 될 수 없다.
    결국 이 상황에서는 자신까지의 합까지만 연속합으로 생각해야함

    음수인 경우에도 잘 돌아가는가?
     */
}
