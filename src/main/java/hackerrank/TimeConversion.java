package hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ssaa", Locale.US);
        String s = new Scanner(System.in).next();
        System.out.println(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(format.parse(s)));
    }
}
