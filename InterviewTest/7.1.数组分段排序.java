/*
 * 将数组分为前半部分升序、后半部分降序，合并后整体有序的最⼩操作次数。
 */
class Solution {
    public int[] sortBySegment(int[] arr) {
        int size = arr.length;
        int[] sortedArray = new int[size];
        int pos = 0;
        int start = 0;
        int end = size - 1;
        while (start < end) {
            if (arr[start] <= arr[end]) {
                sortedArray[pos++] = arr[start++];
            } else {
                sortedArray[pos++] = arr[end--];
            }
        }
        sortedArray[pos] = arr[start];
        return sortedArray;
    }
}
