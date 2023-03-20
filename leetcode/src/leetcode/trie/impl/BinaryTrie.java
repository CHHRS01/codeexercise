package leetcode.trie.impl;

/**
 * @author hanrensong
 * @date 2021/8/24
 */

public class BinaryTrie {

    public int val;
    public BinaryTrie[] child;

    public BinaryTrie(int val) {
        this.val = val;
        this.child = new BinaryTrie[2];
    }
}
