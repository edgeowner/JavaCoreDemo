package javacore.sort.simple;

import javacore.sort.SwapUtils;

/**
 * @author zhangsunny
 * 简单排序 之 冒泡排序
 */
public class BubbleSortDemo {

    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        //i控制外循环即总共需要将多少个数字进行排序，
        //j控制内循环即每次循环都会将最大的数排到右边
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //如果前面的数字大于后面的数字就将前面的数字和后面的数字进行交换，直接最大的数字被排到最右侧
                if (arr[j] > arr[j + 1]) {
                    SwapUtils.swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
//        System.out.print("Before: [ ");
//        SwapUtils.printArrays(nums);
//        bubbleSort(nums);
//        System.out.print("After:  [ ");
//        SwapUtils.printArrays((nums));

        int[] nums = new int[]{7, 6, 2, 2, 5};
        bubbleSort(nums);

    }
}
