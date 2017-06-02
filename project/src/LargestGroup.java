

public class LargestGroup {

	public static void main(String[] args) {
		int[][] matrix = {
							{1, 0, 0, 0, 0, 0, 1, 0},
							{0, 0, 0, 0, 1, 0, 0, 0},
							{1, 0, 1, 0, 0, 1, 0, 1},
							{1, 0, 1, 1, 0, 1, 0, 1},
							{1, 0, 1, 0, 1, 1, 0, 1},
							{1, 0, 1, 0, 0, 1, 0, 1},
							{1, 0, 1, 0, 0, 1, 0, 1},
							{1, 0, 1, 0, 0, 1, 0, 1},
							{1, 0, 1, 0, 0, 1, 0, 1},
							{1, 0, 1, 0, 0, 1, 0, 1},
						 };
		System.out.println(findLargestGroupSize(matrix));
	}


	public static int findLargestGroupSize(int[][] matrix) {
		int[][] cloned = matrix.clone();

		int maxSize = 0;
		for(int row = 0; row < cloned.length; row++) {
			for (int col = 0; col < cloned[0].length; col++) {
				if (cloned[row][col] == 1) {
					int size = findCurrentGroupSize(cloned, row, col);
					maxSize = Math.max(size, maxSize);
				}
			}
		}

		return maxSize;
	}

	public static int findCurrentGroupSize(int[][] matrix, int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
			return 0;
		}

		if (matrix[row][col] == 0) {
			return 0;
		} else {
			matrix[row][col] = 0;
			int size = 1;
			size += findCurrentGroupSize(matrix, row-1, col);
			size += findCurrentGroupSize(matrix, row+1, col);
			size += findCurrentGroupSize(matrix, row, col-1);
			size += findCurrentGroupSize(matrix, row, col+1);
			size += findCurrentGroupSize(matrix, row-1, col-1);
			size += findCurrentGroupSize(matrix, row+1, col-1);
			size += findCurrentGroupSize(matrix, row+1, col+1);
			size += findCurrentGroupSize(matrix, row-1, col+1);
			return size;
		}


	}
	
}