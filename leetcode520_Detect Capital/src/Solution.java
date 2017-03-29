/**
 * @author shanhq96@gmail.com
 * @ClassName 520_Detect Capital
 * @Description Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * @date 2017/3/28-15:26
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean result = true;
        if (word != null && word.length() != 0) {
            String temp = word;
            if (Character.isUpperCase(word.charAt(0))) {//第一个字母是大写
                temp = word.substring(1);
            }
            result = temp.equals(temp.toLowerCase()) || temp.equals(temp.toUpperCase());
        }
        return result;
    }
}
