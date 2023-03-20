package leetcode.freqAlphabets;

/**
 * 1309. 解码字母到整数映射
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class FreqAlphabets {

    // '0' 位置 48 ‘A’ 位置65 ‘a’ 位置97
    public static String freqAlphabets1(String s) {
        if ("".equals(s)) {
            return "";
        }
        // 初始化
        String[] charArray = new String[26];
        charArray[0] = "1";
        charArray[1] = "2";
        charArray[2] = "3";
        charArray[3] = "4";
        charArray[4] = "5";
        charArray[5] = "6";
        charArray[6] = "7";
        charArray[7] = "8";
        charArray[8] = "9";
        charArray[9] = "10#";
        charArray[10] = "11#";
        charArray[11] = "12#";
        charArray[12] = "13#";
        charArray[13] = "14#";
        charArray[14] = "15#";
        charArray[15] = "16#";
        charArray[15] = "17#";
        charArray[17] = "18#";
        charArray[18] = "19#";
        charArray[19] = "20#";
        charArray[20] = "21#";
        charArray[21] = "22#";
        charArray[22] = "23#";
        charArray[23] = "24#";
        charArray[24] = "25#";
        charArray[25] = "26#";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(charArray[s.charAt(i) - 'a']);
        }
        return sb.toString();
    }

    public static String freqAlphabets(String s) {

        char[] charArray = new char[27];
        charArray[1] = 'a';
        charArray[2] = 'b';
        charArray[3] = 'c';
        charArray[4] = 'd';
        charArray[5] = 'e';
        charArray[6] = 'f';
        charArray[7] = 'g';
        charArray[8] = 'h';
        charArray[9] = 'i';
        charArray[10] = 'j';
        charArray[11] = 'k';
        charArray[12] = 'l';
        charArray[13] = 'm';
        charArray[14] = 'n';
        charArray[15] = 'o';
        charArray[16] = 'p';
        charArray[17] = 'q';
        charArray[18] = 'r';
        charArray[19] = 's';
        charArray[20] = 't';
        charArray[21] = 'u';
        charArray[22] = 'v';
        charArray[23] = 'w';
        charArray[24] = 'x';
        charArray[25] = 'y';
        charArray[26] = 'z';
        int length = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < length) {
            if ((s.charAt(i) == '1' || s.charAt(i) == '2') && i + 2 < length && s.charAt(i + 2) == '#') {
                sb.append(charArray[Integer.valueOf(s.substring(i, i+2))]);
                i +=3;
                continue;
            }
            sb.append(charArray[s.charAt(i) - '0']);
            ++i;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String aa = freqAlphabets1("skjlenghz");
        System.out.println(aa);
        System.out.println(freqAlphabets(aa));
    }
}
