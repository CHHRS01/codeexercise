package newObject.myCircularQueue;

/**
 * 《功能》
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class TestMCQ {

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(81);
        System.out.println(obj.enQueue(69));
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(92));
        System.out.println(obj.enQueue(12));
        System.out.println(obj.deQueue());
        System.out.println(obj.isFull());
        System.out.println(obj.isFull());
        System.out.println(obj.Front());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(28));
        System.out.println(obj.Front());


        System.out.println(obj.Rear());
        System.out.println(obj.isEmpty());
        System.out.println(obj.isFull());
    }
}
