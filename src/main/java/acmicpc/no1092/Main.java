package acmicpc.no1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] ints = new Integer[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints, Comparator.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Comparator.reverseOrder());

        int count = 0;
        boolean canMove = false;
        boolean[] check = new boolean[m];
        while (!list.isEmpty()) {
            for (int i = 0; i < ints.length; i++) {
                if (list.isEmpty()) {
                    break;
                }

                boolean flag = true;
                for (int j = 0; j < list.size(); j++) {
                    if (check[j]) {
                        continue;
                    }
                    Integer num = list.get(j);

                    if (ints[i] >= num) {
                        check[j] = true;
                        flag = false;
                        canMove = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            if (!canMove) {
                break;
            }
            canMove = false;
            count++;
        }

        System.out.println(isComplete(check) ? count : -1);

    }

    private static boolean isComplete(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 어떤 자료구조 사용하지? 입력/삭제했을 때 정렬되는 자료구조로 써야되는데 그 중에 가장 효율적인게 뭘까
     *
     * 남아있는 박스 중에서 각 크레인들이 처리할 수 있는 것들 중 무거운걸로 고르면 될
     *
     */
    // TODO: 2026/03/25 index를 넣은 Stack으로 옮기지 않은 박스의 index만 반복하도록 최적화

}
