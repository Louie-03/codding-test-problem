package acmicpc.no10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String string = st.nextToken();
            list.add(string);
            if (string.equals("push")) {
                list.add(st.nextToken());
            }
        }
        MyQueue queue = new MyQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String command = list.get(i);
            if (command.equals("push"))
                queue.push(Integer.parseInt(list.get(++i)));
            if (command.equals("pop"))
                sb.append(queue.pop()).append("\n");
            if (command.equals("size"))
                sb.append(queue.size()).append("\n");
            if (command.equals("empty"))
                sb.append(queue.isEmpty()).append("\n");
            if (command.equals("front"))
                sb.append(queue.front()).append("\n");
            if (command.equals("back"))
                sb.append(queue.back()).append("\n");
        }
        System.out.println(sb);
    }

    private static class MyQueue {

        List<Integer> list = new ArrayList<>();

        public void push(int num) {
            list.add(num);
        }

        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(0);
        }

        public int size() {
            return list.size();
        }

        public int isEmpty() {
            return list.isEmpty() ? 1 : 0;
        }

        public int front() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(0);
        }

        public int back() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }
}
