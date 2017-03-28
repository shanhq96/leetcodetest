import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shanhq96@gmail.com & qf0302yty@126.com & 498357435@qq.com
 * @ClassName 41_First Missing Positive
 * @Description Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @date 2017/3/28-14:10
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length ) {//由于数组长度为n,故第一个未出现的正整数一定在1~n+1中.故可将范围外的数置为0
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] % (nums.length + 1)) != 0) {//将出现在数组内的1~n的值进行标记.标记方法为+n+1
                nums[nums[i] % (nums.length + 1) - 1] += (nums.length + 1);
            }
        }
        int j = 0;
        for (; j< nums.length; j++) {
            nums[j] = nums[j] / (nums.length + 1);//根据标记结果计算数组中1~n的数出现的次数,
            if (nums[j] == 0){//数组中第一个为0的元素的下标加1即为结果.
                break;
            }
        }
        result = j+1;
        return result;
    }

    @Test
    public void testFirstMissingPositive() {
        int[] nums1 = {1};
        int[] nums2 = {1,2,0};
        int[] nums3 = {3,4,-1,1};
        int[] nums4 = {};
        int[] nums5 = {2};
        Assertions.assertEquals(2, firstMissingPositive(nums1));
        Assertions.assertEquals(3, firstMissingPositive(nums2));
        Assertions.assertEquals(2, firstMissingPositive(nums3));
        Assertions.assertEquals(1, firstMissingPositive(nums4));
        Assertions.assertEquals(1, firstMissingPositive(nums5));
    }
}
