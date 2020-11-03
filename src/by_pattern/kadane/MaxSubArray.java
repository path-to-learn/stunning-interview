package by_pattern.kadane;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Example:
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int previousMaxSum = nums[0];
        int globalMax = Math.max(Integer.MIN_VALUE, previousMaxSum);
        for (int i=1; i<nums.length;i++) {
            previousMaxSum = Math.max(nums[i], previousMaxSum + nums[i]);
            globalMax = Math.max(globalMax, previousMaxSum);
        }
        return globalMax;
    }

    @Test
    public void testMaxSubArray() {
        int[] num = {-2,1,-3,4,-1,2,1,-5,4};
        int result =maxSubArray(num);
        System.out.println(result);
        Assert.assertTrue(result == 6);
    }
}
