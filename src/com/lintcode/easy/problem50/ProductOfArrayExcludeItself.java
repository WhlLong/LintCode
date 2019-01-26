package com.lintcode.easy.problem50;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExcludeItself {

    public static void main(String[] args) {
        ProductOfArrayExcludeItself productOfArrayExcludeItself = new ProductOfArrayExcludeItself();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        List<Long> result = productOfArrayExcludeItself.productExcludeItself(nums);
        for(Long item : result){
            System.out.print(item+",");
        }
    }

    public List<Long> productExcludeItself(List<Integer> nums) {

        if (nums == null || nums.size() <= 0) {
            return new ArrayList<>();
        }
        List<Long> result = new ArrayList<>();
        if(nums.size() == 1){
            //只有一个数时返回1是题目要求，虽然没有在题目中明确说出，
            //但是根据LintCode返回的结果，当只有一个数时只有返回1才是正确答案。
            result.add(1L);
            return result;
        }
        int length = nums.size();

        //前缀乘积
        Long[] pre = new Long[length];
        pre[0] = nums.get(0).longValue();
        //后缀乘积
        Long[] last = new Long[length];
        last[length - 1] = nums.get(length - 1).longValue();
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums.get(i);
            last[length - 1 - i] = last[length - i] * nums.get(length - 1 - i);
        }

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                result.add(last[i + 1]);
            } else if (i == length - 1) {
                result.add(pre[i-1]);
            } else {
                result.add(pre[i - 1] * last[i + 1]);
            }
        }

        return result;
    }

}
