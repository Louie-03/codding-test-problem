package programmers.멀쩡한사각형;

public class Solution {

    public long solution(long w, long h) {
        int gcd = calculateGcd(w, h);
        return w * h - (w + h - gcd);
    }

    private int calculateGcd(long w, long h) {
        int gcd = 1;
        boolean check = true;
        while (check) {
            Integer lcd = calculateLcd(w, h);
            if (lcd == null) {
                check = false;
            } else {
                w /= lcd;
                h /= lcd;
                gcd *= lcd;
            }
        }
        return gcd;
    }

    private Integer calculateLcd(long w, long h) {
        for (int i = 2; i <= Math.min(w, h); i++) {
            if (w % i == 0 && h % i == 0) {
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 8));
    }

    /*
    2*2
    0 0 ~ 2 2
    2 * 3
    0,0 1,1 2,2
    w == h : w
    w == 2h :
    4 2
    2 1 * 2
    둘 중 하나가 1이면 남은 숫자가 넓이와 같음
    ex : 2 1 : 2
    2   3
    0   0   2/3 반올림해서 x : 0~1 y : 0
    2/3 1   4/3 반올림해서 x : 1~2 y : 1
    4/3 2
    6/3 3

    ㅡ ㅡ ㅡ ㅡ
   | |  | |  |
    ㅡ ㅡ ㅡ ㅡ
   | |  | |  |
    ㅡ ㅡ ㅡ ㅡ
    2   2   2
    2   3   4

     */
}
