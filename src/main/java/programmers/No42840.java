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
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            for (int j = 0; j < scores.length; j++) {
                if (answer == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }
        return scores;
    }

    private int getMaxScore(int[] scores) {
        return Math.max(scores[0], Math.max(scores[1], scores[2]));
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
}
