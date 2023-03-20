package offersecond.trie;

import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/26
 */

public interface TrieService1 {

    /**
     * 剑指 Offer II 063. 替换单词
     *
     * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     *
     * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     *
     * 需要输出替换之后的句子。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/UhWRSj
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param dictionary
     * @param sentence
     * @return
     */
    String replaceWords(List<String> dictionary, String sentence);

    /**
     * 剑指 Offer II 065. 最短的单词编码
     *
     * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
     *
     * words.length == indices.length
     * 助记字符串 s 以 '#' 字符结尾
     * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
     * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/iSwD2y
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param words
     * @return
     */
    int minimumLengthEncoding(String[] words);

    /**
     * 剑指 Offer II 067. 最大的异或
     * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     * @param nums
     * @return
     */
    int findMaximumXOR(int[] nums);
}
