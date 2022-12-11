package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RockScissorPaper {

//    3. 가위 바위 보 https://cote.inflearn.com/contest/10/problem/02-03
//    1 < 2
//    1 > 3
//    2 < 3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] ints = new int[2][n];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            int a = ints[0][i];
            int b = ints[1][i];
            int sum = a + b;

            Map<Integer, Integer> map = new HashMap<>();
            map.put(3, 2);
            map.put(4, 1);
            map.put(5, 3);
//            Map<Integer, Integer> map = Map.of(
//                3, 2,
//                4, 1,
//                5, 3
//            );

            if (a == b) {
                bw.write("D\n");
                continue;
            }
            bw.write(findNameByNum(map.get(sum), a) + "\n");
        }
        bw.flush();
    }

    private static char findNameByNum(int num, int a) {
        return a == num ? 'A' : 'B';
    }

}
