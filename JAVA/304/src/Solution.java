
public class Solution {

	public static void main(String[] argv) {

		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		NumMatrix test = new NumMatrix(matrix);
		int one = test.sumRegion(1, 2, 2, 4);
		System.out.println(one);

		int twe = test.sumRegion(1, 1, 2, 2);
		System.out.println(twe);

		System.out.println("End");
	}

	public static class NumMatrix {
		int[][] matrix_sum;
		public NumMatrix(int[][] matrix) {
			matrix_sum = new int[matrix.length][matrix[0].length];
			for (int i = 0; i < matrix.length; i++)
				for (int j = 0; j < matrix[0].length; j++) {
					if (i == 0) {
						if(j == 0)
							matrix_sum[i][j] = matrix[i][j];
						else
							matrix_sum[i][j] = matrix[i][j] + matrix_sum[i][j-1];
					} else {
						if(j == 0)
							matrix_sum[i][j] = matrix[i][j] + matrix_sum[i-1][j];
						else
							matrix_sum[i][j] = matrix[i][j] + matrix_sum[i][j-1] + matrix_sum[i-1][j] - matrix_sum[i-1][j-1];
					}
				}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int total = 0;
			if(row1 ==0 && col1 == 0)
				total = matrix_sum[row2][col2];
			else if(row1 == 0)
				total = matrix_sum[row2][col2] - matrix_sum[row2][col1-1];
			else if(col1 == 0)
				total = matrix_sum[row2][col2] - matrix_sum[row1-1][col2];
			else 
				total = matrix_sum[row2][col2] - matrix_sum[row2][col1-1] - matrix_sum[row1-1][col2] + matrix_sum[row1-1][col1-1];
			return total;
		}
	}
}
