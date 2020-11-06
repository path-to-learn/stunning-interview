package by_pattern.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all the combination of numbers in an array which sum upto k.
 * Note that numbers in array can be repetitive.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        backTrack(sets,new ArrayList<Integer>(),candidates,0,target,candidates.length-1);
        return sets;
    }
    public static void backTrack(List<List<Integer>> sets,List<Integer> path,int[] nums,int sum,int target,int index) {
        if (sum == target) {
            sets.add( new ArrayList<Integer>( path ) );
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i >= 0; i--) {
            sum += nums[i];
            path.add( 0, nums[i] );
            backTrack( sets, path, nums, sum, target, i );
            sum -= nums[i];
            path.remove( 0 );
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(arr, 6);
        for (List<Integer> arrayList : list) {
            for (Integer in : arrayList)
                System.out.print(in + " ");
            System.out.println(""  );
        }
    }
}
