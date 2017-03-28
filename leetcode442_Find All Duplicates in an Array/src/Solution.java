import java.util.ArrayList;
import java.util.List;

/**
 * @author shanhq96@gmail.com &  qf0302yty@126.com
 * @ClassName 442_Find All Duplicates in an Array
 * @Description Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [2,3]
 * @date 2017/3/28-8:48
 * @note 该算法由qf0302yty@126.com最开始提出雏形,然后我们合力进行修改调优.
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//循环一遍,将数组中的值作为下标的值+数组长度+1.
            nums[nums[i]%(nums.length+1) - 1] += (nums.length+1);
        }
        for (int i = 0; i < nums.length; i++) {//循环一遍数组,对nums.length取模,则数组的值即为(该下标+1)的出现次数
            nums[i] = nums[i]/(nums.length+1);
            if (nums[i] == 2){
                result.add(i+1);
            }
        }
        return result;
    }
}