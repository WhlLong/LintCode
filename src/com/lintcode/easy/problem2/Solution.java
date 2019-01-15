package com.lintcode.easy.problem2;

/**
 * 〈Problem2〉
 *
 * @author whl
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