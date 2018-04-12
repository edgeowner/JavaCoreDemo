package javacore.sort.highefficiency;

/**
 * @author zhangsunny
 */
public class TestRecursion {


    private static void recursionMethod(int i) {
        if (i <= 0) {
            return;
        }
        recursionMethod(--i);
    }

    public static void main(String[] args) {

        int param = 7;
        recursionMethod(param);
        System.out.println(param);


    }
}
