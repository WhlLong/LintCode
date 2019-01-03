
# 链接
 [https://www.lintcode.com/problem/a-b-problem/description](https://www.lintcode.com/problem/a-b-problem/description)

# 题目
A + B Problem  
Clarification  
Are a and b both 32-bit integers?  
Yes.

Can I use bit operation?  
Sure you can.

Example  
Given a=1 and b=2 return 3.

Challenge  
Of course you can just return a + b to get accepted. But Can you challenge not do it like that?(You should not use + or any arithmetic operators.)


# 思路
这道题呢，肯定不会是直接让你返回a+b，题目说的很明白了。那么它的考点在哪呢？  
位运算！
可以用异或运算来处理，但是异或运算的特点是当两个数一样时异或运算的结果为0，
两个数不一样时异或运算的结果为1。简单来说就是同为0，异为1。
这样就会带来一个问题，那就是没有办法处理进位，所以异或运算得到的只是没有进位的值。
那么如何处理进位问题呢?
可以使用与运算来处理这个问题，与运算的特点是，同1为1，否则为0，
即当两个数都是1的时候与运算的结果才是1，其他的情况都是0.
而当两个数都是1的时候，也正是需要进位的时候，所以与运算后为1的位置，就是需要进1的位置。
与运算的结果左移一位，得到的就是需要被进一位的位置。

处理思路有了，按照上面的思路，可以得到a+b的结果，但是还是会有问题，如果两个数都很大，得到的结果溢出了该怎么办呢？
原题将返回值限定死了，我们没办法改变，但是自己私下里处理一下还是可以的。