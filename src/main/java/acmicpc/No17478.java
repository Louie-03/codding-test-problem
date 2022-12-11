package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No17478 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] messages = {
            "\"재귀함수가 뭔가요?\"\n",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
        };

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        a(0, N, bw, messages);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void a(int count, int n, BufferedWriter bw, String[] messages)
        throws IOException {
        String frontString = getFrontString(count);
        bw.write(frontString + messages[0]);
        if (count == n) {
            bw.write(frontString + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            for (int i = 1; i < messages.length; i++) {
                bw.write(frontString + messages[i]);
            }
            a(count + 1, n, bw, messages);
        }
        bw.write(frontString + "라고 답변하였지.\n");
    }

    private static String getFrontString(int n) {
        String frontString = "";
        for (int i = 0; i < n; i++) {
            frontString += "____";
        }
        return frontString;
    }
}
