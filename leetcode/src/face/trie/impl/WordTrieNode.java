package face.trie.impl;

/**
 * @author hanrensong
 * @date 2021/8/27
 */

public class WordTrieNode {
    public WordTrieNode[] childs;
    public boolean isWord;
    public WordTrieNode(){
        isWord = false;
        childs = new WordTrieNode[26];
    }
}
