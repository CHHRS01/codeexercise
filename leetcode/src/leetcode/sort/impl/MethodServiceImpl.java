package leetcode.sort.impl;

import leetcode.sort.MethodService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * basic sort methon for array
 * param is not null
 */
public class MethodServiceImpl implements MethodService {

    @Override
    public int[] selectSort(int[] param) {

        for (int i = 0; i < param.length - 1; i++) {
            int temp;//用来在交换时存储最小值
            int index = i;//存储最小数的下标
            for (int j = i; j < param.length; j++) {
                //如果param[j] 小于 param[index] 则获取j的下标
                if (param[j] < param[index]){
                    index = j;
                }
            }
            if (index != i){
                temp = param[index];
                param[index] = param[i];
                param[i] = temp;
            }
        }

        return param;
    }

    @Override
    public int[] bubblingSort(int[] param) {

        int  temp;  //  记录临时中间值
        int  size  =  param.length;  //  数组大小
        for  ( int  i  =   0 ; i  <  size  -   1 ; i ++ ) {
            for  ( int  j  =  i  +   1 ; j  <  size; j ++ ) {
                if  (param[i]  <  param[j]) {  //  交换两数的位置
                    temp  =  param[i];
                    param[i]  =  param[j];
                    param[j]  =  temp;
                }
            }
        }
        return param;
    }

    @Override
    public int[] insertSort(int[] param) {
        int  size  =  param.length, temp, j;
        for ( int  i = 1 ; i < size; i ++ ) {
            temp  =  param[i];
            for (j  =  i; j  >   0   &&  temp  <  param[j - 1 ]; j -- ) {
                param[j]  =  param[j - 1 ];
            }
            param[j]  =  temp;
        }
        return param;
    }

    @Override
    public int[] mergeSort(int[] param) {

        this.mergeTo(param, 0 , param.length - 1);
        return param;
    }

    private void mergeTo(int [] numbers,  int  left,  int  right) {
        if (left >= right) {
            return;
        }
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        mergeTo(numbers, left, center);
        // 对右边数组进行递归
        mergeTo(numbers, center + 1, right);
        // 合并
        merge(numbers, left, center, right);
    }

    private void merge(int[] data, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[data.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }

    @Override
    public int[] bucketSort(int[] param) {
        int max=param[0];
        int min=param[0];
        for (int i=1;i<param.length;i++){
            if (param[i]>max){
                max=param[i];
            }
            if (param[i]<min){
                min=param[i];
            }
        }
        int d=max-min;

        //初始化桶
        int bucketNum=param.length;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>(bucketNum);
        for (int i=0;i<bucketNum;i++){
            bucketList.add(new LinkedList<Integer>());
        }

        //遍历原始数组将每个元素放入桶中
        for (int i=0;i<param.length;i++){
            int num=(int)((param[i]-min)*(bucketNum-1)/d);
            bucketList.get(num).add(param[i]);
        }

        //对每个桶内部进行排序
        for(int i=0;i<bucketList.size();i++){
            // 使用Collections.sort，其底层实现基于归并排序或归并排序的优化版本
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素
        int[] sortedArray=new int[param.length];
        int index=0;
        for (LinkedList<Integer> list:bucketList) {
            for (int element:list){
                sortedArray[index]=element;
                index++;
            }
        }
        return sortedArray;
    }

    @Override
    public int[] baseSort(int[] param) {

        this.radixSort(param, 10, 4);
        return param;
    }

    private void radixSort(int[] data, int radix, int d) {
        // 缓存数组
        int[] tmp = new int[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        for (int i = 0, rate = 1; i < d; i++) {

            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmp, 0, data.length);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // 按子关键字对指定的数据进行排序
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % radix;
                data[--buckets[subKey]] = tmp[m];
            }
            rate *= radix;
        }

    }

    @Override
    public int[] countSort(int[] param) {
        //一：求取最大值和最小值，计算中间数组的长度：中间数组是用来记录原始数据中每个值出现的频率
        int max = param[0], min = param[0];
        for (int i : param) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        //二：有了最大值和最小值能够确定中间数组的长度
        //存储5-0+1 = 6
        int[] pxA = new int[max - min + 1];

        //三.循环遍历旧数组计数排序: 就是统计原始数组值出现的频率到中间数组B中
        for (int i : param) {
            pxA[i - min] += 1;//数的位置 上+1
        }

        //四.遍历输出
        //创建最终数组，就是返回的数组，和原始数组长度相等，但是排序完成的
        int[] result = new int[param.length];
        int index = 0;//记录最终数组的下标

        //先循环每一个元素  在计数排序器的下标中
        for (int i = 0; i < pxA.length; i++) {
            //循环出现的次数
            for (int j = 0; j < pxA[i]; j++) {//pxA[i]:这个数出现的频率
                result[index++] = i + min;//以为原来减少了min现在加上min，值就变成了原来的值
            }
        }
        return result;
    }

    @Override
    public int[] quickSort(int[] param) {

        this.quick(param, 0, param.length - 1);

        return param;
    }

    private void quick(int[] numbers,  int  start,  int  end) {
        if  (start  <  end) {
            //  选定的基准值（第一个数值作为基准值）
            int  base  =  numbers[start];
            int  temp;  //  记录临时中间值
            int  i  =  start, j  =  end;
            do  {
                while  ((numbers[i]  <  base)  &&  (i  <  end)) {
                    i ++;
                }
                while  ((numbers[j]  >  base)  &&  (j  >  start)) {
                    j --;
                }
                if  (i  <=  j) {
                    temp  =  numbers[i];
                    numbers[i]  =  numbers[j];
                    numbers[j]  =  temp;
                    i ++;
                    j --;
                }
            }  while  (i  <=  j);
            if  (start  <  j) {
                quick(numbers, start, j);
            }
            if  (end  >  i) {
                quick(numbers, i, end);
            }
        }
    }

    @Override
    public int[] shellSort(int[] param) {
        int n = param.length;
        int gap = n/2;
        while(gap > 0){
            for(int j = gap; j < n; j++){
                int i=j;
                while(i >= gap && param[i-gap] > param[i]){
                    int temp = param[i-gap]+param[i];
                    param[i-gap] = temp-param[i-gap];
                    param[i] = temp-param[i-gap];
                    i -= gap;
                }
            }
            gap = gap/2;
        }
        return param;
    }

    @Override
    public int[] heapSort(int[] param) {
        //1.构建大顶堆
        for(int i=param.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            this.adjustHeap(param,i,param.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=param.length-1;j>0;j--){
            this.swap(param,0,j);//将堆顶元素与末尾元素进行交换
            this.adjustHeap(param,0,j);//重新对堆进行调整
        }
        return param;
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    private void adjustHeap(int []arr,int i,int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k=i*2+1;k<length;k=k*2+1){
            //如果左子结点小于右子结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    private void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    @Override
    public int[] binarySort(int[] param) {
        for (int i = 0; i < param.length; i++) {
            int temp = param[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<param[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                param[j+1] = param[j];
            }
            if(left != i){
                param[left] = temp;
            }
        }
        return param;
    }
}
