package helloworld;

import java.util.Arrays;

public class Solution {
    public static int[][] addTwoMat(int[][] a, int[][] b) {
//  int[][] a = {{3,2,1},{3,4,4}};
//  int[][] b = {{-1,0,-1},{4,2,1}};
        int m = a.length, n = a[0].length;
        int[][] c = new int[m][n];
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Cannot sum two matrices with different sizes.");
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = a[i][j] + b[i][j];

                    if (j == n - 1) {
                        System.out.println(c[i][j]);
                    } else {
                        System.out.print(c[i][j] + " ");
                    }
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][]{{3, 2, 1}, {3, 4, 4}};
        int[][] b = new int[][]{{-1, 0, -1}, {4, 2, 1}};
        solution.addTwoMat(a, b);

    }
}