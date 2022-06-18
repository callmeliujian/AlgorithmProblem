package Greedy贪心;

import java.util.*;

public class _455_分发饼干 {

    // 解法1：优先考虑饼干，小饼干先喂饱小胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    // 思路2：优先考虑胃口，先喂饱大胃口
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = s.length - 1;
        int count = 0;
        for (int i = g.length - 1; i >= 0 && start >= 0; i--) {
            if (g[i] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }

}
