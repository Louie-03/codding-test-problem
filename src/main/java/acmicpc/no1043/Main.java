package acmicpc.no1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> map = initMap(n);
        st = new StringTokenizer(br.readLine());
        boolean[] booleans = initBooleans(st, n);
        Queue<Integer> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] ints = new int[size];
            for (int j = 0; j < size; j++) {
                ints[j] = Integer.parseInt(st.nextToken());
                map.get(ints[j]).add(i);
                if (booleans[ints[j]]) {
                    queue.add(i);
                }
            }
            list.add(ints);
        }
        boolean[] booleans1 = new boolean[m];
        while (!queue.isEmpty()) {
            int size1 = queue.size();
            for (int i = 0; i < size1; i++) {
                Integer integer = queue.poll();
                booleans1[integer] = true;
                for (int i1 : list.get(integer)) {
                    if (!booleans[i1]) {
                        booleans[i1] = true;
                        for (Integer integer1 : map.get(i1)) {
                            queue.add(integer1);
                        }
                    }
                }
            }
        }
        int count = 0;
        for (boolean check : booleans1) {
            if (!check) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean[] initBooleans(StringTokenizer st, int n) {
        boolean[] booleans = new boolean[n + 1];
        int size = Integer.parseInt(st.nextToken());
        for (int i = 0; i < size; i++) {
            booleans[Integer.parseInt(st.nextToken())] = true;
        }
        return booleans;
    }

    private static Map<Integer, List<Integer>> initMap(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        return map;
    }
    /*
    4 3
    1 1
    2 3 4
    2 3 2
    2 1 2

    파티에 진실을 아는 사람이 존재한다면 사실을 말한다.
    한 사람은 여러개의 파티에서 같은 얘기를 들어야 한다.

    거짓말을 들었다가 진실을 들어도 안되는건지? -> 안된다

    진실을 아는 사람이 존재하는 파티에 대해 먼저 계산을 하고
    이후에 남은 파티들에게 과장된 이야기를 할 수 있는지 확인하면 될
     */
}
