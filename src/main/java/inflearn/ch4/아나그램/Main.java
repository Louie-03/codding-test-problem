package inflearn.ch4.아나그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

//    2. 아나그램 https://cote.inflearn.com/contest/10/problem/04-02
//    O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = br.readLine().toCharArray();
        char[] chars2 = br.readLine().toCharArray();
        Map<Character, Integer> map1 = getMap(chars1);
        Map<Character, Integer> map2 = getMap(chars2);

        boolean check = true;
        if (map1.size() == map2.size()) {
            for (Character character : map1.keySet()) {
                if (map1.get(character) != map2.get(character)) {
                    check = false;
                    break;
                }
            }
        } else {
            check = false;
        }
        System.out.println(check ? "YES" : "NO");
    }

    private static Map<Character, Integer> getMap(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
