import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanhq96@gmail.com
 * @ClassName 448_Find All Numbers Disappeared in an Array
 * @Description Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 * @date 2017/3/27-14:33
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//循环一遍,将(数组中的值-1)为下标的位置的值变为负值
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {//循环一遍数组,若仍为正直,则代表该(下标+1)的值未出现在数组中.
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

    @Test
    public void testFindDisappearedNumbers() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new ArrayList<>();
        result.add(5);
        result.add(6);
        Assertions.assertArrayEquals(result.toArray(), findDisappearedNumbers(nums).toArray());
    }
}
