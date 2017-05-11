

public class NQueen {

	public static void main(String[] args) {
		NQueen board = new NQueen(8);
		board.solve();
		board.printSolutionNumber();
	}
	

	private int N;
	private int solutionCount;
	private int board[][];

	public NQueen(int N) {
		this.N = N;
		this.solutionCount = 0;
		this.board = new int[N][N];
	}

	public boolean isSafe(int row, int col) {

		for (int c = 0; c < col; c++) {
			if (board[row][c] == 1) {
				return false;
			}
		}

		for (int r = row-1, c = col-1; r >= 0 && c >= 0 ; r--, c--) {
			if (board[r][c] == 1) {
				return false;
			}
		}

		for (int r = row+1, c = col-1; r < N && c >= 0 ; r++, c--) {
			if (board[r][c] == 1) {
				return false;
			}
		}

		return true;
	}

	public void solve() {
		solve(0);
	}

	public void solve(int col) {
		if (col == N) {
			this.solutionCount++;
			printSolution();
			System.out.println();
		}

		for (int r = 0; r < N; r++) {
			if (isSafe(r, col)) {
				board[r][col] = 1;

				solve(col + 1);

				board[r][col] = 0;
			}
		}
	}

	public void printSolutionNumber() {
		System.out.println("Thera are " + this.solutionCount + " soutions.");
	}

	/* A utility function to print solution */
    public void printSolution()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
}