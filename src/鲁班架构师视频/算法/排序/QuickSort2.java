package 算法.排序;

/**
 * @Description 三数取中切分，最优解
 * @ClassName QuickSort2
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 6};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(arr, lo, hi);
        sort(arr, lo, index - 1);
        sort(arr, index + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] > arr[hi]) {
            swap(arr, mid, hi);
        }
        if (arr[lo] > arr[hi]) {
            swap(arr, lo, hi);
        }
        if (arr[mid] < arr[lo]) {
            swap(arr, mid, lo);
        }
        int key = arr[lo];
        while (lo < hi) {
            while (arr[hi] >= key && hi > lo) {
                hi--;
            }
            arr[lo] = arr[hi];
            while (arr[lo] <= key && hi > lo) {
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[hi] = key;
        return hi;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int l = 0, r = n - 1, t = 0, b = n - 1;
            int[][] mat = new int[n][n];
            int num = 1, tar = n * n;
            while (num <= tar) {
                for (int i = l; i <= r; i++) {
                    mat[t][i] = num++; // left to right.
                }
                t++;
                for (int i = t; i <= b; i++) {
                    mat[i][r] = num++; // top to bottom.
                }
                r--;
                for (int i = r; i >= l; i--) {
                    mat[b][i] = num++; // right to left.
                }
                b--;
                for (int i = b; i >= t; i--) {
                    mat[i][l] = num++; // bottom to top.
                }
                l++;
            }
            return mat;
        }

public int[][] generateMatrix2(int n) {
    int[][] arr = new int[n][n];
    int l = 0, t = 0, r = n - 1, b = n - 1;
    int num = 1;
    int target = n * n;
    while (num <= target) {
        for (int i = l; i <= r; i++) {
            arr[t][i] = num++;
        }
        t++;
        for (int i = t; i <= b; i++) {
            arr[i][r] = num++;
        }
        r--;
        for (int i = r; i >= l; i--) {
            arr[b][i] = num++;
        }
        b--;
        for (int i = b; i >= t; i--) {
            arr[i][l] = num++;
        }
        l++;
    }
    return arr;
}
    }
}
