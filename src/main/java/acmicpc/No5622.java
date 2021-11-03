package acmicpc;

import java.io.IOException;

public class No5622 {

    public static void main(String[] args) throws IOException {
        int count = 0;

        while (true) {
            int i = System.in.read();
            if (i == '\n') {
                break;
            }

            if (i < 68) count += 3;
            else if (i < 71) count += 4;
            else if (i < 74) count += 5;
            else if (i < 77) count += 6;
            else if (i < 80) count += 7;
            else if (i < 84) count += 8;
            else if (i < 87) count += 9;
            else count += 10;
        }

        System.out.println(count);
    }
}
