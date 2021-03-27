package arrayTest;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr[0]);
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

    }
}
