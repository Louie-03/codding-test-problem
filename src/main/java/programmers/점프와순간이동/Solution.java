package programmers.점프와순간이동;

public class Solution {

    public int solution(int n) {
        int[] ints = new int[n + 1];
        ints[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i *= i) {
//            System.out.println(i);
            ints[i] = 1;
        }
        for (int i = 3; i <= n; i++) {
            if (ints[i] == 0) {
                ints[i] = ints[i / 2] + i % 2;
            }
        }
        return ints[n];
    }

    public static void main(String[] args) {
//        System.out.println(65536 * 65536);
//        System.out.println(new Solution().solution(5));
//        System.out.println(new Solution().solution(6));
//        System.out.println(new Solution().solution(5000));
//        System.out.println(new Solution().solution(10000));
//        System.out.println(new Solution().solution(81920000));
//        System.out.println(Math.log(1000000000) / Math.log(2));
        int a = 1000000000;
        int count = 0;
        while (a != 0) {
            if (a % 2 == 1) {
                count++;
            }
            a /= 2;
        }
        System.out.println(count);
//        for (int i = 0; i < 30; i++) {
//            System.out.println(i + "\t" + (a /= 2));
//        }
//        System.out.println(new Solution().solution(1000000000));
    }

    /*
    dp로 풀었으나 O(N)이기 떄문에 10억을 입력하면 시간초과
    해당 숫자를 계속 2로 나누면서 얻은 홀수의 개수가 정답과 같아서 main처럼 풀었음
    정답과 관련된 규칙은 빨리 캐치했지만 dp로 구현해야한다는 사고방식에 갇혀서 반대로 재귀나 반복문을 사용할 생각은 하지 못했음

    dp로 구하는건 어떤가?
    점프 -> 순간이동 -> 점프 -> 순간이동 이렇게 점프와 순간이동을 여러번 할수도 있을 것 같다.

    일단 1이랑 2의 제곱수는 정답이 전부 1이다.
    짝수면 숫자 / 2와 같음, 예를 들어 6이면 3에서 순간이동하면 되니까 3이랑 개수가 같아야됨
    홀수면 숫자 / 2 + 1과 같음, 근데 숫자 / 2 + 1은 숫자 - 1 + 1이랑 같음(홀수 / 2 == 홀수 - 1)
    1   1   0-1
    2   1   0-1 2
    3   2   0-1 2-3
    4   1   0-1 2 4
    5   2   0-1 2 4-5
    6   2   0-1 2-3 6
    7   3   0-1 2 4-6 or 0-3 6

    5



    100
     */
}
