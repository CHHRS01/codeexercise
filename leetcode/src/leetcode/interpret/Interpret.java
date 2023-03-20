package leetcode.interpret;

/**
 * 1678. 设计 Goal 解析器
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class Interpret {
    public static String interpret(String command) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                ++i;
            }
            else {
                if (command.charAt(i+1) == 'a') {
                    sb.append("al");
                    i +=4;
                }
                else {
                    sb.append('o');
                    i+=2;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("(al)G(al)()()G"));
    }
}
