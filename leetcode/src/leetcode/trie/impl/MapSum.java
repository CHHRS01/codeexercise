package leetcode.trie.impl;

/**
 * @author hanrensong
 * @date 2021/8/18
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */

public class MapSum {

    public Map<Character, MapSum> child;
    public int val;

    /** Initialize your data structure here. */
    public MapSum() {
        child = new HashMap<>(26);
        val = 0;
    }

    public void insert(String key, int val) {
        MapSum root = this;
        for (int i = 0; i < key.length(); i ++) {
            char c = key.charAt(i);
            if (!root.child.containsKey(c)) {
                root.child.put(c, new MapSum());
            }
            root = root.child.get(c);
        }
        root.val = val;
    }

    public int sum(String prefix) {
        MapSum root = this;
        for (int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if (!root.child.containsKey(c)) {
                return 0;
            }
            root = root.child.get(c);
        }
        return dfs(root);
    }

    private int dfs(MapSum root) {
        if (root == null) {
            return 0;
        }
        int res = root.val;
        for (MapSum ch : root.child.values()) {
            res += dfs(ch);
        }
        return res;
    }
}
