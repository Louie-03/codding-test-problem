package programmers;

import java.util.Stack;

public class No64061 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int doll = board[i][move - 1];
                if (doll != 0) {
                    board[i][move - 1] = 0;
                    if (stack.isEmpty() || doll != stack.peek()) {
                        stack.push(doll);
                    } else {
                        stack.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }

}
