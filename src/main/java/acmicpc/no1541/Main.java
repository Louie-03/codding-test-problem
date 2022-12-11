package acmicpc.no1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 잃어버린 괄호
     유형 : 문자열, 파싱
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/1541
     날짜 : 22.11.15
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        System.out.println(solution(string));
    }

    static int solution(String string) {
        String[] strings = string.split("\\+|-");
        int index = strings.length - 1;
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '-') {
                index = count;
                break;
            }
            if (c == '+') {
                count++;
            }
        }
        int answer = 0;
        for (int i = 0; i <= index; i++) {
            answer += Integer.parseInt(strings[i]);
        }
        for (int i = index + 1; i < strings.length; i++) {
            answer -= Integer.parseInt(strings[i]);
        }
        return answer;
    }
    /*
    55-50+40+50-20
    55+50-40-50+20
    55+50+40+50-20
    55-50-40+50-20
     */
}
