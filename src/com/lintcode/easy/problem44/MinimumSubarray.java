package com.lintcode.easy.problem44;


import java.util.ArrayList;
import java.util.List;

/**
 * 〈问题44 : 最小子数组的和〉
 *
 * @author whl
 * @create 2019/1/26
 * @since 1.0.0
 */
public class MinimumSubarray {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(-5);
        nums.add(10);
        nums.add(-4);

        MinimumSubarray minimumSubarray = new MinimumSubarray();
        int result = minimumSubarray.minSubArray(nums);
        System.out.println(result);
    }

    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() <= 0) {
            return 0;
        }
        if(nums.size() == 1){
            return nums.get(0);
        }
        int ans = nums.get(0);
        int sum = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            sum = Math.min(nums.get(i),sum+nums.get(i));
            ans = Math.min(ans,sum);

        }

        return ans;
    }

}
