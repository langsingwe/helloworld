package 算法.排序;

/**
 * @Description 固定的切分方式
 * @ClassName QuickSort
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 6};
        sort(arr, 0, 4);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int key = arr[lo];
        while (lo < hi) {
            while (arr[hi] > key && hi > lo) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (arr[lo] < key && hi > lo) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[hi] = key;
        return hi;
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(arr, lo, hi);
        sort(arr, lo, index - 1);
        sort(arr, index + 1, hi);
    }
}
