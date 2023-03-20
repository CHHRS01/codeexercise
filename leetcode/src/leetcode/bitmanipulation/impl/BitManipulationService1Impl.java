package leetcode.bitmanipulation.impl;

import leetcode.bitmanipulation.BitManipulationService1;

import java.util.*;

/**
 * @author hanrensong
 * @date 2021/8/27
 */

public class BitManipulationService1Impl implements BitManipulationService1 {

    /**
     * 29. 两数相除
     * java移位运算符：<<（算术左移）、>>（（带符号）算术右移）和>>>（（无符号）逻辑右移）。
     * <p>
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * <p>
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * <p>
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    @Override
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long divid = (int)dividend;
        long divis = (int)divisor;

        boolean flag = true;
        long temp, result = 1, ans = 0;

        if(divid < 0 && divis > 0) {
            divid = - divid; flag = false;
        } else if(divid > 0 && divis < 0) {
            divis = - divis; flag = false;
        } else if(divid < 0 && divis < 0){
            divid = - divid; divis = - divis;
        }

        while(divid - divis >= 0){
            temp = divis << 1;
            result = 1;
            while(divid - temp >= 0){
                result = result << 1;
                temp = temp << 1;
            }
            divid -= temp >> 1;
            ans += result;
        }

        if(flag) {
            return (int) ans;
        } else {
            return (int)-ans;
        }
    }

    /**
     * 78. 子集
     * <p>
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> t;
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(t);
        }
        return ans;
    }

    /**
     * 89. 格雷编码
     * <p>
     * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     * <p>
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
     * <p>
     * 格雷编码序列必须以 0 开头。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/gray-code
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    @Override
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        // 逐项推
        for(int binary = 0;binary < (1 << n); binary++){
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> gray = new ArrayList<>();
        //初始化 n = 0 的解
        gray.add(0);
        for (int i = 0; i < n; i++) {
            //要加的数
            int add = 1 << i;
            // 2倍数量递推
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    /**
     * 90. 子集 II
     * <p>
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    @Override
    public List<List<Integer>> subsetsWithDupII(int[] nums) {
        Set<Integer> t = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    /**
     * 137. 只出现一次的数字 II
     * <p>
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    @Override
    public int singleNumberII(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 187. 重复的DNA序列
     *
     * 使用掩码实现常数时间窗口切片
     *
     * <p>
     * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     * <p>
     * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    @Override
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        if (n <= L) {
            return new ArrayList<>();
        }

        // rolling hash parameters: base a
        int a = 4, aL = (int)Math.pow(a, L);

        // convert string to array of integers
        Map<Character, Integer> toInt = new HashMap<>();
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);


        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int bitmask = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        // iterate over all sequences of length L
        for (int start = 0; start < n - L + 1; ++start) {
            // compute bitmask of the current sequence in O(1) time
            if (start != 0) {
                // left shift to free the last 2 bit
                bitmask <<= 2;
                // add a new 2-bits number in the last two bits
                bitmask |= nums[start + L - 1];
                // unset first two bits: 2L-bit and (2L + 1)-bit
                bitmask &= ~(3 << 2 * L);
            }
            // compute hash of the first sequence in O(L) time
            else {
                for(int i = 0; i < L; ++i) {
                    bitmask <<= 2;
                    bitmask |= nums[i];
                }
            }
            // update output and hashset of seen sequences
            if (seen.contains(bitmask)) {
                output.add(s.substring(start, start + L));
            }
            seen.add(bitmask);
        }
        return new ArrayList<>(output);
    }

    /**
     * 201. 数字范围按位与
     * <p>
     * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
     *
     * @param left
     * @param right
     * @return
     */
    @Override
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }

    private int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }

    /**
     * 260. 只出现一次的数字 III
     *
     * @param nums
     * @return
     */
    @Override
    public int[] singleNumberIII(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        // 找到末尾为0
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    /**
     * 287. 寻找重复数
     * <p>
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * <p>
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     * <p>
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    @Override
    public int findDuplicate(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }

    /**
     * 318. 最大单词长度乘积
     * <p>
     * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    @Override
    public int maxProduct(String[] words) {
        Map<Integer, Integer> mode_maxLen = new HashMap<>();
        for (String word : words)
        {
            int mode = 0;
            for (int i = 0;  i < word.length(); i ++)
            {
                char c = word.charAt(i);
                mode |= 1 << (c - 'a');
            }
            if (word.length() > mode_maxLen.getOrDefault(mode, 0))
                mode_maxLen.put(mode, word.length());
        }

        List<int []> mode_len_list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mode_maxLen.entrySet())
        {
            int mode = entry.getKey();
            int len = entry.getValue();
            mode_len_list.add(new int [] {mode, len});
        }

        int n = mode_len_list.size();
        int res = 0;
        for (int i = 0; i < n; i ++) {
            int mode_i = mode_len_list.get(i)[0];
            int len_i = mode_len_list.get(i)[1];
            for (int j = i + 1; j < n; j ++)
            {
                int mode_j = mode_len_list.get(j)[0];
                int len_j = mode_len_list.get(j)[1];
                if ((mode_i & mode_j) == 0)
                    res = Math.max(res, len_i * len_j);
            }
        }

        return  res;
    }
}
