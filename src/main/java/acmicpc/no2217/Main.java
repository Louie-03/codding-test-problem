package acmicpc.no2217;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(ints));

    }

    static int solution(int[] ints) {
        Arrays.sort(ints);

        int answer = 0;
        for (int i = ints.length; i > 0; i--) {
            answer = max(answer, ints[ints.length - i] * i);
        }
        return answer;
    }

}
