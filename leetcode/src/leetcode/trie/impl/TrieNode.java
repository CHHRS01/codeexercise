package leetcode.trie.impl;

/**
 * @author hanrensong
 * @date 2021/8/25
 */

public class TrieNode {
    public TrieNode[] children;
    public int count;

    public TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}
