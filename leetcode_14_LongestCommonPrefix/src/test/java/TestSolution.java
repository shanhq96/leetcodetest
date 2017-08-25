import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: shanhongqiang
 * Date: 2017/8/25
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void testLongestCommonPrefix() {
        String[] strs = {"aca","cba"};
        String result = solution.longestCommonPrefix(strs);
        Assert.assertEquals("",result);
    }
}
