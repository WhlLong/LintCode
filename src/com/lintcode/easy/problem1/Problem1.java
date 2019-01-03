package com.lintcode.easy.problem1;

public class Problem1 {

    public static void main(String[] args) {

        problem1_2(3,5);

        //处理溢出问题
        problem1_2(2111111111,2111111111);

    }

    /**
     * 位运算
     * 异或运算: 无法处理溢出，除非将int类型转换为long类型
     * @param a
     * @param b
     */
    private static void problem1_1(int a,int b){

        while(b != 0){
           int aa = a^b;
           int bb = (a & b) << 1;

           a = aa;
           b = bb;
        }

//        return a;
        System.out.println(a);
    }


    /**
     * 边界溢出问题
     *
     */
    public static void problem1_2(int a,int b){
        String strA = a+"";
        String strB = b+"";

        //如果不存在溢出的可能
        if(strA.length() <= 9 || strB.length() <= 9){
             problem1_1(a,b);
             return ;
        }

        //如果存在溢出的可能
        //两个数相加，只有其中一个数的长度是10，才有可能出现溢出
        //如果存在溢出，就使用数组来处理
        if((strA.length() == 10 && strB.length() >= 9) || (strA.length() >= 9 && strB.length() == 10)){
            int[] arrA = new int[strA.length()];
            int[] arrB = new int[strB.length()];
            int[] result = new int[10];

            for(int i=0;i<strA.length();i++){
                arrA[i] = Integer.parseInt(strA.charAt(strA.length()-1-i)+"");
            }
            for(int i=0;i<strB.length();i++){
                arrB[i] = Integer.parseInt(strA.charAt(strB.length()-1-i)+"");
            }

            for(int i=0;i<result.length;i++){
                if(i < 9){

                    int r = arrA[i] + arrB[i];
                    if(r < 10){
                        result[i] = r;
                    }else{
                        result[i] = result[i]+(r-10);
                        result[i+1] = 1;
                    }
                }else{
                    if(arrA.length == 10){
                        result[i] = result[i]+arrA[i];
                    }
                    if(arrB.length == 10){
                        result[i] = result[i]+arrB[i];
                    }
                }
            }

            for(int i=0;i<result.length;i++){
                System.out.print(result[result.length-1-i]);
            }
        }


    }
}
