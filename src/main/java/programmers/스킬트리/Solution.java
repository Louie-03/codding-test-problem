package programmers.스킬트리;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    /*
     문제 : 스킬트리
     유형 : 구현
     시간 복잡도 : O(N^3)
     난이도 : 매우 쉬움
     시간 : 20m
     uri : https://school.programmers.co.kr/learn/courses/30/lessons/49993
     날짜 : 22.11.2
     refer :
     */
    public int solution(String skill, String[] skill_trees) {
        List<Character> skills = skill.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toList());
        int count = 0;
        for (String skill_tree : skill_trees) { // skill_trees.length
            int index = 0;
            boolean check = true;
            for (char c : skill_tree.toCharArray()) { // skill_tree.length()
                int indexOf = skills.indexOf(c); // skills.size();
                if (indexOf != -1) {
                    if (indexOf > index) {
                        check = false;
                        break;
                    }
                    index++;
                }
            }
            if (check) {
                count++;
            }
        }
        return count;
    }
}
