package acmicpc.no18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        int[] answer = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { // NlogN
            int num = Integer.parseInt(st.nextToken());
            ints[i] = num;
            set.add(num);
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        int i = 0;
        for (Integer integer : set) { //N
            for (Integer integer1 : map.get(integer)) {
                answer[integer1] = i;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i1 : answer) {
            sb.append(i1 + " ");
        }
        System.out.println(sb);
    }
    /*
    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
    > 자기보다 작은 숫자는 압축 결과도 작아야한다.
    > 압축 결과는 0부터 시작하며 숫자의 개수까지 존재한다.
     */
}
