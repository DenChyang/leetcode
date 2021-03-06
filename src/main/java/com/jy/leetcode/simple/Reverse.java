package com.jy.leetcode.simple;

import com.sun.deploy.util.StringUtils;

/**
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 *
 * 输入: 120
 * 输出: 21
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author DengQiang.Wu
 * @create 2019-05-28 16:33
 */
public class Reverse {

    public int reverse(int x) {

        // 先判断需要转换的整数的位数
        int n = String.valueOf(x).length();

        if (x < 0) {
            n = n-1;
        }

        long result=0;
        for (int i = 0; i < n; i++) {
            int temp = x % 10;
            x = x / 10;
            result = result*10 + temp;
        }

        if (result!=(int)result) {
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int result = reverse.reverse(1534236469);
        System.out.println(result);
    }


}
