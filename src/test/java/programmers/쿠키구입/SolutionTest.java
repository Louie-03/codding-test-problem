package programmers.쿠키구입;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{1, 1, 2, 3})).isEqualTo(3);
        assertThat(solution.solution(new int[]{1, 2, 4, 5})).isEqualTo(0);
//        assertThat(solution.solution2(new int[]{1, 1, 2, 3})).isEqualTo(3);
//        assertThat(solution.solution2(new int[]{1, 2, 4, 5})).isEqualTo(0);
    }

    @Test
    void name2() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] dp = new int[ints.length];
        dp[0] = ints[0];
        for (int i = 1; i < ints.length; i++) {
            dp[i] = dp[i - 1] +  ints[i];
        }
        int answer = 54;
        int j = 1;
        int start = j;
        int end = ints.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            int sum = dp[index];
            if (start > 0) {
                sum -= dp[j - 1];
            }
            if (sum == answer) {
                System.out.println(start + " " + end);
                break;
            }
            if (sum > answer) {
                end = index - 1;
            }
            if (sum < answer) {
                start = index + 1;
            }
        }
    }
    /*
    1 2 3 4 5 6 7 8
    4 6 5
     */
}
