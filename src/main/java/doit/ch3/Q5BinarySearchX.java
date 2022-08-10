package doit.ch3;

public class Q5BinarySearchX {

    public static void main(String[] args) {
        int[] elements = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int x = 7;
        int length = elements.length;
        int start = 0;
        int end = length - 1;
        int n = (int) (Math.log(length) / Math.log(2));
        int index = 0;
        for (int i = 0; i <= n; i++) {
            index = (start + end) / 2;
            int num = elements[index];
            if (num == x) {
                for (int j = index - 1; j >= 0; j--) {
                    if (elements[j] != num) {
                        index = j + 1;
                        break;
                    }
                }
            }
        }
        System.out.println(index);
    }
}
