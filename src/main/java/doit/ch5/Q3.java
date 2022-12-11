package doit.ch5;

public class Q3 {

    public static void main(String[] args) {
        int[] ints = {10, 30, 2};
        System.out.println(gcdArray(ints));
    }

    private static int gcdArray(int[] ints) {
        int gcd = ints[0];
        for (int i = 1; i < ints.length; i++) {
            gcd = gcd(gcd, ints[i]);
        }
        return gcd;
    }

    private static int gcd(int x, int y) {
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        int i = max % min;
        if (i == 0) {
            return min;
        }
        return gcd(max - min, min);
    }
}
