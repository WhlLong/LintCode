package com.lintcode.easy.problem6;

import java.util.Arrays;
import java.util.Calendar;

/**
 *  LintCode Problem 6
 *  https://www.lintcode.com/problem/merge-two-sorted-arrays/description
 * 〈Merge Two Sorted Arrays〉
 *
 * @author whl
 * @create 2019/1/15
 * @since 1.0.0
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {1,3,4,5};
        int[] b = {1,2,3,4,5};
        System.out.println(Arrays.toString(merge(a,b)));
    }

    private static int[] merge(int[] a,int[] b){
        long start = Calendar.getInstance().getTime().getTime();

        int index = 0;    //新数组下标
        int aIndex = 0;  //a数组下标
        int bIndex = 0;  //b数组下标
        int[] newArray = new int[a.length+b.length];
        while(aIndex < a.length && bIndex < b.length){
            if(a[aIndex] <= b[bIndex]){
                newArray[index++] = a[aIndex++];
            }else{
                newArray[index++] = b[bIndex++];
            }
        }

        while(aIndex < a.length){
            newArray[index++] = a[aIndex++];
        }

        while(bIndex < b.length){
            newArray[index++] = b[bIndex++];
        }

        long end = Calendar.getInstance().getTime().getTime();
        System.out.println(end - start);

        return newArray;
    }

}