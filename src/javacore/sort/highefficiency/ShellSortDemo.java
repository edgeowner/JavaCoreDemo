package javacore.sort.highefficiency;

import javacore.sort.SwapUtils;

/**
 * @author zhangsunny
 * <p>
 * 高效排序 之 希尔排序
 */
public class ShellSortDemo {


    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    SwapUtils.swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     *
     * @param arr
     */
    private static void shellSort2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //移动法
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
        System.out.print("Before: [ ");
        SwapUtils.printArrays(nums);
        shellSort2(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays((nums));
    }

}
