/**
 * Copyright (C), 2015-2019, 章鱼云商
 * FileName: Solution
 * Author:   wanghuailong
 * Date:     2019/1/3 14:06
 * Description: Problem2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lintcode.easy.problem2;

/**
 * 〈Problem2〉
 *
 * @author wanghuailong
 * @create 2019/1/3
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeros(25));
    }

    public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

}