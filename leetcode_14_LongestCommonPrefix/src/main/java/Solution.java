import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shanhongqiang (shanhq96@gmail.com)
 * Date: 2017/8/25
 * Time: 17:22
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            StringBuilder commonPrefix = new StringBuilder();
            int minLength = Integer.MAX_VALUE;
            for (String temp : strs) {
                if(temp.equals("")){
                    return "";
                }
                minLength = Math.min(minLength, temp.length());
            }
            for (int i = 0; i < minLength; i++) {
                boolean flag = true;
                char currentChar = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (currentChar != strs[j].charAt(i)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    commonPrefix.append(Character.toString(currentChar));
                }else {
                    break;
                }
            }
            return commonPrefix.toString();
        }
    }

    /**
     * 以下为学习到的算法，很强大。先对数组进行排序，然后再比较第一个元素和最后一个元素。
     */
    /*public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {

            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }*/

}
