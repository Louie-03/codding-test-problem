package acmicpc.no11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 연결 요소의 개수
     유형 : Union&Find
     시간 복잡도 : O(N a(N))
     난이도 : 매우 쉬움
     시간 : 10m
     uri : https://www.acmicpc.net/problem/11724
     날짜 : 22.11.11
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ints = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), ints);
        }
        Set<Integer> set = new HashSet<>();
        for (int anInt : ints) {
            set.add(find(anInt, ints));
        }
        System.out.println(set.size() - 1);
    }

    static void union(int a, int b, int[] ints) {
        ints[find(b, ints)] = find(a, ints);
    }

    static int find(int index, int[] ints) {
        if (ints[index] == index) {
            return index;
        }
        return ints[index] = find(ints[index], ints);
    }
}
