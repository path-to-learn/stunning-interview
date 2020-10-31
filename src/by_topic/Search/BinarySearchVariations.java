package by_topic.Search;

import org.junit.Assert;
import org.junit.Test;

/**
 * Binary Search code with some variations when items are duplicate
 */
public class BinarySearchVariations {

    @Test
    public void testBinarySearch() {
        int[] arr = {1,2,4,4,4,9};
        Assert.assertTrue(binarySearchStart(arr, 4) == 2); // initial index of 4
        Assert.assertTrue(binarySearchEnd(arr, 4) == 4); // last index of 4
    }

    private int binarySearchEnd(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){  // making sure we go to left when any matching index is found..
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid; // We Are not breaking, when found rather keep checking left
        }
        return idx;
    }

    private static int binarySearchStart(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){  // making sure we go to right when any matching index is found..
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid; // We Are not breaking, when found rather keep checking right
        }
        return idx;
    }



}
