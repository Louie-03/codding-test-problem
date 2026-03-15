package programmers.기능개발;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 1) {
            return new int[]{1};
        }

        int n = progresses.length;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                ints[i]++;
            }
        }
        List<Integer> answerList = new ArrayList<>();
        int day = ints[0];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ints[i] <= day) {
                count++;
            }
            if (ints[i] > day) {
                answerList.add(count);
                count = 1;
                day = ints[i];
            }
        }

        if (ints[n - 1] > day) {
            answerList.add(1);
        } else {
            answerList.add(count);
        }


        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

}
