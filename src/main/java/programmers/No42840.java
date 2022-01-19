package programmers;

import java.util.ArrayList;
import java.util.List;

public class No42840 {

    public List<Integer> solution(int[] answers) {
        int[] scores = getScores(answers);
        int max = getMaxScore(scores);
        return getResult(scores, max);
    }

    private int[] getScores(int[] answers) {
        int[] scores = new int[3];
        int[] number2Answer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] number3Answer = {3, 1, 2, 4, 5};
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == i % 5 + 1) {
                scores[0]++;
            }
            if (answer == number2Answer[i % 8]) {
                scores[1]++;
            }
            if (answer == number3Answer[i % 10 / 2]) {
                scores[2]++;
            }
        }
        return scores;
    }

    private int getMaxScore(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            max = max(max, scores[i]);
        }
        return max;
    }

    private List<Integer> getResult(int[] scores, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
}
