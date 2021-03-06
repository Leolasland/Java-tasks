import java.util.*;

public class conquestcampaign {
  public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
    int day = 1;
    int field = N * M;
    int [][] fieldCoordinate = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        fieldCoordinate[i][j] = 0;
      }
    }

    for (int i = 0; i < battalion.length; i += 2) {
      if (fieldCoordinate[battalion[i] - 1][battalion[i + 1] - 1] == 0) {
        fieldCoordinate[battalion[i] - 1][battalion[i + 1] - 1] = 1;
        field--;
      }
    }

    while (field != 0) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (fieldCoordinate[i][j] == day) {
            if (((i - 1) >= 0) && (fieldCoordinate[i - 1][j] == 0)) {
              fieldCoordinate[i - 1][j] = day + 1;
              field--;
            }
            if (((j - 1) >= 0) && (fieldCoordinate[i][j - 1] == 0)) {
              fieldCoordinate[i][j - 1] = day + 1;
              field--;
            }
            if (((j + 1) < M) && (fieldCoordinate[i][j + 1] == 0)) {
              fieldCoordinate[i][j + 1] = day + 1;
              field--;
            }
            if (((i + 1) < N) && (fieldCoordinate[i + 1][j] == 0)) {
              fieldCoordinate[i + 1][j] = day + 1;
              field--;
            }
          }
        }
      }
      day++;
    }
    return day;
  }

  public static void main(String[] args) {
    int N = 3, M = 4, L = 2;
    int [] battalion = {2, 2, 3, 4};
    System.out.println(ConquestCampaign(N, M, L, battalion));
  }
}
