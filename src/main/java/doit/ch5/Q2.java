package doit.ch5;

public class Q2 {

    public static void main(String[] args) {
        System.out.println("22 8 : " + gcd(22, 8));
        System.out.println("15 20 : " + gcd(15, 20));
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
