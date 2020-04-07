package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 16:42
 * @Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 不同路径II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < cols; i++)
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;   // 遇到障碍后面的都无法到达直接返回就行 默认就是0
            }
            else dp[0][i] = 1;

        for (int i = 0; i < rows; i++)
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;  // 遇到障碍后面的都无法到达直接返回就行 默认就是0
            }
            else dp[i][0] = 1;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)  dp[i][j] = 0; // 遇到障碍就是0
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // dpdpdp
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
