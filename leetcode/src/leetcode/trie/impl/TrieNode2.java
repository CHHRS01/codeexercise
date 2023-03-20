package leetcode.trie.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanrensong
 * @date 2021/8/25
 */

public class TrieNode2 {

    public boolean end;
    public String str;
    public int count;
    public TrieNode2[] children;

    public TrieNode2() {
        end = false;
        str = null;
        count = 0;
        children = new TrieNode2[26];
    }

    public void insert(String[] products){
        for(String str : products){
            insertWord(str);
        }
    }
    private void insertWord(String products){
        TrieNode2 node = this;
        for(char c : products.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode2();
            }
            node = node.children[c - 'a'];
        }
        if(!node.end){
            node.end = true;
            node.str = products;
        }
        node.count++;
    }
    public List<List<String>> searchWord(String word){
        List<List<String>> result = new ArrayList<>();
        for(int i = 1; i <= word.length(); i++){
            result.add(search(word.substring(0, i)));
        }
        return result;
    }
    private List<String> search(String pattern){
        List<String> result = new ArrayList<>();
        TrieNode2 node = this;
        for(char c : pattern.toCharArray()){
            if(node.children[c - 'a'] == null){
                return result;
            }
            node = node.children[c - 'a'];
        }
        solution(node, result);
        return result;
    }
    private void solution(TrieNode2 root, List<String> result){
        if(root.end){
            for(int i = 0; i < root.count; i++){
                result.add(root.str);
                if(result.size() == 3){
                    return;
                }
            }
        }
        for(TrieNode2 node : root.children){
            if(node != null){
                solution(node, result);
            }
            if(result.size() == 3){
                return;
            }
        }
    }
}
