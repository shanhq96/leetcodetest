import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shanhq96@gmail.com
 * @ClassName 260_Single Number III
 * @Description Given an array of numbers nums,
 * in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @date 2017/3/27-13:53
 */
public class Solution {
    /**
     * 思路:先将所有的数字进行异或,设结果为diff,diff即为两个出现了一次的数字的异或值.
     * 那么该如何利用diff将原数组分为两个小数组(每个数组包含一个只出现了一次的值).
     * 然后分别对两个数组内部进行异或,结果即为所求
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int diff = 0;
        for (int num : nums){
            diff ^= num;
        }
        diff = Integer.highestOneBit(diff);
        for (int num : nums){
            if ((diff & num) == 0){
                result[0] ^= num;
            }else {
                result[1] ^= num;
            }
        }
        return result;
    }

    @Test
    public void testSingleNumberIII(){
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = {3,5};
        Assertions.assertArrayEquals(result,singleNumber(nums));
    }
}