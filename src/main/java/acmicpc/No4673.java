package acmicpc;

public class No4673 {

    public static void main(String[] args) {
        boolean[] booleans = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {
                booleans[n] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (booleans[i] == false) {
                System.out.println(i);
            }
        }
    }

    private static int d(int num) {
        int sum = num;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
