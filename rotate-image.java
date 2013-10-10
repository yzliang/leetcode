public class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        int half = size / 2;
        for (int i = 0; i < half; i++)
            for (int j = 0; j < half; j++)
                rotatePixel(matrix, i, j);
        if (size % 2 != 0) {
            for (int i = 0; i < half; i++)
                rotatePixel(matrix, i, half);
        }
    }

    private void rotatePixel(int[][] matrix, int i, int j) {
        int size = matrix.length;
        int current = matrix[i][j];
        int x = i, y = j;
        // 4->1, 3->4, 2->3.
        for (int k = 0; k < 3; k++) {
            matrix[x][y] = matrix[size - 1 - y][x];
            int temp = x;
            x = size - 1 - y;
            y = temp;
        }
        // 1->2.
        matrix[j][size - 1 - i] = current;
    }
}
