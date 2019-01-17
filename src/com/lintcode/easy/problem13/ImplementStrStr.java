/**
 * Copyright (C), 2015-2019, 章鱼云商
 * FileName: ImplementStrStr
 * Author:   wanghuailong
 * Date:     2019/1/17 11:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lintcode.easy.problem13;

/**
 * 〈〉
 *
 * @author wanghuailong
 * @create 2019/1/17
 * @since 1.0.0
 */
public class ImplementStrStr {

    public static void main(String[] args) {

        String mainStr = "aklflsdfjmdabababdgfdhdfgdf";
        String modelStr = "abababdgf";

        ImplementStrStr kmp = new ImplementStrStr();
        int pos = kmp.strStr(mainStr, modelStr);
        System.out.println(pos);
    }


    public int strStr(String source, String target) {
        if(source==null || target == null){
            return -1;
        }
        if("".equals(source) && "".equals(target)){
            return 0;
        }
        if("".equals(source) && !"".equals(target)){
            return -1;
        }
        if(!"".equals(source) && "".equals(target)){
            return 0;
        }


        int i = 0;
        int j = 0;
        int[] next = new int[target.length()];
        next(target, next);

        while(i < source.length() && j < target.length()){
            if(j == -1 || source.charAt(i) == target.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }


            if(j == target.length()){
                return i - j;
            }
        }

        return -1;
    }

    public void next(String target, int[] next) {
        int i = 0; //前缀位置
        int j = -1;  //后缀位置
        next[0] = -1;
        while(i < next.length-1){
            if(j == -1 || target.charAt(i) == target.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }

    }

}