package algorithm;

public class SelectionSort {
    public static void main(String[] args) {
        int[] ints = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (int i = 0; i < 10; i++) {
            int index = i;
            int min = ints[i];
            for (int j = i + 1; j < 10; j++) {
                int num = ints[j];
                if (min > num) {
                    min = num;
                    index = j;
                }
            }
            ints[index] = ints[i];
            ints[i] = min;
        }

        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

• 상속
• 연관관계
• 객체 그래프 탐색
• 비교하기
