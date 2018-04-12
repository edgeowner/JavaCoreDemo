package javacore.sort.linear;

import javacore.sort.SwapUtils;
import javacore.sort.simple.InsertSortDemo;

import java.util.Arrays;

/**
 * @author zhangsunny
 * 线性排序 之 桶排序
 */
public class BucketSortDemo {



    //桶值大小
    private static int BUCKET_SIZE = 5;

    private static int[] bucketSort(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        int bucketCount = (int) Math.floor((maxValue - minValue) / BUCKET_SIZE) + 1;
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / BUCKET_SIZE);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }


    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            // 记录要插入的数据
            int tmp = arr[i];
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }

        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
        System.out.print("Before: [ ");
        SwapUtils.printArrays(nums);
        int[] newNums = bucketSort(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays(newNums);
    }


}
