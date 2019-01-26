package com.lintcode.easy.problem46;

import com.lintcode.easy.problem35.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈问题46 : 求大多数成员〉
 *
 * @author whl
 * @create 2019/1/26
 * @since 1.0.0
 */
public class MajorityElement {


    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        int result = majorityElement.majorityNumber(list);
        System.out.println(result);
    }


    public int majorityNumber(List<Integer> nums) {
        if(nums == null || nums.size()<=0){
            return 0;
        }
        // write your code here
        int majorNum = 0;
        int count = 0;
       for(Integer num:nums){
           if(count == 0){
               majorNum = num;
           }
           if(num == majorNum){
               count++;
           }else{
               count--;
           }
       }
       return majorNum;
    }

}
