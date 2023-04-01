package newObject.randomizedSet;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class RandomizedSet {

//    RandomizedSet() 初始化 RandomizedSet 对象
//    bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
//    bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
//    int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。

    // 随机
    // 快速判断val 是否存在
    Set<Integer> set;
    int size;

    public RandomizedSet() {
        set = new LinkedHashSet<>();
        size = 0;
    }

    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            size--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        int index = (int)(Math.random() * size);
        for (Integer value : set) {
            index--;
            if (index <= 0) {
                return value;
            }
        }
        return 0;
    }
}
