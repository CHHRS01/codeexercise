package leetcode.trie.impl;

/**
 * @author hanrensong
 * @date 2021/8/18
 */

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class WordDictionary {

    private Boolean isEnd;

    /**
     * 下标 对应 英文字符
     * int index = ch - 'a';
     * */
    private WordDictionary[] children;

    public Boolean getEnd() {
        return isEnd;
    }

    public void setEnd(Boolean end) {
        isEnd = end;
    }

    public WordDictionary[] getChildren() {
        return children;
    }

    public void setChildren(WordDictionary[] children) {
        this.children = children;
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        isEnd = false;
        children = new WordDictionary[26];

    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary();
            }
            node = node.children[index];
        }
        node.isEnd = true;

    }

    public boolean search(String word) {
        WordDictionary node = this.searchPrefix(word);
        return node != null && node.isEnd;
    }

    private WordDictionary searchPrefix(String prefix) {
        WordDictionary node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
