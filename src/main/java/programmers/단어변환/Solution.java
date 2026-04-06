package programmers.단어변환;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        boolean[] check = new boolean[words.length];

        int answer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return answer;
                }

                for (int j = 0; j < words.length; j++) {
                    int count = 0;

                    if (check[j]) {
                        continue;
                    }

                    for (int k = 0; k < poll.length(); k++) {
                        if (poll.charAt(k) == words[j].charAt(k)) {
                            count++;
                        }
                    }

                    if (count == poll.length() - 1) {
                        queue.add(words[j]);
                        check[j] = true;
                    }
                }

            }
            answer++;
        }

        return 0;
    }

}
