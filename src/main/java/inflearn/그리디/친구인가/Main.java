package inflearn.그리디.친구인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 친구인가? (Disjoint-Set : Union&Find)
     유형 : Union&Find
     시간 복잡도 : O(N * M)
     난이도 : 보통
     시간 : 30m
     uri : https://cote.inflearn.com/contest/10/problem/09-06
     날짜 : 22.10.25
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73415?category=questionDetail&tab=community
     */
    static int[] ints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        ints = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ints[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int fa = find(a);
            int fb = find(b);
            if (fa != fb) {
                ints[fa] = fb;
            }
        }

        strings = br.readLine().split(" ");
        int a = Integer.parseInt(strings[0]);
        int b = Integer.parseInt(strings[1]);

        int aValue = find(a);
        int bValue = find(b);

        if (aValue == bValue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int find(int index) {
        if (ints[index] == index) {
            return index;
        }
        return ints[index] = find(ints[index]);
    }

    /*
    1 2 3 4 5 6 7 8 9
    2 2 3 4 5 6 7 8 9
    2 3 3 4 5 6 7 8 9
    2 3 4 4 5 6 7 8 9
    5 3 4 4 5 6 7 8 9

    1 2 3 4 5
    6 7 8 9
     */
}
