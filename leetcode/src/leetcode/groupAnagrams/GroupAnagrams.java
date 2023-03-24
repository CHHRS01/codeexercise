package leetcode.groupAnagrams;

import java.util.*;

/**
 * 1290. 二进制链表转整数
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new LinkedHashMap<>();
        StringBuilder sb;
        List<String> tmp;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            if (map.containsKey(s)) {
                tmp = map.get(s);
            }
            else {
                tmp = new LinkedList<>();
                map.put(s, tmp);
            }
            tmp.add(str);
        }
        List<List<String>> ans = new LinkedList<>();
        ans.addAll(map.values());

        return ans;
    }
}
