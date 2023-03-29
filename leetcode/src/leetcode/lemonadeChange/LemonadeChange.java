package leetcode.lemonadeChange;

/**
 * 860. 柠檬水找零
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {

        int[] count = new int[2];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count[0] +=1;
            }
            else if (bills[i] == 10) {
                if (count[0] > 0) {
                    count[0] -= 1;
                    count[1] += 1;
                }
                else {
                    return false;
                }
            }
            else if (bills[i] == 20) {
                if (count[1] > 0) {
                    count[1] -= 1;
                    if (count[0] > 0) {
                        count[0] -= 1;
                    } else {
                        return false;
                    }
                }
                else if (count[0] >= 3) {
                    count[0] -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;

    }
}
