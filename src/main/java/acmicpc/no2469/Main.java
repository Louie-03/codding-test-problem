package acmicpc.no2469;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String answer = br.readLine();
        String[] strings = new String[n];
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
            if (strings[i].charAt(0) == '?') {
                endIndex = i;
            }
        }

        Map<Character, Integer> startMap = new HashMap<>();
        Map<Character, Integer> endMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            startMap.put((char) ('A' + i), i);
            endMap.put(answer.charAt(i), i);
        }

        for (int i = 0; i < k; i++) {
            Integer index = startMap.get((char) ('A' + i));
            for (int j = 0; j < endIndex; j++) {
                if (index == 0 && strings[j].charAt(0) == '-') {
                    index++;
                } else if (index == k - 1 && strings[j].charAt(k - 2) == '-') {
                    index--;
                } else if (index > 0 && index < k - 1) {
                    if (strings[j].charAt(index - 1) == '-') {
                        index--;
                    } else if (strings[j].charAt(index) == '-') {
                        index++;
                    }
                }
                startMap.put((char) ('A' + i), index);
            }

            index = endMap.get((char) ('A' + i));
            for (int j = n - 1; j > endIndex; j--) {

                if (index == 0 && strings[j].charAt(0) == '-') {
                    index++;
                } else if (index == k - 1 && strings[j].charAt(k - 2) == '-') {
                    index--;
                } else if (index > 0 && index < k - 1) {
                    if (strings[j].charAt(index - 1) == '-') {
                        index--;
                    } else if (strings[j].charAt(index) == '-') {
                        index++;
                    }
                }
                endMap.put((char) ('A' + i), index);
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if (flag) {
                sb.append("*");
                flag = false;
                continue;
            }

            for (Character endMapChar : endMap.keySet()) {
                if (endMap.get(endMapChar) == i) {
                    if (startMap.get(endMapChar) == i) {
                        sb.append("*");
                    } else {
                        if (Math.abs(startMap.get(endMapChar) - endMap.get(endMapChar)) == 1) {
                            sb.append("-");
                            flag = true;
                        } else {
                            sb = new StringBuilder();
                            for (int j = 0; j < k - 1; j++) {
                                sb.append("x");
                            }
                            System.out.println(sb);
                            return;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(sb);

    }

}
