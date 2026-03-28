package programmers.피로도;

import static java.lang.Math.max;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        for (int i = 0; i < dungeons.length; i++) {
            boolean[] check = new boolean[dungeons.length];
            int nowK = k;
            int count = 0;
            if (k >= dungeons[i][0]) {
                nowK -= dungeons[i][1];
                check[i] = true;
                answer = max(dfs(dungeons, 1, nowK, count + 1, check), answer);
                check[i] = false;
            }
        }

        return answer;
    }

    int dfs(int[][] dungeon, int depth, int k, int count, boolean[] check) {
        int answer = count;

        if (depth == dungeon.length) {
            return count;
        }

        for (int i = 0; i < dungeon.length; i++) {
            if (check[i]) {
                continue;
            }

            if (k >= dungeon[i][0]) {
                check[i] = true;
                answer = max(dfs(dungeon, depth + 1, k - dungeon[i][1], count + 1, check), answer);
                check[i] = false;
            }

        }

        return answer;
    }

}
