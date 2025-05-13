/*
 * ⽆序数组排序。
 * 输⼊：数组；
 * 输出：有序数组；
 */
class Solution {
    public int[] sortArray(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}