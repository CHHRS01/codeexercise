package linesegmenttree.myCalendar;

import java.util.HashSet;
import java.util.Set;

/**
 * 729. 我的日程安排表 I
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class MyCalendar3 {

//    MyCalendar3() 初始化日历对象。
//    boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。

    Set<Integer> tree;
    Set<Integer> lazy;

    public MyCalendar3() {
        tree = new HashSet<Integer>();
        lazy = new HashSet<Integer>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 1000000000, 1)) {
            return false;
        }
        update(start, end - 1, 0, 1000000000, 1);
        return true;
    }

    public boolean query(int start, int end, int l, int r, int idx) {
        if (start > r || end < l) {
            return false;
        }
        /* 如果该区间已被预订，则直接返回 */
        if (lazy.contains(idx)) {
            return true;
        }
        if (start <= l && r <= end) {
            return tree.contains(idx);
        } else {
            int mid = (l + r) >> 1;
            if (end <= mid) {
                return query(start, end, l, mid, 2 * idx);
            } else if (start > mid) {
                return query(start, end, mid + 1, r, 2 * idx + 1);
            } else {
                return query(start, end, l, mid, 2 * idx) | query(start, end, mid + 1, r, 2 * idx + 1);
            }
        }
    }

    public void update(int start, int end, int l, int r, int idx) {
        if (r < start || end < l) {
            return;
        }
        if (start <= l && r <= end) {
            tree.add(idx);
            lazy.add(idx);
        } else {
            int mid = (l + r) >> 1;
            update(start, end, l, mid, 2 * idx);
            update(start, end, mid + 1, r, 2 * idx + 1);
            tree.add(idx);
        }
    }

}
