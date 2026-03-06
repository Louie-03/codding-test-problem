package acmicpc.no18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        int first = 0;
        int back = 0;
        boolean isEmpty = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                if (isEmpty) {
                    ints[first] = num;
                } else {
                    ints[++back] = num;
                }
                isEmpty = false;
            }
            if (command.equals("pop")) {
                if (isEmpty) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(ints[first]).append("\n");
                    if (first == back) {
                        isEmpty = true;
                    } else {
                        first++;
                    }
                }
            }
            if (command.equals("size")) {
                sb.append(isEmpty ? 0 : back - first + 1).append("\n");
            }
            if (command.equals("empty")) {
                sb.append(isEmpty? 1 : 0).append("\n");
            }
            if (command.equals("front")) {
                sb.append(isEmpty ? -1 : ints[first]).append("\n");
            }
            if (command.equals("back")) {
                sb.append(isEmpty ? -1 : ints[back]).append("\n");
            }
        }

        System.out.println(sb);
    }

    //            TODO : 반복적인 if문을 간소화하는 방법이 있지 않나? 옛날에 람다로 함수형 프로그래밍 코드 짠거 있는 것 같은데
    /**
     * 마지막 요소를 가져올려면 List 또는 Deque을 사용해야됨
     * 만약 push가 많으면 LinkedList를 사용하고 맨 뒤를 조회를 많이하면 ArrayList가 좋아보임
     *      근데 특정 명령어가 자주 나온다는 내용이 없으므로 간단하게 ArrayList로 구현하기
     *      ArrayList는 데이터를 추가할 때 시간복잡도 1, 삭제할때 N, 조회할때 1
     *      LinkedList는 데이터를 추가할때 1, 삭제할때 1, 조회할때 N
     *      위에 적은 시간 복잡도가 맞나?
     *      그러면 조회하는건 직접 구현할 수 있으니
     *
     *      outOfIndex 발생 안함?
     */
}
