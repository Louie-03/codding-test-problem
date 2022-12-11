package programmers.영어끝말잇기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String word = words[0];
        set.add(word);
        char lastLetter = word.charAt(word.length() - 1);
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i];
            if (word1.charAt(0) != lastLetter || set.contains(word1)) {
                System.out.println(word1);
                return new int[]{i % n + 1, i / n + 1};
            }
            lastLetter = word1.charAt(word1.length() - 1);
            set.add(word1);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
//            new Solution().solution(3, new String[]{"abc", "cd", "de", "aea", "abc"})));
//            new Solution().solution(3, new String[]{"abb", "baa", "ccc", "cda", "abb"})));
            new Solution().solution(2, new String[]{"land", "dream", "mom", "mom", "ror"})));
    }
}
