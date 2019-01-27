package com.lintcode.medium.problem3;

public class DigitCounts {

    public static void main(String[] args) {
        DigitCounts digitCounts = new DigitCounts();
        int count = digitCounts.digitCounts(0, 12);
        System.out.println(count);

        int count2 = digitCounts.digitCounts2(0, 12);
        System.out.println(count2);
    }

    public int digitCounts(int k, int n) {
        if (n < k) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= n; i++) {

            if (i == k) {
                count++;
            } else {
                int sum = 1;
                while (sum <= i) {
                    if ((i / sum) % 10 == k) {
                        count++;
                    }
                    sum *= 10;
                }
            }
        }

        return count;
    }


    /**
     * 发散: 如果k的范围不仅限于0-9呢，如果它的范围是0-n
     */
    public int digitCounts2(int k, int n) {
        if (n < k) {
            return 0;
        }
        int count = 0;
        int ten = 10;
        for (int i = 0; i <= n; i++) {

            if (i == k) {
                count++;
            } else {

                int length = String.valueOf(k).length();
                int sum = Math.max((int) Math.pow(ten, length), 1);
                int bc = 1;
                while (sum <= i * ten) {
                    if ((i % sum) / bc == k) {
                        count++;
                    }
                    sum *= ten;
                    bc *= ten;
                }


            }
        }

        return count;
    }
}
