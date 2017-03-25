/**
 * 461. Hamming Distance Add to List
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *         ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;//x和y进行异或,求得结果的值的二进制所含1的位数即为所求
        return(countBitOfOne(z));
    }

    /**
     * 计算数值二进制中含有多少位1
     * @param target 目标数值
     * @return 二进制中含有1的位数
     */
    private int countBitOfOne(int target) {
        int count = 0;
        while (target != 0) {
            target = target & target - 1;
            count++;
        }
        return count;
    }
}
