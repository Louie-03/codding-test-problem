package acmicpc.no11576;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        int a = 25;

        System.out.println("10진수 -> 2진수");
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toString(a, 2));

        System.out.println("10진수 -> 3진수");
        System.out.println(Integer.toString(a, 3));

        System.out.println("10진수 -> 4진수");
        System.out.println(Integer.toString(a, 4));

        System.out.println("10진수 -> 5진수");
        System.out.println(Integer.toString(a, 5));

        System.out.println("10진수 -> 6진수");
        System.out.println(Integer.toString(a, 6));

        System.out.println("10진수 -> 7진수");
        System.out.println(Integer.toString(a, 7));

        System.out.println("10진수 -> 8진수");
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toString(a, 8));

        System.out.println("10진수 -> 16진수");
        System.out.println(Integer.toString(a, 16));
        System.out.println(Integer.toHexString(a));
    }

    @Test
    void name2() {
        String a = "110011";

        System.out.println("2진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 2));

        System.out.println("3진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 3));

        System.out.println("4진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 4));

        System.out.println("5진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 5));

        System.out.println("6진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 6));

        System.out.println("7진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 7));

        System.out.println("8진수 -> 10진수");
        System.out.println(Integer.parseInt(a, 8));

        System.out.println("16진수 -> 10진수");
        System.out.println(Integer.parseInt("AAAAA", 16));
    }
}
