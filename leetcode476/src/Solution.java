import org.junit.Test;

/**
 * @author shanhq96@gmail.com
 * @version 1.0
 * @ClassName java class
 * @Description Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * @date 2017/3/25-22:16
 * @understand 求一个数的二进制的补码, 可以通过求该数与和它相同位数的二进制全1进行异或, 结果即为所求
 */
public class Solution {
    public int findComplement(int num) {
        int temp = num >> 1;
        int allbit = 1;
        while (temp!=0){
            temp = temp >> 1;
            allbit = (allbit << 1) + 1;
        }
        return num ^ allbit;
    }
}
