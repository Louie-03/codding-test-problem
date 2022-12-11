package programmers.기지국설치;

public class Solution {

    /*
     문제 : 기지국 설치
     유형 :
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 50m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/12979
     날짜 : 22.11.2
     refer :
     */
    public int solution(int n, int[] stations, int w) {
        int start = 1;
        int count = 0;
        for (int station : stations) {
            int distance = station - start - w;
            count += distance / (2 * w + 1);
            if (distance % (2 * w + 1) >= 1) {
                count++;
            }
            start = station + w + 1;
        }
        count += (n - start + 1) / (2 * w + 1);
        if ((n - start + 1) % (2 * w + 1) >= 1) {
            count++;
        }
        return count;
    }

    public int solution2(int n, int[] stations, int w) {
        int count = (stations[0] - 1 - w) / (2 * w + 1);
        if ((stations[0] - 1 - w) % (2 * w + 1) >= 1) {
            count++;
        }
        for (int i = 1; i < stations.length; i++) {
            count += (stations[i] - stations[i - 1] - 1 - w * 2) / (w * 2 + 1);
            if ((stations[i] - stations[i - 1] - 1 - w * 2) % (w * 2 + 1) >= 1) {
                count++;
            }
        }
        if (!(n == stations[stations.length - 1])) {
            count += (n - stations[stations.length - 1] - w) / (2 * w + 1);
            if ((n - stations[stations.length - 1] - w) % (2 * w + 1) >= 1) {
                count++;
            }
        }
        return count;
    }
    /*
    0 ~ 4
      3
    4 ~ 11
      (11 - 4 - 1 - 2w) / w 나머지 존재하면 + 1
     */
}
