package acmicpc.no9251;

public class Main2 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String a = br.readLine();
//        String b = br.readLine();
//        int[][] dp = new int[a.length()][b.length()];
//        for (int i = 0; i < a.length(); i++) {
//            for (int j = 0; j < b.length(); j++) {
//                if (a.charAt(i) == b.charAt(j)) {
//                    if (i == 0 & j == 0) {
//                        dp[i][j] = 1;
//                    }
//                } else {
//                    dp[i][j] =
//                }
//            }
//        }
//    }
/*
  A C A Y K P
C 0 1 1
A 1 1 2
P 1 1 2
C 1 2 2
A 1 2 3
K 1 2 3

A       A
C       C
    A, C
AC      A, AC, C
CA  1   C, CA, A
    A, C
ACA 2   A, AC, AA, ACA, C, CA
CAP     C, CA, CP, CAP, A, AP
    CA
ACAY    A, AC, AA, AY, ACA, ACY, ACAY, C, CA, CY, CAY
CAPC 2  C, CA, CP, CC, CAP, CAC, CAPC, A, AP, AC, APC
    CA, AC
ACAYK
CAPCA
    ACA
ACAYKP
CAPCAK
*/
}
