

public class MaxRectangle {

  public int compute(int[][] M) {
    int ROW = M.length;
    int COLUMN = M[0].length;

    int S[][] = new int[COLUMN][ROW];

    S[0][0] = M[0][0];
    for (int r = 1; r < ROW; r++) {
      if (M[r][0] == 1) {
        S[r][0] = S[r-1][0] + 1;
      } else {
        S[r][0] = 0;
      }
    }

    for (int c = 1; c < COLUMN; c++) {
      if(M[0][c] == 1) {
        S[0][c] = S[0][c-1] + 1;
      } else {
        S[0][c] = 0;
      }
    }

    for(int r = 1; r < ROW; r++) {
      for(int c = 1; c < COLUMN; c++) {

      }
    }
  }

  public int max(int a, int b) {
    if (a > b) {
      return a;
    } else {
      return b;
    }
  }
}

}
