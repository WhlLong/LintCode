package com.lintcode.easy.problem41;

/**
 * 〈问题41 : 最大子数组〉
 *
 * @author whl
 * @create 2019/1/25
 * @since 1.0.0
 */
public class MaximumSubarray {

    public static void main(String[] args) {

        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int[] arr = {-2,2,-3,4,-1,2,1,-5,3};
        int result = maximumSubarray.maxSubArray(arr);
        System.out.println(result);
    }


    public int maxSubArray(int[] nums) {
        // write your code here
        int ans=0;  //记录最大子数组的和
        int sum=0;  //记录区间和，如果sum>0,就可以继续和后面的元素求和，否则就从当前的i代表的元素开始重新计算sum
        for(int i=0;i<nums.length;i++){
            //如果nums[i]大，最大子数组从nums[i]开始
            //这里nums[i]比较大的时候，一定是因为sum<=0,如果sum>0  那么一定是sum+nums[i]比较大
            sum=Math.max(nums[i],sum+nums[i]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }



    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录前i个数的和，minSum记录前i个数中0-k的最小值
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }

}