package face.trie.impl;

import face.trie.TrieService1;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/26
 */

public class TrieService1Impl implements TrieService1 {

    /**
     * 面试题 17.13. 恢复空格
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     * <p>
     * 注意：本题相对原题稍作改动，只需返回未识别的字符数
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/re-space-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    @Override
    public int respace(String[] dictionary, String sentence) {

        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.getChildren()[t] == null) {
                    break;
                } else if (curPos.getChildren()[t].getEnd()) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.getChildren()[t];
            }
        }
        return dp[n];
    }

    /**
     * 面试题 17.15. 最长单词
     * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
     * <p>
     * 示例：
     * <p>
     * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
     * 输出： "dogwalker"
     * 解释： "dogwalker"可由"dog"和"walker"组成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    @Override
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        List<String> wordList = Arrays.asList(words);
        //排序好，第一个返回的即是结果
        wordList.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        //构造字典树
        for (String word : wordList) {
            insert(word);
        }
        for (String word : wordList) {
            TrieNode cur = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                //排除掉自己组成自己，当前遍历到的字符是个单词，且剩余部分可以再次被切分
                if (i < n - 1 && cur.next.get(c).isEnd && canSplitToWord(word.substring(i + 1))) {
                    return word;
                }
                cur = cur.next.get(c);
            }
        }
        return "";
    }

    private TrieNode root;

    /**
     * 当前的单词可以被切分，在wordList中找到
     *
     * @param remain
     * @return
     */
    private boolean canSplitToWord(String remain) {
        //当没有可以切分的了 返回True
        if (remain.equals("")) return true;
        TrieNode cur = root;
        for (int i = 0; i < remain.length(); i++) {
            char c = remain.charAt(i);//拿到当前的字符
            if (!cur.next.containsKey(c)) return false;//这个节点找不到
            //当前的节点是个单词，且剩余部分可以再次被切分
            if (cur.next.get(c).isEnd && canSplitToWord(remain.substring(i + 1))) {
                return true;
            }
            cur = cur.next.get(c);
        }
        return false;
    }


    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.next.containsKey(c)) {
                TrieNode t = new TrieNode();
                cur.next.put(c, t);
            }
            cur = cur.next.get(c);
        }
        cur.isEnd = true;
    }


    class TrieNode {
        Map<Character, TrieNode> next = new HashMap<>();
        boolean isEnd = false;
    }
    /**
     * 面试题 17.17. 多次搜索
     * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multi-search-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param big
     * @param smalls
     * @return
     */
    @Override
    public int[][] multiSearch(String big, String[] smalls) {
        WordTrieNode root = new WordTrieNode();
        Map<String,List<Integer>> map = new HashMap<>();
        //构建字典树
        for (String small : smalls) {
            map.put(small,new ArrayList<>());
            insert(root,small);
        }
        //寻找所有单词在big中的起始位置，并存放在map中
        for(int i=0;i<big.length();i++){
            search(root, i, big,map);
        }
        //输出结果
        int[][] ans = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            ans[i] = map.get(smalls[i]).stream().mapToInt(Integer::valueOf).toArray();
        }
        return ans;
    }

    //构建后缀树
    public void insert(WordTrieNode root,String word){
        WordTrieNode node = root;
        for (int i = word.length()-1; i >=0; i--) {
            int idx = word.charAt(i)-'a';
            if(node.childs[idx]==null){
                node.childs[idx] = new WordTrieNode();
            }
            node = node.childs[idx];
        }
        node.isWord = true; //表示单词的结尾
    }

    //寻找以endPos结尾的所有单词的起始位置
    public void search(WordTrieNode root,int endPos,String sentence,Map<String,List<Integer>> map){
        WordTrieNode node = root;
        StringBuilder builder = new StringBuilder(); //单词作为key
        for(int i=endPos;i>=0;i--){
            int idx = sentence.charAt(i)-'a';
            if(node.childs[idx]==null){
                break;
            }
            //由于字典树存的是后缀，故要倒着插入
            builder.insert(0,sentence.charAt(i));
            node = node.childs[idx];//递归寻找
            //找到某个单词，就把起始位置添加到map中
            if(node.isWord){
                map.get(builder.toString()).add(i);
            }
        }
    }
}
