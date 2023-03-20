package face.trie;

import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/26
 */

public interface TrieService1 {

    /**
     * 面试题 17.13. 恢复空格
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     *
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/re-space-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param dictionary
     * @param sentence
     * @return
     */
    int respace(String[] dictionary, String sentence);

    /**
     * 面试题 17.15. 最长单词
     * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
     *
     * 示例：
     *
     * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
     * 输出： "dogwalker"
     * 解释： "dogwalker"可由"dog"和"walker"组成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param words
     * @return
     */
    String longestWord(String[] words);


    /**
     * 面试题 17.17. 多次搜索
     * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multi-search-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param big
     * @param smalls
     * @return
     */
    int[][] multiSearch(String big, String[] smalls);

}
