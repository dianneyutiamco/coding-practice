package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> n = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int x = target - current;
            if (n.containsKey(x)) {
                return new int[]{i, n.get(x)};
            }
            n.put(current, i);
        }
        return null;
    }

    public int[] twoSumBruteForce(int[] nums, int target) {
         for (int i = 0; i < nums.length; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[i] + nums[j] == target) {
                     return new int[]{i, j};
                 }
             }

         }

         return null;
    }
}
