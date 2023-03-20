package offersecond.trie.impl;

import offersecond.trie.TrieService1;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/26
 */

public class TrieService1Impl implements TrieService1 {

    /**
     * 剑指 Offer II 063. 替换单词
     * <p>
     * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * <p>
     * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * <p>
     * 需要输出替换之后的句子。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/UhWRSj
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    @Override
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> rootSet = new HashSet<>(dictionary);
        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(prefix);
        }
        return ans.toString();
    }

    /**
     * 剑指 Offer II 065. 最短的单词编码
     * <p>
     * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
     * <p>
     * words.length == indices.length
     * 助记字符串 s 以 '#' 字符结尾
     * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
     * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/iSwD2y
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    @Override
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0) {
                ans += words[nodes.get(node)].length() + 1;
            }
        }
        return ans;
    }

    /**
     * 剑指 Offer II 067. 最大的异或
     * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     *
     * @param nums
     * @return
     */
    @Override
    public int findMaximumXOR(int[] nums) {

        int res = 0;
        int mask = 0;

        for(int i = 30; i >= 0; i--){
            mask = mask | (1 << i);

            HashSet<Integer> set = new HashSet<>();

            //拿到所有数字的前缀
            for(int num : nums) {
                set.add(num & mask);
            }

            int targetMax = res | (1 << i);
            for(Integer prefix : set){
                int temp = prefix ^ targetMax;

                if(set.contains(temp)){
                    res = targetMax;
                    break;
                }
            }
        }

        return res;
    }
}
