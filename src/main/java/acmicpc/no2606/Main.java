package acmicpc.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 바이러스
     유형 : Union&Find
     시간 복잡도 : O(N a(N))
     난이도 : 매우 쉬움
     시간 : 15m
     uri : https://www.acmicpc.net/problem/2606
     날짜 : 22.11.9
     refer : https://dheldh77.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%9C%A0%EB%8B%88%EC%98%A8%ED%8C%8C%EC%9D%B8%EB%93%9CUnion-Find-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1
     */
    static int[] ints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        ints = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            ints[i] = i;
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int index1 = find(1);
        int answer = -1;
        for (int anInt : ints) {
            if (index1 == find(anInt)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void union(int a, int b) {
        ints[find(b)] = find(a);
    }

    static int find(int index) {
        if (ints[index] != index) {
            return ints[index] = find(ints[index]);
        }
        return index;
    }
}

/*
7
6
1 2
2 3
5 1
5 2
5 6
4 7
 */
