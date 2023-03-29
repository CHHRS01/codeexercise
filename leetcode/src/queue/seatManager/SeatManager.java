package queue.seatManager;

import java.util.PriorityQueue;

/**
 * 1845. 座位预约管理系统
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class SeatManager {
    // 小堆
    PriorityQueue<Integer> queue;
    int i;

    public SeatManager(int n) {
        queue=new PriorityQueue<>();
        i = 1;
    }
    public int reserve() {
        if(!queue.isEmpty()) {return queue.poll();}
        else {return i++;}
    }
    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
