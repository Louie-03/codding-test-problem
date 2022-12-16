package acmicpc.no2331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 반복수열
     유형 : 수학
     시간 복잡도 : O(?)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://www.acmicpc.net/problem/2331
     날짜 : 22.12.16
     refer : https://steady-coding.tistory.com/32
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int num = A;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(A, 0);
        int i = 1;
        while (true) {
            num = getValue(num, P);
            if (map.containsKey(num)) {
                System.out.println(map.get(num));
                return;
            }
            map.put(num, i);
            i++;
        }
    }

    static int getValue(int aLong, int p) {
        int sum = 0;
        while (aLong != 0) {
            sum += Math.pow(aLong % 10, p);
            aLong /= 10;
        }
        return sum;
    }
    /*
    최대 범위가 몇인지 생각해보기
    -> 정확히는 모르겠는데 int 범위안에 해결될듯

    반복 수열을 구하는 방법
    -> 같은 숫자가 또 나오게 된다면 그때부터 반복 수열이 시작됨

    최대 수열의 길이는 몇일까?
    -> 이것도 정확히는 모르겠는데 반복문 돌려보니까 100개 안에 나옴
      -> while문으로 처리하면 될듯
     */
}
