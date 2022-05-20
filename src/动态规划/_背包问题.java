package 动态规划;

// 给定两个长队都为N的数组 weights 和 values， weights[i] 和 values[i] 分别代表 i 号物品的重量和价值。给定一个正数 bag，
// 表示一个载重 bag 的袋子，
// 你装的物品不能超过这个重量。
// 返回你能装下的价值是多少？

public class _背包问题 {
    // 不变： w[] v[] bag
    // index... 最大价值
    // 0...index-1 上做了货物的选择，使得你已经达到的货物重量是多少alreadyW
    // 返回 -1 认为没有方案
    // 如果不返回 -1，认为返回的值是有真实价值的
    public int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }
        // 最后一个元素
        if (index == w.length) {
            return 0;
        }
        int p1 = process(w, v, index + 1, alreadyW, bag);
        int p2Next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    // 只剩下 rest 的空间了。
    // index.... 货物自由选择，但是剩余空间不要小于0
    // 返回 index.... 货物能够获得的最大值
    public int process2(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        // rest >=0
        if (index == w.length) {
            return 0;
        }
        int p1 = process2(w, v, index + 1, rest);
        int p2Next = process2(w, v, index, rest - w[index]);
        int p2 = -1;
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        _背包问题 a = new _背包问题();
        int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
		int[] values = { 5, 6, 3, 19, 12, 4, 2 };
		int bag = 15;
        int res = a.process2(weights, values, 0, bag);
        System.out.println(res);
    }
    
}
