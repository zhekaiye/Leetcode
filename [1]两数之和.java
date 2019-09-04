//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //执行耗时:52 ms,击败了39.09% 的Java用户
        //内存消耗:37.7 MB,击败了85.30% 的Java用户
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] { i, j };
//                }
//            }
//        }
        //执行耗时:5 ms,击败了95.95% 的Java用户
        //内存消耗:39.2 MB,击败了46.80% 的Java用户
        HashMap<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (cacheMap.containsKey(another)) {
                return new int[] { cacheMap.get(another), i };
            } else {
                cacheMap.put(nums[i], i);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
