package javacore.sort;

public class SwapUtils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void printArrays(int[] arrs) {
        StringBuilder sb = new StringBuilder();
        if (null == arrs || arrs.length == 0) {
            System.out.println("Is Empty!");
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            sb.append("," + arrs[i]);
        }
        String toPring = sb.append(" ]").toString().replaceFirst(",", "");
        System.out.println(toPring);

    }
}
