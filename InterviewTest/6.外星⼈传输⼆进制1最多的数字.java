/*
 * 给定n个整数，输出⼆进制表⽰中1的个数最多的前m个数字（按1的数量降序，若相同则数值⼤
的优先）。
输⼊：n个整数，m值。
输出：前m个数字。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr, int n, int m) {
        ArrayList<Integer> nList = new ArrayList<Integer>();
        for (int item : arr) {
            nList.add(item);
        }
        Collections.sort(nList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = countOne(o1);
                int count2 = countOne(o2);
                if (count1 != count2) {
                    return count2 - count1;
                } else {
                    return o2 - o1;
                }
            }
        });
        int size = Math.min(n, m);
        int[] retArray = new int[size];
        for (int i = 0; i < size; i++) {
            retArray[i] = nList.get(i);
        }
        return retArray;
    }

    private int countOne(int n) {
        int result = 0;
        int left = n;
        while (left > 0) {
            result++;
            left = left & (left - 1);
        }
        return result;
    }
}