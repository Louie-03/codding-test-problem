package programmers.소수만들기;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(int[] nums) {
        boolean[] decimalCheckArray = initDecimalCheckArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
//        Map<Integer, Integer> map = recursive(0, 0, 0, new HashMap<>(), nums);
        int count = 0;
        for (Integer integer : map.keySet()) {
            if (!decimalCheckArray[integer]) {
                count += map.get(integer);
            }
        }
        return count;
    }

    private Map<Integer, Integer> recursive(int startIndex, int sum, int count,
        Map<Integer, Integer> map, int[] nums) {
        if (count == 3) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return map;
        }
        for (int i = startIndex; i < nums.length; i++) {
            recursive(i + 1, sum + nums[i], count + 1, map, nums);
        }
        return map;
    }

    private boolean[] initDecimalCheckArray() {
        int size = 50000;
        boolean[] booleans = new boolean[size];
        booleans[1] = true;
        for (int i = 2; i < Math.sqrt(size); i++) {
            for (int j = i * 2; j < size; j += i) {
                booleans[j] = true;
            }
        }
        return booleans;
    }

    /*
    순열이 아닌 조합이기 때문에 i + 1로 이중 반복문을 실행하는 방법으로 효율성 개선

    최대 50!의 조합의 합이 모두 소수인지 판별해야한다. 효율적으로 구현하는 방법은?
    에라토스테네스의 체를 통해서 2부터 최대 조합의 합의 범위까지 미리 구하고 소수가 몇개인지 한번에 계산한다.
    -> 각 원소의 값은 최대 1000이며 50개 이하의 수이므로 50000까지만 소수인지 판별하면 된다.
      -> 에라토스테네스의 체의 시간복잡도는? O(Nlog logN)
     */

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 7, 6, 4}));
    }

}
