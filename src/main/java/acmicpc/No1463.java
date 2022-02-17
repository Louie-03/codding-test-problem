package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1463 {
    public static int no1463(int n) {
        int[] dpArray = new int[n + 1];
        dpArray[1] = 0;
        for (int i = 2; i <= n; i++) {
            dpArray[i] = dpArray[i - 1] + 1;
            if (i % 3 == 0) {
                dpArray[i] = Math.min(dpArray[i], dpArray[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dpArray[i] = Math.min(dpArray[i], dpArray[i / 2] + 1);
            }

//            아래와 같이 구현했지만 메모리 초과로 틀렸다.
//            List를 쓰면 공간 복잡도가 매우 늘어난다는 것을 예상했지만 다른 방법이 기억나지 않아서 결국 유튜브에 있는 정답을 봤다.
//            List<Integer> list = new ArrayList<>();
//            list.add(dpArray[i - 1] + 1);
//            if (i % 3 == 0) {
//                list.add(dpArray[i / 3] + 1);
//            }
//            if (i % 2 == 0) {
//                list.add(dpArray[i / 2] + 1);
//            }
//            dpArray[i] = list.stream().mapToInt(x -> x).min().orElseThrow();
        }
        return dpArray[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(no1463(n));
    }
}
