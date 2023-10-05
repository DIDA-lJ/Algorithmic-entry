package com.qinyao.sort;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/15
 */
public class Sort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 将哨兵移动到为止 pivotIndex 上
            int pivotIndex = i + 1;
            int temp = arr[pivotIndex];
            arr[pivotIndex] = arr[right];
            arr[right] = temp;

            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right - 1);
        }
    }
}
