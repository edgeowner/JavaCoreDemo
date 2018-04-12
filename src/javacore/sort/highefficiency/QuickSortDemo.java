package javacore.sort.highefficiency;

import javacore.sort.SwapUtils;

import java.text.MessageFormat;
import java.util.Random;

/**
 * @author zhangsunny
 * 高效排序 之 快速排序
 */
public class QuickSortDemo {

    public static void quickSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        quickSort2(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //设定基准值(pivot)
        int pivot = left;
        int index = pivot + 1;
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (temp < arr[j] && i < j) {
                j--;
            }

            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                int t = arr[i];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        arr[left] = arr[i];
        arr[i] = temp;

        SwapUtils.swap(arr, pivot, index - 1);
        return index - 1;
    }


    private static void quickSort2(int arr[], int left, int right) {
        //如果left不小于right ，需要排序的部分只有一个元素，方法返回
        System.out.println("left:" + left + ",right:" + right);
        if (left == 0 && right == 0) {
            System.out.println("i=j=0");
        }
        System.out.println("1.-------------------");
        if (left >= right) {
            System.out.println(MessageFormat.format("return: left,{0}  | right,{1}", left, right));
            return;
        }
        //设置最左边元素为基准点：pivot
        int pivot = arr[left];
        System.out.println("pivot:" + pivot);
        int i = left;
        int j = right;
        //把要排序的序列中比p大的放到右边，比p小的放到左边，p的下标位置为i
        while (i < j) {
            System.out.println("2.-------start------------");
            while (i < j && arr[j] >= pivot) {
                j--;
                System.out.println("2.  j:" + j);
            }
            System.out.println("========[j-- over, i++ start ]==========");
            while (i < j && arr[i] <= pivot) {
                i++;
                System.out.println("2.  i:" + i);
            }
            System.out.println("2.-------end------------");

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //交换基准点
        arr[left] = arr[i];
        arr[i] = pivot;
        //对序列中，i左边的元素实施快速排序
        System.out.println("左边开始前， right为" + right + "值");
        quickSort2(arr, left, i - 1);
        //对序列中，j右边边的元素实施快速排序
        System.out.println("右块遍历开始...... ");
        quickSort2(arr, i + 1, right);
        System.out.println("left =:" + (i + 1) + ",right = " + right);
        System.out.println("3.-------------------");
        System.out.println("4.---------all over----------");

    }


    public static void main(String[] args) {
        int[] nums = new int[]{9, 3, 1, 4, 2, 7, 8, 6, 5};
//        int[] nums = new int[]{56, 18, 6, 3, 97, 66, 8, 26, 88, 30, 99, 93};
//        System.out.print("Before: [ ");
//        SwapUtils.printArrays(nums);
//        quickSort(nums);
//        System.out.print("After:  [ ");
//        SwapUtils.printArrays((nums));


        //大数据量测试
        int[] arr = new int[100000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000000);
        }
        long start = System.currentTimeMillis();
        quickSort(nums);
        long time = System.currentTimeMillis() - start;
        System.out.println("-----------大数据量测试结果-----------");
        System.out.println("all time:" + time + "毫秒");
    }
}
