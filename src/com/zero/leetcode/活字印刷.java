package com.zero.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-17 10:50
 * @Description: 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 活字印刷 {


    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        String[] split = tiles.split("");
        int[] pb = new int[split.length];
        dfs(split, pb,new StringBuilder(""), set);
        return set.size();
    }

    public void dfs(String[] tiles, int[] pb, StringBuilder str, HashSet<String> set) {
        // 1. 截止条件
        if (!str.toString().equals("")) {
            set.add(str.toString());
        }
        // 2. 找出候选人
        for (int i = 0; i < tiles.length; i++) {
            if (pb[i] == 0) {
                str.append(tiles[i]);
                pb[i] = 1;
                dfs(tiles, pb, str, set);
                str.deleteCharAt(str.length() - 1);
                pb[i] = 0;

            }
        }
    }

    public static void main(String[] args) {
        活字印刷 活字印刷 = new 活字印刷();
        活字印刷.numTilePossibilities("ABCD");
    }

}
