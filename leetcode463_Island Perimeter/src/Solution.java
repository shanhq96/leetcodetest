import org.junit.jupiter.api.Test;

/**
 * @author shanhq96@gmail.com
 * @ClassName 463_Island Perimeter
 * @Description You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * Example:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * Answer: 16
 * @date 2017/3/26-18:01
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islandPerimeter = 0;
        int[][] gridExtanded = extandGrid(grid);//将原数组进行扩大一圈,以便判断边界.
        if (gridExtanded != null) {
            for (int i = 1; i < gridExtanded.length - 1; i++) {
                for (int j = 1; j < gridExtanded[0].length - 1; j++) {
                    if (gridExtanded[i][j] == 1) {//若陆地与海水相邻,则周长加一
                        if (gridExtanded[i-1][j] == 0) {islandPerimeter++;}
                        if (gridExtanded[i+1][j] == 0) {islandPerimeter++;}
                        if (gridExtanded[i][j-1] == 0) {islandPerimeter++;}
                        if (gridExtanded[i][j+1] == 0) {islandPerimeter++;}
                    }
                }
            }
        }
        return islandPerimeter;
    }

    private int[][] extandGrid(int[][] grid) {
        if (grid == null || grid[0] == null) return null;
        int[][] gridExtanded = new int[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < gridExtanded.length; i++) {
            gridExtanded[i][0] = 0;
            gridExtanded[i][grid[0].length] = 0;
        }
        for (int j = 0; j < gridExtanded[0].length; j++) {
            gridExtanded[0][j] = 0;
            gridExtanded[grid.length][0] = 0;
        }
        for (int i = 1; i < gridExtanded.length - 1; i++) {
            for (int j = 1; j < gridExtanded[0].length - 1; j++) {
                gridExtanded[i][j] = grid[i - 1][j - 1];
            }
        }
        return gridExtanded;
    }

    @Test
    public void testExtandGrid() {
        /**
         [[0,1,0,0],
         [1,1,1,0],
         [0,1,0,0],
         [1,1,0,0]]
         */
        int[][] testArray = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        islandPerimeter(testArray);
    }

    @Test
    public void testIslandPerimeter(){
        int[][] testArray = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.print(islandPerimeter(testArray));
    }
}
