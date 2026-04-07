package acmicpc.no11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = k - 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (list.size() > 1) {
            sb.append(list.remove(index)).append(", ");
            index += k - 1;
            if (index >= list.size()) {
                index %= list.size();
            }

        }

        sb.append(list.remove(0)).append(">");
        System.out.println(sb);
    }

    /**
     * 1234567 3
     * 124567 6
     * 12457 2
     * 1457 7
     * 145 5
     * 14 1
     * 4
     */

}
