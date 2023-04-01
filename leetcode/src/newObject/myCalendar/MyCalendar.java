package newObject.myCalendar;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表 I
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class MyCalendar {
//    MyCalendar() 初始化日历对象。
//    boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。

    List<int[]> booked;

    public MyCalendar() {
        booked = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
