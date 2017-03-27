import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shanhq96@gmail.com
 * @ClassName 137_Single Number II
 * @Description Given an array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @date 2017/3/26-19:30
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, test = 1; j < 32; j++,test = test << 1) {
                bits[j] += (nums[i] & test)/test;//将目标数字的每一位与该位为1的二进制数做与,若除测试数字后为1,则该位为1,否则为0;
                //如 3(10)=11(2)    11(2)&10(2)=10(2)=2(10)   2/2=1
            }
        }
        String result = "";
        for (int j = 0; j < 32; j++) {
            result = (bits[j] % 3) + result;
        }
        return Integer.valueOf(result, 2);
    }

    @Test
    public void testSingleNumber() {
        int[] nums = {1, 1, 2, 2, 1, 2, 3};
        Assertions.assertEquals(3, singleNumber(nums));
    }
}
