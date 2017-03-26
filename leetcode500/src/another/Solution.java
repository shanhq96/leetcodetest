package another;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author shanhq96@gmail.com
 * @ClassName keybord
 * @Description
 * @date 2017/3/26-15:48
 * 一行代码 该方法leetcode运行时间为107ms
 */
public class Solution {

    public String[] findWords(String[] words) {
        return Arrays.stream(words).filter(word->word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
