package doit.ch3;

import java.util.ArrayList;
import java.util.List;

public class Q3SearchIndex {

    public static void main(String[] args) {
        int[] ints = {1, 9, 2, 9, 4, 6, 7, 9};
        List<Integer> indexList = new ArrayList<>();
        int count = searchIndex(ints, 9, indexList);
        System.out.println(indexList);
        System.out.println(count);
    }

    public static int searchIndex(int[] elements, int key, List<Integer> indexList) {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == key) {
                count++;
                indexList.add(i);
            }
        }
        return count;
    }
}
