import java.util.*;

public class Level1 {
  public static void MatrixTurn(String [] Matrix, int M, int N, int T) {
    StringBuilder [] builder = new StringBuilder[M];
    int count = 0;
    if (M > N) {
      count = N / 2;
    } else {
      count = M / 2;
    }
    for (int i = 0; i < M; i++) {
      builder[i] = new StringBuilder(Matrix[i]);
    }

    for (int i = 1; i <= T ; i++) {
      for (int j = 0; j < count; j++) {
        for (int k = j; k < builder.length - 1 - j; k++) {
          builder[k].insert(j, builder[k + 1].charAt(j));
          builder[k + 1].delete(j, j + 1);
        }
        for (int k = builder.length - 1 - j; k > j ; k--) {
          builder[k].insert(builder[k].length() - j, builder[k - 1].charAt(builder[k - 1].length() - 1 - j));
          builder[k - 1].delete(builder[k - 1].length() - 1 - j, builder[k - 1].length() - j);
        }
      }
    }

    for (int i = 0; i < builder.length; i++) {
      Matrix[i] = builder[i].toString();
    }
  }
}
