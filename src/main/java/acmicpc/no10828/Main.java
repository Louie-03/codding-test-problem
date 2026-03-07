package acmicpc.no10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());

                if (isEmpty(ints, index)) {
                    ints[0] = num;
                } else {
                    ints[index + 1] = num;
                    index++;
                }
            }
            if (command.equals("pop")) {
                if (isEmpty(ints, index)) {
                    sb.append(-1);
                } else {
                    sb.append(ints[index]);
                    ints[index] = 0;
                    if (index != 0) {
                        index--;
                    }
                }
                sb.append("\n");
            }
            if (command.equals("size")) {
                sb.append(getSize(ints, index)).append("\n");
            }
            if (command.equals("empty")) {
                sb.append(isEmpty(ints, index) ? 1 : 0).append("\n");
            }
            if (command.equals("top")) {
                sb.append(isEmpty(ints, index) ? -1 : ints[index]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isEmpty(int[] ints, int index) {
        return index == 0 && ints[0] == 0;
    }

    private static int getSize(int[] ints, int index) {
        if (isEmpty(ints, index)) {
            return 0;
        }
        return index + 1;
    }
}
