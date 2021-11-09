package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine().split(" "));
        }

        for (String[] strings : list) {
            int maxFloor = Integer.parseInt(strings[0]);
            int maxDistance = Integer.parseInt(strings[1]);
            int count = Integer.parseInt(strings[2]);

            int distance = count / maxFloor + 1;

            int floor = count % maxFloor;
            if (floor == 0) {
                floor = maxFloor;
                distance--;
            }

            System.out.println(floor * 100 + distance);
        }
    }
}
