package com.lintcode.easy.problem9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈Fizz Buzz〉
 *
 * @author whl
 * @create 2019/1/15
 * @since 1.0.0
 */
public class FizzBuzz {

    public static void main(String[] args) {

        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> list = fizzBuzz.fizzBuzz(15);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<String> fizzBuzz(int n) {
        // write your code here
        if(n<0){
            return new ArrayList<>(0);
        }
        List<String> list = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            list.add(i % 15 == 0 ? "fizz buzz" : i % 3 == 0 ? "fizz" : i % 5 == 0 ? "buzz" : i + "");
            i++;
        }

        return list;
    }

}