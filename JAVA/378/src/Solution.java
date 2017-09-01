import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] argv) {

//		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matrix = { { 1, 2, 4,6 }, { 2, 2, 7, 8 }, { 1, 2, 11, 12 }, { 1, 4, 15, 16 } };
		int k = 6;
		int Ans = kthSmallest(matrix, k);
		System.out.println(Ans);
	}

	public static int kthSmallest(int[][] matrix, int k) {
		//參考別人方法 ( binary search)
		int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;			
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0, j = matrix[0].length - 1;
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid)
					j--;
				count += (j + 1);
			}
			if (count < k)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	//參考別人方法 ( priority queue)
//	public static int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
//                public int compare(Integer i1, Integer i2) {
//                    int x1 = i1 / n;
//                    int y1 = i1 % n;
//                    int x2 = i2 / n;
//                    int y2 = i2 % n;
//                    return matrix[x1][y1] - matrix[x2][y2];
//                }
//            });
//        for (int i = 0; i < n; i++) {
//            pq.add(i * n);
//        }
//        for (int i = 1; i < k; i++) {
//            int cur = pq.poll();
//            if (cur % n != n - 1) {
//                pq.add(cur + 1);
//            }
//        }
//        int kth = pq.poll();
//        return matrix[kth / n][kth % n];
//    }
}


// error thinking
// public static int kthSmallest(int[][] matrix, int k) {
// int n = matrix.length;
// int row = k / n;
// int column = k % n;
//
// if(row == 0)
// return column ==0 ? matrix[0][0] : matrix[0][column-1];
//
// else if( column == 0){
// return matrix[row - 1][n-1];
// }
//
// else{
// return matrix[row][column-1];
// }
// }
