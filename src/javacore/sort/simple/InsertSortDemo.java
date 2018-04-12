package javacore.sort.simple;

import javacore.sort.SwapUtils;

/**
 * @author zhangsunny
 * 简单排序 之 插入排序
 */
public class InsertSortDemo {

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
        int[] newNums=insertSort(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays(newNums);
    }


}
