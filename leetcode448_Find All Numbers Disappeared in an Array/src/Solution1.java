import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shanhq96@gmail.com  &  qf0302yty@126.com
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
 * @note 见leetcode442
 */
public class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//循环一遍,将数组中的值作为下标的值+数组长度+1.
            nums[nums[i]%(nums.length+1) - 1] += (nums.length+1);
        }
        for (int i = 0; i < nums.length; i++) {//循环一遍数组,对nums.length取模,则数组的值即为(该下标+1)的出现次数
            nums[i] = nums[i]/(nums.length+1);
            if (nums[i] == 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
