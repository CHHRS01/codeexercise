package newObject.randomizedSet;

/**
 * 《功能》
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class TestRS {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());

    }
}
