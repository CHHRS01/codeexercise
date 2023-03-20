package entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanrensong
 * @date 2021/8/9
 */

public class PrefixNode {
    public Map<String, PrefixNode> children;
    public boolean isEnd;

    public PrefixNode() {
        children = new HashMap<>();
    }
}
