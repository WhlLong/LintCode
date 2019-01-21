package com.lintcode.easy.problem39;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈Recover Rotated Sorted Array〉
 *  本质上就是一个排序
 * @author whl
 * @create 2019/1/21
 * @since 1.0.0
 */
public class RecoverRotatedSortedArray {

    public static void main(String[] args) {
        List<Integer> params = new ArrayList<>();
        params.add(2);
        params.add(3);
        params.add(4);
        params.add(1);

        RecoverRotatedSortedArray recoverRotatedSortedArray = new RecoverRotatedSortedArray();
        recoverRotatedSortedArray.recoverRotatedSortedArray(params);
    }

    public void recoverRotatedSortedArray(List<Integer> nums){
        if(nums == null){
            return ;
        }
       for(int i = 0;i<nums.size()-1;i++){
           if(nums.get(i) > nums.get(i+1)){

               //翻转左边
               rotate(nums,0,i);
               //翻转右边
               rotate(nums,i+1,nums.size()-1);
               //全部翻转
               rotate(nums,0,nums.size()-1);

           }
       }
        System.out.println(nums);
    }

    public void rotate(List<Integer> nums,int start,int end){
        int i = start;
        int j = end;
        for(;i<j;i++,j--){
            Integer temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
        }
    }



}