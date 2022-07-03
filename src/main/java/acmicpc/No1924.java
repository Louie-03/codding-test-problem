package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class No1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int month = Integer.parseInt(inputs[0]);
        int day = Integer.parseInt(inputs[1]);
        LocalDate date = LocalDate.of(2007, month, day);
        String stringDayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
        System.out.println(stringDayOfWeek);
    }
}
