package leetcode.trie.impl;

import java.util.HashMap;

/**
 * @author hanrensong
 * @date 2021/8/25
 */

public class StringTreeNode {
    public String s;
    public HashMap<String, StringTreeNode> children;
    public String folder;

    public StringTreeNode() {

    }
}
