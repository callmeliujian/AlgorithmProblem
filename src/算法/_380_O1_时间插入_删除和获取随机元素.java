package 算法;
import java.util.*;

public class _380_O1_时间插入_删除和获取随机元素 {

//    实现RandomizedSet 类：
//
//    RandomizedSet() 初始化 RandomizedSet 对象
//    bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
//    bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
//    int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
//    你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
//
//             
//
//    示例：
//
//    输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
//        [[], [1], [2], [2], [], [1], [2], []]
//    输出
//[null, true, false, true, 2, true, false, 2]
//
//    解释
//    RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/insert-delete-getrandom-o1
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    class RandomizedSet {

        List<Integer> nums;
        Map<Integer, Integer> indices;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) return false;
            indices.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) return false;
            // 删除元素的位置
            int valIndex = indices.get(val);
            // 最后一个元素
            int lastNum = nums.get(nums.size() - 1);
            // 更新数据
            nums.set(valIndex,lastNum);
            indices.put(lastNum,valIndex);
            // 移除数据
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }
}
