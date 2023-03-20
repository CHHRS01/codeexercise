package leetcode.trie.impl;

import leetcode.trie.TrieService1;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/18
 */


public class TrieService1Impl implements TrieService1 {

    /**
     * 139. 单词拆分---dp
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * <p>
     * 说明：
     * <p>
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param wordDict
     */
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 386. 字典序排数
     * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
     * <p>
     * 例如，
     * <p>
     * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     * <p>
     * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     */
    @Override
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n,int i,List<Integer>list){
        if(i>n){
            return ;
        }
        list.add(i);
        for(int j=0;j<=9;j++){
            dfs(n,i*10+j,list);
        }
    }

    /**
     * 421. 数组中两个数的最大异或值
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     * <p>
     * 进阶：你可以在 O(n) 的时间解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
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

    /**
     * 648. 单词替换
     * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
     * <p>
     * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
     * <p>
     * 你需要输出替换之后的句子。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/replace-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dictionary
     * @param sentence
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
     * 692. 前K个高频单词
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * <p>
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     *
     * @param words
     * @param k
     */
    @Override
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }

    /**
     * 792. 匹配子序列的单词数
     * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
     *
     * @param s
     * @param words
     */
    @Override
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        ArrayList<WordNode>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i) {
            heads[i] = new ArrayList<>();
        }

        for (String word: words) {
            heads[word.charAt(0) - 'a'].add(new WordNode(word, 0));
        }

        for (char c: s.toCharArray()) {
            ArrayList<WordNode> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();

            for (WordNode node: old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

    /**
     * 820. 单词的压缩编码
     * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
     * <p>
     * words.length == indices.length
     * 助记字符串 s 以 '#' 字符结尾
     * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
     * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
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
     * 1023. 驼峰式匹配
     * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
     * <p>
     * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/camelcase-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param queries
     * @param pattern
     */
    @Override
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>(queries.length);
        for (String query : queries) {
            String other = getOther(query, pattern);
            if (other.equals("")) {
                res.add(false);
            } else {
                res.add(other.toLowerCase().equals(other));
            }
        }
        return res;
    }

    private static String getOther(String query, String pattern) {
        int index = 0;
        StringBuilder sb = new StringBuilder("a"); // 避免两个串相等时返回""
        for (int i = 0; i < pattern.length(); i++) {
            char t = pattern.charAt(i);
            int index2 = query.indexOf(t, index);
            if (index2 < 0) {
                return "";
            }
            sb.append(query, index, index2);
            index = index2 + 1;
        }
        sb.append(query.substring(index));
        return sb.toString();
    }

    /**
     * 1233. 删除子文件夹
     * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
     * <p>
     * 我们这样定义「子文件夹」：
     * <p>
     * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
     * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
     * <p>
     * / 后跟一个或者多个小写英文字母。
     * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param folder
     */
    @Override
    public List<String> removeSubfolders(String[] folder) {
        HashMap<String, StringTreeNode> tree = new HashMap<>();
        for (String s : folder) {
            if (s.length() <= 1) {
                continue;
            }

            String[] befores = s.split("/");
            HashMap<String, StringTreeNode> currentLevel = tree;
            StringTreeNode node = null;
            for (int i = 1; i < befores.length; i++) {
                node = currentLevel.get(befores[i]);
                if (node == null) {
                    node =  new StringTreeNode();
                    node.s = befores[i];
                    node.children = new HashMap();
                    currentLevel.put(befores[i], node);
                } else {
                    if (node.folder != null) {
                        break;
                    }
                }
                currentLevel = node.children;
            }
            if (node.folder == null) {
                node.folder = s;
            }
        }

        for (StringTreeNode node : tree.values()) {
            this.checkFolder(node);
        }
        return result;
    }

    private List<String> result = new LinkedList<>();

    private void checkFolder(StringTreeNode node) {
        if (node.folder != null) {
            this.result.add(node.folder);
            return;
        }

        if (node.children != null) {
            for (StringTreeNode child : node.children.values()) {
                this.checkFolder(child);
            }
        }
    }

    /**
     * 1268. 搜索推荐系统
     * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
     * <p>
     * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
     * <p>
     * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-suggestions-system
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param products
     * @param searchWord
     */
    @Override
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode2 trie = new TrieNode2();
        trie.insert(products);
        return trie.searchWord(searchWord);
    }
}
