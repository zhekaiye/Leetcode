/*
 * 找出两个列表中不共有的元素。
 * 输⼊：两个数组
 * 输出：⾮共有元素列表；
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] findNotCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int item : arr1) {
            set1.add(item);
        }
        for (int item : arr2) {
            set2.add(item);
        }
        Set<Integer> trimSet1 = new HashSet<Integer>(set1);
        trimSet1.removeAll(set2);
        Set<Integer> trimSet2 = new HashSet<Integer>(set2);
        trimSet2.removeAll(set1);

        List<Integer> result = new ArrayList<Integer>();
        result.addAll(trimSet1);
        result.addAll(trimSet2);
        int[] retArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            retArray[i] = result.get(i);
        }
        return retArray;
    }
}