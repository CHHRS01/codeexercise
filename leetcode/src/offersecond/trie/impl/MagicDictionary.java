package offersecond.trie.impl;

/**
 * @author hanrensong
 * @date 2021/8/18
 */

import java.util.*;

/**
 * 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-magic-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */

public class MagicDictionary {

    public Set<String> words;
    public Map<String, Integer> count;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new HashSet<>();
        count = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word: words) {
            this.words.add(word);
            for (String nei: generalizedNeighbors(word)) {
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    private ArrayList<String> generalizedNeighbors(String word) {
        ArrayList<String> ans = new ArrayList<>();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    public boolean search(String searchWord) {
        for (String nei: generalizedNeighbors(searchWord)) {
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(searchWord)) {
                return true;
            }
        }
        return false;
    }
}
