package programmers.예산;

import java.util.Arrays;

public class Solution {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int i : d) {
            if (i > budget) {
                break;
            }
            budget -= i;
            count++;
        }
        return count;
    }
}
