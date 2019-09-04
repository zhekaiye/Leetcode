//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        boolean isPositive = (x >= 0);
        if (x < 0) {
            x = -x;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (x > 0) {
            list.add(x % 10);
            x = x / 10;
        }
        long result = 0;
        for (int i = 0; i < list.size(); i++) {
            int item = list.get(i);
            if (i == 0 && item == 0) {
                continue;
            }
            result = result * 10 + item;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        if (!isPositive) {
            result = -result;
        }
        return (int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
