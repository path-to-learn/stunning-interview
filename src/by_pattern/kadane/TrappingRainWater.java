package by_pattern.kadane;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * See Leetcode - https://leetcode.com/problems/trapping-rain-water/ for image.
 */
public class TrappingRainWater {

    @Test
    public void verifyTrapWater() {
        int[] water = {0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertTrue(trap(water) == 6);
    }
    public static int trap(int[] height) {
        int result = 0;
        int leftMax  = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        for (int i=0, j= height.length-1; i<j;) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                result+=leftMax-height[i++];
            } else {
                result+=rightMax-height[j--];
            }

        }
        return result;
    }
}
