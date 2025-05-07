/*
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxPos < i) {
                return false;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}