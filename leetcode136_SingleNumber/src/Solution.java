/**
 * @author shanhq96@gmail.com
 * @ClassName 136_Single Number
 * @Description Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @date 2017/3/26-18:55
 */
public class Solution {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];//所有值异或的结果即为所求
        }
        return nums[0];
    }
}
