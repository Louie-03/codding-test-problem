package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ObversePrimeNumber {

//    6. 뒤집은 소수 https://cote.inflearn.com/contest/10/problem/02-06
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int obverseNumber = getObverseNumber(num);
            boolean check = true;
            for (int j = 2; j <= (int) Math.sqrt(obverseNumber); j++) {
                if (obverseNumber % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check && obverseNumber >= 2) {
                bw.write(obverseNumber + " ");
            }
        }
        bw.flush();
    }

    private static int getObverseNumber(int num) {
        int n = (int) Math.log10(num) + 1;
        int obverseNumber = 0;
        for (int i = 0; i < n; i++) {
            obverseNumber *= 10;
            obverseNumber += num % 10;
            num /= 10;
        }
        return obverseNumber;
    }
}
