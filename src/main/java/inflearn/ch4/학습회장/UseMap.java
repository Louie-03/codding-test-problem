package inflearn.ch4.학습회장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UseMap {

//    1. 학급 회장 https://cote.inflearn.com/contest/10/problem/04-01
//    O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] chars = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char result = ' ';
        int maxCount = 0;
        for (Character character : map.keySet()) {
            Integer num = map.get(character);
            if (maxCount < num) {
                maxCount = num;
                result = character;
            }
        }
        System.out.println(result);
    }
}
