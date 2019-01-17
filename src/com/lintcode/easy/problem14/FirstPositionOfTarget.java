package com.lintcode.easy.problem14;

/**
 * 〈First Position of Target 〉
 *
 * @author whl
 * @create 2019/1/17
 * @since 1.0.0
 */
public class FirstPositionOfTarget {

    public static void main(String[] args) {

//        int[] nums = {1,2,4,5,6,7,8,8,8,8,8,8,9,11,13,15,17};
        int[] nums = {1,4,4,5,7,7,8,9,9,10};
        int target = 10;

        FirstPositionOfTarget firstPositionOfTarget = new FirstPositionOfTarget();
        System.out.println(firstPositionOfTarget.binarySearch(nums,target));

    }

    public int binarySearch(int[] nums, int target) {
        // write your code here
        int start = 0;
        int end= nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                while((mid = --mid) >= 0 && nums[mid] == target){

                }
                return ++mid;
            }
            if(nums[mid] > target){
                end = mid - 1;
            }
            if(nums[mid] < target){
                start = mid+1;
            }
        }

        return -1;
    }

}