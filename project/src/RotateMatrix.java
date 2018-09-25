

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		rotate(input);

		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input.length; j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void  rotate(int[][] matrix) {
		int size = matrix.length;
		int L = size % 2 == 0 ? size / 2 : size / 2 + 1;

		for (int layer = 1; layer <= L; layer++) {
			//rotate corners
			int start = layer - 1;
			int end = size - layer;
			
			if (start == end) break;
			
			int temp = matrix[start][start];
			matrix[start][start] = matrix[end][start];
			matrix[end][start] = matrix[end][end];
			matrix[end][end] = matrix[start][end];
			matrix[start][end] = temp;

			//rotate body
			int[] temp2 = new int[size-2*layer];
			for(int i = 0; i < temp2.length; i++) {
				temp2[i] = matrix[start][start+i+1];
			}

			for(int i = 0; i < 4; i++) {
				for(int j = 1; j <= temp2.length; j++) {
					switch(i) {
						case 0:
							matrix[start][start+j] = matrix[end-j][start];
							continue;
						case 1:
							matrix[start+j][start] = matrix[end][start+j];
							continue;
						case 2:
							matrix[end][start+j] = matrix[end-j][end];
							continue;
						default:
							matrix[start+j][end] = temp2[j-1];
							continue;

					}
				}
			}
		}
	}

}
