package leetcode.parkingSystem;

/**
 * 1603. 设计停车系统
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
public class ParkingSystem {

    private int bigPark;
    private int mediumPark;
    private int smallPark;

    public ParkingSystem(int big, int medium, int small) {
        bigPark = big;
        mediumPark = medium;
        smallPark = small;
    }

    public boolean addCar(int carType) {
        boolean ans = false;
        switch (carType) {
            case 1:
                if (bigPark != 0) {
                    ans = true;
                    bigPark -=  1;
                }
                break;
            case 2:
                if (mediumPark != 0) {
                    ans = true;
                    mediumPark -=  1;
                }
                break;
            case 3:
                if (smallPark != 0) {
                    ans = true;
                    smallPark -=  1;
                }
                break;
            default:
                ans = false;
        }
        return ans;
    }
}
