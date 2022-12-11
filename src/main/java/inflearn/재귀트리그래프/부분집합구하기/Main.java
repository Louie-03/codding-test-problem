package inflearn.재귀트리그래프.부분집합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    /*
     문제 : 부분집합 구하기
     유형 : DFS
     날짜 : 22.10.14
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72773?tab=curriculum
     */
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static int n;

//
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d(1, true);
        d(1, false);
    }

    private static void d(int i, boolean check) {
        if (i > n) {
            return;
        }
        if (check) {
            deque.add(i);
        } else {
            deque.remove(i);
        }
        d(i + 1, true);
        d(i + 1, false);
        if (check) {
            for (Integer integer : deque) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /*
    123 ooo
    12  oox
    13  oxo
    1   oxx
    23  xoo
    2   xox
    3   xxo

    1234 oooo
    123 ooox
    124 ooxo
    134 oxoo
    234 xooo
    12  ooxx
    13  oxox
    14  oxxo
    23  xoox
    24  xoxo
    34  xxoo
    1   oxxx
    2   xoxx
    3   xxox
    4   xxxo

    0
     */
}
