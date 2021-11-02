package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2675 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        List<String[]> stringsList = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            stringsList.add(br.readLine().split(" "));
        }

        for (int i = 0; i < t; i++) {
            int r = Integer.parseInt(stringsList.get(i)[0]);
            String s = stringsList.get(i)[1];
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < r; k++) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}