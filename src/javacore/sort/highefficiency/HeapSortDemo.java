package javacore.sort.highefficiency;

import javacore.sort.SwapUtils;

/**
 * @author zhangsunny
 * 高效排序 之 堆排序
 */
public class HeapSortDemo {

    public static void heapSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            SwapUtils.swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            SwapUtils.swap(arr, i, largest);
            heapify(arr, largest, len);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
        System.out.print("Before: [ ");
        SwapUtils.printArrays(nums);
        heapSort(nums);
        System.out.print("After:  [ ");
        SwapUtils.printArrays((nums));
    }
}
