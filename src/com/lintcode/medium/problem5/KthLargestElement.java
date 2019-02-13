package com.lintcode.medium.problem5;

/**
 * 〈第K大元素〉
 *
 * @author whl
 * @create 2019/2/11
 * @since 1.0.0
 */
public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 8, 6, 7, 9, 12, 80, 45, 23, 67, 78};

        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.kthLargestElement(4, nums));
    }

    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        quicksort(nums, 0, nums.length - 1);

        return nums[n-1];
    }

    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     */
    public void quicksort(int[] arr, int start, int end) {

        if (arr == null || arr.length <= 1 || start >= end) {
            return;
        }

        int left = start;
        int right = end;
        //找到一个基准值
        int val = arr[(left + right) / 2];
        while (left <= right) {
            //从基准值的左边寻找一个大于基准值的数
            while (arr[left] > val) {
                left++;
            }
            //从基准值的右边寻找一个小于基准值的数
            while (arr[right] < val) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if(left == right){
                left++;
            }
        }

        quicksort(arr, start, right);
        quicksort(arr, left, end);
    }

}