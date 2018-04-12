package javacore.sort.merge;

import javacore.sort.SwapUtils;

import java.util.Arrays;

/**
 * @author zhangsunny
 * 分治递归 之 归并排序
 */
public class MergeSort2Demo {

    private static int[] merger2Sort(int[] arr) {
        if (null == arr || arr.length == 0 || arr.length < 2) {
            return arr;
        }
        return sort(arr);
    }

    private static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
        System.out.print("Before: [ ");
        SwapUtils.printArrays(nums);
        int[] result = merger2Sort(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays(result);
    }


}
