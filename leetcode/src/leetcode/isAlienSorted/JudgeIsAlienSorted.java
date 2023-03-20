package leetcode.isAlienSorted;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class JudgeIsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {


        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i =1; i < words.length; i++) {
            boolean valid = false;
            for (int j =0; j < words[i].length() && j < words[i - 1].length(); j++) {
                int pre = map[words[i -1].charAt(j) - 'a'];
                int cur = map[words[i].charAt(j) - 'a'];
                if (pre > cur) {
                    return false;
                }
                else if (pre < cur){
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
