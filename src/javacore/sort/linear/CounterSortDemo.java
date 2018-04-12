package javacore.sort.linear;

import javacore.sort.SwapUtils;

/**
 * @author zhangsunny
 * 线性排序 之 计数排序
 */
public class CounterSortDemo {

    private static int[] counterSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int maxValue = getMaxValue(arr);
        return countingSort(arr, maxValue);
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }


    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
        System.out.print("Before: [ ");
        SwapUtils.printArrays(nums);
        int[] newNums = counterSort(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays((nums));
    }


}
