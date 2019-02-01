package com.lintcode.medium.problem4;

import java.util.Calendar;
import java.util.Date;

/**
 * 丑数的定义: 丑数就是只包含质因子2、3、5的数
 * 判断方法: 首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。
 * 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int result = uglyNumber.nthUglyNumber(1665);
        System.out.println(result);

    }

    /**
     * 暴力遍历，可以得到正确结果但是非常耗时
     * 经测试 n=1665时，所需时间为33979ms,非常可怕
     *
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int index = 1;
        while (count < n) {
            if (isUgly(index)) {
                count++;
            }
            index++;
        }

        return index - 1;
    }


    private boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        while (num >= 2 && num % 2 == 0) {
            num /= 2;
        }
        while (num >= 3 && num % 3 == 0) {
            num /= 3;
        }
        while (num >= 5 && num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }


    /**
     * 遍历法由于耗时太久 ，所以是行不通的，只能考虑其他算法
     * 思路:
     * 所有的丑数都可以通过它前面的某个丑数乘以2或乘以3或乘以5得到
     * 比如1是丑数 那么1*2  1*3  1*5必定也是丑数
     */
    public int nthUglyNumber(int n) {
        int x = 0;
        int y = 0;
        int z = 0;

        int counts = 1;
        int[] items = new int[n];
        items[0] = 1;

        while (counts < items.length) {

            int min = min(items[x] * 2, items[y] * 3, items[z] * 5);
            if (min == items[x] * 2) {
                x++;
            }
            if (min == items[y] * 3) {
                y++;
            }
            if (min == items[z] * 5) {
                z++;
            }

            items[counts] = min;
            counts++;
        }



        return items[counts-1];
    }

    private int min(int i, int j, int k) {
        int min = Math.min(i, j);
        return Math.min(min, k);
    }
}
