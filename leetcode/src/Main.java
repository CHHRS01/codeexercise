import leetcode.dp.DynamicProgrammingService;
import leetcode.dp.DynamicProgrammingService2;
import leetcode.sort.MethodService;
import leetcode.dp.impl.DynamicProgrammingService2Impl;
import leetcode.dp.impl.DynamicProgrammingServiceImpl;
import leetcode.sort.impl.MethodServiceImpl;
import entity.ParamBean;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        sortService();

//        dynamicProgrammingService1();

//        dynamicProgrammingService2();

//        test();

        System.out.println("Hello World!");
    }

    private static void test() {
        int  N = 10;
        for (int hops = 0; hops < N-1; ++hops) {
            int result = ~hops & 1;
            System.out.println(result);
        }
    }

    private static void dynamicProgrammingService2() {
        DynamicProgrammingService2 service = new DynamicProgrammingService2Impl();
        ParamBean paramBean = new ParamBean();

//        String result1 = service.longestPalindromicSubstring(paramBean.getParamString());
//        System.out.println("result1 is "+ result1);
//
//        List<String> result2 = service.generateParenthesis(paramBean.getParamInt());
//        System.out.println("result2 is "+ result2);
//
//        Boolean result3 = service.canJump(paramBean.getParam1());
//        System.out.println("result3 is "+ result3);
//
//        Integer result4 = service.canJump2(paramBean.getParam1());
//        System.out.println("result4 is "+ result4);
//
//        Integer result5 = service.uniquePaths(paramBean.getParamInt(), paramBean.getParamInt2());
//        System.out.println("result5 is "+ result5);
//
//        Integer result6 = service.uniquePathsWithObstacles(paramBean.getParam2dArray());
//        System.out.println("result6 is "+ result6);
//
//        Integer result7 = service.minPathSum(paramBean.getParam2dArray());
//        System.out.println("result7 is "+ result7);
//
//        Integer result8 = service.numDecodings(paramBean.getParamString());
//        System.out.println("result8 is "+ result8);
//
//        Integer result9 = service.numTrees(paramBean.getParamInt());
//        System.out.println("result9 is "+ result9);
//
//        List<TreeNode> result10 = service.generateTrees(paramBean.getParamInt());
//        System.out.println("result10 is "+ Arrays.toString(result10));
    }

    private static void dynamicProgrammingService1() {
        DynamicProgrammingService service = new DynamicProgrammingServiceImpl();
        ParamBean paramBean = new ParamBean();

//        String result1 = service.longestPalindromicSubstring(paramBean.getParamString());
//        System.out.println("result1 is "+ result1);
//
//        List<String> result2 = service.generateParenthesis(paramBean.getParamInt());
//        System.out.println("result2 is "+ result2);
//
//        Boolean result3 = service.canJump(paramBean.getParam1());
//        System.out.println("result3 is "+ result3);
//
//        Integer result4 = service.canJump2(paramBean.getParam1());
//        System.out.println("result4 is "+ result4);
//
//        Integer result5 = service.uniquePaths(paramBean.getParamInt(), paramBean.getParamInt2());
//        System.out.println("result5 is "+ result5);
//
//        Integer result6 = service.uniquePathsWithObstacles(paramBean.getParam2dArray());
//        System.out.println("result6 is "+ result6);
//
//        Integer result7 = service.minPathSum(paramBean.getParam2dArray());
//        System.out.println("result7 is "+ result7);
//
//        Integer result8 = service.numDecodings(paramBean.getParamString());
//        System.out.println("result8 is "+ result8);
//
//        Integer result9 = service.numTrees(paramBean.getParamInt());
//        System.out.println("result9 is "+ result9);
//
//        List<TreeNode> result10 = service.generateTrees(paramBean.getParamInt());
//        System.out.println("result10 is "+ result10);
    }

    private static void sortService() {

        MethodService methodService = new MethodServiceImpl();
        ParamBean paramBean = new ParamBean();

//        int[] result1 = methodService.selectSort(paramBean.getParam1());
//        System.out.println("result1 is "+ Arrays.toString(result1));
//
//        int[] result2 = methodService.bubblingSort(paramBean.getParam1());
//        System.out.println("result2 is "+ Arrays.toString(result2));
//
//        int[] result3 = methodService.insertSort(paramBean.getParam1());
//        System.out.println("result3 is "+ Arrays.toString(result3));
//
//        //排序有问题
//        int[] result4 = methodService.mergeSort(paramBean.getParam1());
//        System.out.println("result4 is "+ Arrays.toString(result4));
//
//        int[] result5 = methodService.bucketSort(paramBean.getParam1());
//        System.out.println("result5 is "+ Arrays.toString(result5));
//
//        int[] result6 = methodService.baseSort(paramBean.getParam1());
//        System.out.println("result6 is "+ Arrays.toString(result6));
//
//        int[] result7 = methodService.countSort(paramBean.getParam1());
//        System.out.println("result7 is "+ Arrays.toString(result7));

        int[] result8 = methodService.quickSort(paramBean.getParam1());
        System.out.println("result8 is "+ Arrays.toString(result8));

        int[] result9 = methodService.shellSort(paramBean.getParam1());
        System.out.println("result9 is "+ Arrays.toString(result9));

        int[] result10 = methodService.heapSort(paramBean.getParam1());
        System.out.println("result10 is "+ Arrays.toString(result10));

        int[] result11 = methodService.binarySort(paramBean.getParam1());
        System.out.println("result11 is "+ Arrays.toString(result11));
    }
}
