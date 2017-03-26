/**
 * @author shanhq96@gmail.com
 * @ClassName 485_Max Consecutive Ones
 * @Description Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * @date 2017/3/26-18:47
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp = 0;
            } else {
                temp++;
                max = Math.max(temp, max);
            }
        }
        return max;
    }
}
