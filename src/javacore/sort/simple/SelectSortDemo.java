package javacore.sort.simple;

import javacore.sort.SwapUtils;

/**
 * @author zhangsunny
 * 简单排序 之 选择排序
 */
public class SelectSortDemo {

    public static void selectSort(int[] arr) {

        if (null == arr || arr.length == 0) {
            return;
        }
        // 每一趟循环比较时，min用于存放较小元素的数组下标，
        // 这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                SwapUtils.swap(arr, min, i);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
        System.out.print("Before: [ ");
        SwapUtils.printArrays(nums);
        selectSort(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays((nums));
    }
}
