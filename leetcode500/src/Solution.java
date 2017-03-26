import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author shanhq96@gmail.com
 * @ClassName leetcode500 Keyboard Row
 * @Description Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * @date 2017/3/26-15:08
 * @understand 将键盘的三行字母存在hashmap中.然后判断输入的字符串 该方法leetcode运行时间为4ms
 */
public class Solution {
    HashMap<Character, Integer> keyBordMap = new HashMap<>();//存储键盘位置.

    public String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        initKeyBordMap();
        for (String word : words) {
            String wordAllLower = word.toLowerCase();
            int temp = keyBordMap.get(wordAllLower.charAt(0));
            boolean flag = true;
            for (int i = 1; i < wordAllLower.length(); i++) {
                if (keyBordMap.get(wordAllLower.charAt(i)) != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(word);
            }
        }

        return result.toArray(new String[]{});
    }

    /**
     * 初始化keyBordMap
     */
    private void initKeyBordMap() {
        keyBordMap.put('q', 1);
        keyBordMap.put('w', 1);
        keyBordMap.put('e', 1);
        keyBordMap.put('r', 1);
        keyBordMap.put('t', 1);
        keyBordMap.put('y', 1);
        keyBordMap.put('u', 1);
        keyBordMap.put('i', 1);
        keyBordMap.put('o', 1);
        keyBordMap.put('p', 1);
        keyBordMap.put('a', 2);
        keyBordMap.put('s', 2);
        keyBordMap.put('d', 2);
        keyBordMap.put('f', 2);
        keyBordMap.put('g', 2);
        keyBordMap.put('h', 2);
        keyBordMap.put('j', 2);
        keyBordMap.put('k', 2);
        keyBordMap.put('l', 2);
        keyBordMap.put('z', 3);
        keyBordMap.put('x', 3);
        keyBordMap.put('c', 3);
        keyBordMap.put('v', 3);
        keyBordMap.put('b', 3);
        keyBordMap.put('n', 3);
        keyBordMap.put('m', 3);
    }
}