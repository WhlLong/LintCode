package com.lintcode.easy.problem8;

import java.util.Arrays;

/**
 * 〈Rotate String〉
 *
 * @author whl
 * @create 2019/1/15
 * @since 1.0.0
 */
public class RotateString {

    public static void main(String[] args) {
            String str = "cppjavapy";
        rotate(str.toCharArray(),25);
    }

    private static void rotate(char[] str,int offset){

        if(str == null || str.length == 0 ){
            return ;
        }

        offset %= str.length;

        rotate(str,0,str.length-1);
        rotate(str,0,offset-1);
        rotate(str,offset,str.length-1);

        for(char c : str){
            System.out.print(c);
        }
    }

    private static void rotate(char[] strs,int start,int end){

        for(int i=start,j=end;i<j;i++,j--){
            char temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }

    }


}