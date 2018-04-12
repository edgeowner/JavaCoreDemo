package javacore.sort;


import netscape.javascript.JSObject;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author zhangsunny
 */
public class AllSortDemo {


    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int len = arr.length;
        //冒泡排序的基本思路是 代码的内层循环控制遍历元素的 空间复杂，
        // 内部循环每次减少一个元素的空间复杂度，将内层循环的 最大值（最小值）放入最后 元素位置
        // 依次遍历，外层继续 重复
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }


    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        //每次遍历取出 内层循环中最小的 值的下标，
        // 将所得 后续的最小值和最外层的值进行互换，直到外层循环遍历为止
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            System.out.println("arr[min]" + arr[min]);
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }


    /**
     * 插入排序
     *
     * @param arrs
     */
    public static void insertSort(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return;
        }

//        for (int i = 0; i < arrs.length; i++) {
//            int temp = arrs[i];
//            int j = i;
//            while (j > 0 && temp < arrs[j - 1]) {
//                arrs[j] = arrs[j - 1];
//                j--;
//            }
//            if (j != i) {
//                arrs[j] = temp;
//            }
//        }
        for (int i = 1; i < arrs.length; i++) {
            int j = i;
            while (j > 0 && arrs[j] < arrs[j - 1]) {
                int temp = arrs[j];
                arrs[j] = arrs[j - 1];
                arrs[j - 1] = temp;
                j--;
            }

        }

    }


    /**
     * 插入排序2
     *
     * @param arrs
     */
    public static void insertSort2(int[] arrs) {
        if (arrs == null && arrs.length == 0) {
            return;
        }

        for (int i = 1; i < arrs.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j - 1];
                    arrs[j - 1] = temp;
                }
            }
        }

    }


    // heap sort start

    /**
     * 堆排序
     *
     * @param arrs
     */
    public static void heapSort(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return;
        }
        int len = arrs.length;
        //循环建立最大堆
        for (int i = 0; i < len; i++) {
            System.out.println(MessageFormat.format("1. heapSort: i,{0}  j,{1}", i, len - 1));
            System.out.println("--------------1. buildMaxHeap start--------------");
            buildMaxHeap(arrs, len - i);
            //交换堆顶和最后一个元素
            int temp = arrs[0];
            arrs[0] = arrs[len - 1 - i];
            arrs[len - 1 - i] = temp;
            System.out.println("--------------1. buildMaxHeap over--------------");
        }

    }

    /**
     * 完成最大堆建立
     *
     * @param arrs
     * @param len
     */
    private static void buildMaxHeap(int[] arrs, int len) {
        System.out.println("--------------2. buildMaxHeap method start--------------");
        System.out.println(MessageFormat.format("--------------2. params:{0}--------------", len));
        for (int j = (int) Math.floor(len / 2); j >= 0; j--) {
            heapify(arrs, j, len);
        }
    }

    /**
     * 建立堆 (大顶堆方式)
     *
     * @param arrs           完全二叉树
     * @param currentRooNode 当前父节点位置
     * @param length         节点总数
     */
    private static void heapify(int[] arrs, int currentRooNode, int length) {
        System.out.println("--------------3. heapify method start--------------");
        System.out.println(MessageFormat.format("--------------3. params:{0},{1}-------------", currentRooNode, length));
        if (currentRooNode < length) {
            //左叶子结点 位置
            int left = 2 * currentRooNode + 1;
            //右叶子结点 位置
            int right = 2 * currentRooNode + 2;
            int max = currentRooNode;

            if (left < length) {
                //如果当前根节点的 左叶子节点元素值较大，记录它的位置
                if (arrs[max] < arrs[left]) {
                    max = left;
                }
            }

            if (right < length) {
                //如果当前根节点的 右叶子节点元素值较大，记录它的位置
                if (arrs[max] < arrs[right]) {
                    max = right;
                }
            }

            //如果最大的不是根元素位置，那么就交换
            if (max != currentRooNode) {
                int temp = arrs[max];
                arrs[max] = arrs[currentRooNode];
                arrs[currentRooNode] = temp;
                //继续比较，直到完成一次建堆
                heapify(arrs, max, length);
            }

        }
        System.out.println("--------------3. heapify method over--------------");
    }
    // heap over


    /**
     * 希尔排序
     *
     * @param arrs
     */
    public static void shellSort(int[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return;
        }
        //增量 每次都 gap/2   gap为每次外循环的步长
        //当 步长为 1 即增量为1 时， 希尔排序蜕化为 简单插入排序
        int counterFrequency = 0;
        for (int gap = (int) Math.floor(arrs.length / 2); gap > 0; gap /= 2) {
            counterFrequency++;
            System.out.println("------------------1.Outerloop  start---------------------");
            System.out.println(MessageFormat.format("--------1.Increment:{0}, outerloop frequency:{1}---------", gap, counterFrequency));

            for (int i = gap; i < arrs.length; i++) {
                int j = i;
                int temp = arrs[j];

                // j - step 就是代表与它同组隔壁的元素 内层增量 gap通过 j-gap确定左边
                int counterSwapJGap = 0;
                while (j - gap >= 0 && arrs[j - gap] > temp) {
                    arrs[j] = arrs[j - gap];
                    j = j - gap;
                    counterSwapJGap++;
                    printArr("--------------1. arrs:{0}---------------", arrs);
                }
                printArr("--------------2. arrs:{0}---------------", arrs);
                System.out.println(MessageFormat.format("------------------3.Whileloop counter:{0}---------------------", counterSwapJGap));
                arrs[j] = temp;
                System.out.println(MessageFormat.format("--------2.Innerloop: i:{0}, j:{1} , temp:{2} ---------", i, j, temp));
            }
            System.out.println("------------------1.Outerloop  over---------------------");

        }
    }

    //对比简单插入排序

    /**
     * 简单插入排序
     *
     * @param arrs
     */
    public static void insertSortDemo(int arrs[]) {
        int len = arrs.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j < len - 1; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j - 1];
                    arrs[j - 1] = temp;
                }
            }
        }

    }


    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        int gap = 1, i, j;
        int len = arr.length;
        int temp;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
            while (gap > 0) {
                for (i = gap; i < len; i++) {
                    temp = arr[i];
                    for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                        arr[j + gap] = arr[j];
                        arr[j + gap] = temp;
                    }
                    gap /= 3;
                }

            }

        }
    }


    /**
     * 计数排序 
     *
     * @param arrs
     */
    public static void countingSort(int[] arrs) {
        int[] copyData = Arrays.copyOf(arrs, arrs.length);
        int maxValue = arrs[0];
        int minValue = arrs[0];
        for (int i = 0; i < copyData.length; i++) {
            if (copyData[i] > maxValue) {
                maxValue = copyData[i];
            }
            if (copyData[i] < minValue) {
                minValue = copyData[i];
            }
        }

        int range = maxValue - minValue + 1;
        int[] counts = new int[range];
        Arrays.fill(counts, 0);
        //  计算数组中每个值和最小值的差，并计数
        for (int arr : copyData) {
            counts[arr - minValue]++;
        }
        // 得到数组中大于某个数的值一共有多少个
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }
        // 根据数量放置值，每放置一个，对应的值的数量减一
        for (int i = 0; i < copyData.length; i++) {
            int index = copyData[i] - minValue;
            arrs[counts[index] - 1] = copyData[i];
            counts[index]--;
        }
    }


    /**
     * 基数排序
     *
     * @param arrs
     */
    public static void radixSort(int[] arrs) {
        int max = findMax(arrs, 0, arrs.length - 1);
        //需要遍历的次数由数组最大的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] buckets = new int[arrs.length][10];
            //获取每一个数字（个、十、百、千位...分配到桶子里）
            for (int j = 0; j < arrs.length; j++) {
                int num = (arrs[j] / i) % 10;
                //将其放入桶子里
                buckets[j][num] = arrs[j];
            }
            //回收桶子里的元素
            int k = 0;
            //有10个桶子
            for (int j = 0; j < 10; j++) {
                //对每个桶子里的元素进行回收
                for (int l = 0; l < arrs.length; l++) {
                    //如果桶子里有元素就回收(数据会初始化为0)
                    if (buckets[l][j] != 0) {
                        arrs[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    /**
     * 递归找出数组最大值
     *
     * @param arrs  数组
     * @param left  左边界，第一个数
     * @param right 右边界，数组长度
     * @return
     */
    public static int findMax(int[] arrs, int left, int right) {
        //若该数组只有一个数，那么最大的就是该数组第一个值
        if (left == right) {
            return arrs[left];
        } else {

            int leftValue = arrs[left];
            //找出所有元素中的最大值
            int rightvalue = findMax(arrs, left + 1, right);

            if (leftValue > rightvalue) {
                return leftValue;
            } else {
                return rightvalue;
            }
        }
    }


    /**
     * 归并排序
     *
     * @param arrs
     */
    public static void mergeSort(int[] arrs) {
        if (arrs == null || arrs.length == 0 || arrs.length == 0) {
            return;
        }
        mergeSort(arrs, 0, arrs.length - 1);
    }

    /**
     * 归并排序核心部分(递归调用)
     *
     * @param arrs
     * @param left
     * @param right
     */
    private static void mergeSort(int[] arrs, int left, int right) {
        //如果只有一个元素就不用排序
        if (left == right) {
            return;
        } else {
            //取消中间数，进行拆分
            int middle = (left + right) / 2;
            //左边的数不断进行拆分
            mergeSort(arrs, left, middle);
            //右边的数不断进行拆分
            mergeSort(arrs, middle + 1, right);
            //合并
            merge(arrs, left, middle + 1, right);
        }
    }

    /**
     * 合并数组
     *
     * @param arrs
     * @param left   指向数组第一个元素
     * @param middle 指向数组分隔的元素
     * @param right  指向数组最后的元素
     */
    private static void merge(int[] arrs, int left, int middle, int right) {

        //左边的数组大小
        int[] leftArrs = new int[middle - left];

        //右边的数组大小
        int[] rightArrs = new int[right - middle + 1];

        //往这两个数组填充数据
        for (int i = left; i < middle; i++) {
            leftArrs[i - left] = arrs[i];
        }
        for (int i = middle; i <= right; i++) {
            rightArrs[i - middle] = arrs[i];
        }

        int i = 0, j = 0;
        //arrs数组的第一个元素
        int k = left;
        //比较两个数组的值，哪个小，就往数组上放
        while (i < leftArrs.length && j < rightArrs.length) {
            //谁比较小，谁将元素放入大数组中，移动指针，继续比较下一个
            if (leftArrs[i] < rightArrs[j]) {
                arrs[k] = leftArrs[i];
                i++;
                k++;
            } else {
                arrs[k] = rightArrs[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArrs.length) {
            arrs[k] = leftArrs[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较晚，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArrs.length) {
            arrs[k] = rightArrs[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
//        int[] arrs = new int[]{1, 6, 9, 2, 5, 21};
//        bubbleSort(arrs);


//        int[] arrs2 = new int[]{6, 2, 7, 2, 5};
        StringBuilder sb = new StringBuilder();
//        insertSort(arrs2);
////        selectSort(arrs2);
//        sb.append("[");
//        for (int i = 0; i < arrs2.length; i++) {
//            sb.append("," + arrs2[i]);
//        }
//        sb.append("]");
//        String result = sb.toString().replaceFirst(",", "");
//        System.out.println("result:" + result);


//        System.out.println("==============================================");
//        int[] arr3 = new int[]{7, 6, 2, 2, 5};
//        insertSort2(arr3);
//        sb.append("[");
//        for (int i = 0; i < arr3.length; i++) {
//            sb.append("," + arr3[i]);
//        }
//        sb.append("]");
//        String result = sb.toString().replaceFirst(",", "");
//        System.out.println("result:" + result);


        //heapSort Test Demo
        int[] arrs4 = new int[]{765, 1, 6, 9, 2, 5, 21, 189, 51};
//        heapSort(arrs4);
//        shellSort(arrs4);
//        shellSort2(arrs4);
//        radixSort(arrs4);
//        countingSort(arrs4);
        mergeSort(arrs4);

        printArr(null, arrs4);

    }

    /**
     * 打印数组
     *
     * @param str
     * @param arrs
     */
    private static void printArr(String str, int[] arrs) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("[");
            for (int i = 0; i < arrs.length; i++) {
                sb.append("," + arrs[i]);
            }
            sb.append("]");
            result = sb.toString().replaceFirst(",", "");
            result = MessageFormat.format(str, result);
        } else {
            sb.append("[");
            for (int i = 0; i < arrs.length; i++) {
                sb.append("," + arrs[i]);
            }
            sb.append("]");
            result = sb.toString().replaceFirst(",", "");
        }
        System.out.println("result:" + result);
    }


}
