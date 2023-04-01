package newObject.myCalendar;

import java.util.TreeSet;

/**
 * 《功能》
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class MyCalendar2 {
    TreeSet<int[]> booked;

    public MyCalendar2() {
        booked = new TreeSet<int[]>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        if (booked.isEmpty()) {
            booked.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        int[] arr = booked.ceiling(tmp);
        int[] prev = arr == null ? booked.last() : booked.lower(arr);
        if (arr == booked.first() || booked.lower(tmp)[1] <= start) {
            booked.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}
