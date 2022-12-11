package programmers.지형이동;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int solution(int[][] land, int height) {
        int length = land.length;
        int[][] ints = new int[length][length];
        int num = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                ints[i][j] = num++;
            }
        }

        List<int[]> list = List.of(
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0}
        );

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int i1 = land[i][j];
                for (int[] ints1 : list) {
                    int x = j + ints1[0];
                    int y = i + ints1[1];
                    if (0 <= x && x < length && 0 <= y && y < length) {
                        if (Math.abs(land[y][x] - i1) <= height) {
                            union(x, y, j, i, ints);
                        }
                    }
                }
            }
        }

        int answer = 0;
        while (getSetSize(ints) != 1) {
            int[][] ints2 = new int[length * length][length * length];
            for (int[] ints1 : ints2) {
                Arrays.fill(ints1, Integer.MAX_VALUE);
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    int i1 = find(j, i, ints);
                    for (int[] ints1 : list) {
                        int x = j + ints1[0];
                        int y = i + ints1[1];
                        if (0 <= x && x < length && 0 <= y && y < length) {
                            int i2 = find(x, y, ints);
                            if (i1 != i2) {
                                ints2[i1][i2] = ints2[i2][i1] =
                                    Math.min(Math.min(ints2[i1][i2], ints2[i2][i1]),
                                        Math.abs(land[i][j] - land[y][x]));

                            }
                        }
                    }
                }
            }
            label:
            for (int i = 0; i < length * length; i++) {
                for (int j = 0; j < length * length; j++) {
                    int i1 = ints2[i][j];
                    if (i1 != Integer.MAX_VALUE) {
                        answer += i1;
                        union(i % 4, i / 4, j % 4, j / 4, ints);
//                        ints2[i][j] = ints2[j][i] = 0;
                        break label;
                    }
                }
            }
        }
        return answer;
    }

    private int getSetSize(int[][] ints) {
        int length = ints.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                set.add(find(j, i, ints));
            }
        }
        return set.size();
    }

    private void union(int x1, int y1, int x2, int y2, int[][] ints) {
        int i1 = find(x1, y1, ints);
        int length = ints.length;
        ints[i1 / length][i1 % length] = find(x2, y2, ints);
    }

    private int find(int x, int y, int[][] ints) {
        int length = ints.length;
        int num = ints[y][x];
        if (num == x + length * y) {
            return num;
        }
        return ints[y][x] = find(num % length, num / length, ints);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(
//            new int[][]{{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}}, 3));
        System.out.println(new Solution().solution(
            new int[][]{{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}}, 1));
    }

    /*
    1 2 3 4

     */
}
