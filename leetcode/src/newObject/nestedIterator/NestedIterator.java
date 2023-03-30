package newObject.nestedIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int index;

    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            }
            else {
                add(nestedInteger.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.index = 0;
        // 递归加入
        this.add(nestedList);
    }

    @Override
    public Integer next() {
        return this.list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < this.list.size();
    }
}
