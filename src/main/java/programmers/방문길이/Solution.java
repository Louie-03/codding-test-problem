package programmers.방문길이;

import java.util.Map;

public class Solution {

    public int solution(String dirs) {
        char[] chars = dirs.toCharArray();
        int x = 5;
        int y = 5;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][][][] booleans = new boolean[11][11][11][11];
        Map<Character, Integer> map = Map.of(
            'U', 0,
            'R', 1,
            'D', 2,
            'L', 3
        );
        int count = 0;
        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            int tmpX = x + dx[integer];
            int tmpY = y + dy[integer];
            if (0 <= tmpX && tmpX <= 10 && 0 <= tmpY && tmpY <= 10) {
                if (!(booleans[tmpX][tmpY][x][y] || booleans[x][y][tmpX][tmpY])) {
                    count++;
                    booleans[tmpX][tmpY][x][y] = true;
                    booleans[x][y][tmpX][tmpY] = true;
                }
                x = tmpX;
                y = tmpY;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution("LLLLRLRLRLL"));
//        System.out.println(new Solution().solution("UUUUDUDUDUUU"));
//        System.out.println(new Solution().solution("LURDLURDLURDLURDRULD"));
        System.out.println(new Solution().solution("LULLLLLLU"));
//        System.out.println(new Solution().solution("RRRRRRRRRRRRRRRRRRRRRUUUUUUUUUUUUULU"));
    }
    /*
    LURDLURDLURDLURDRULD
    0,0
L   -1,0    1
U   -1,1    2
R   0,1     3
D   0,0
L
U
R
D
L
U
R
D
L
U
R
D
R
U
L
D
     */
}
