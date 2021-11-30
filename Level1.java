import java.util.*;

public class Level1 {
  static int Unmanned(int L, int N, int [][] track) {
    int res = 0;

    if (track[0][0] >= L) {
      return L;
    }
    for (int i = 0; i < N; i++) {
      if (stop(track[i][1], track[i][2], res)) {
        res += (track[i][1] - res);
      }
      if (i + 1 < N) {
        res += (track[i + 1][0] - track[i][0]);
      }
    }
    res += (L - track[N - 1][0]);
    return res;
  }

  static boolean stop(int red, int green, int res) {
    int i = 0;
    while (res >= 0){
      if (i % 2 == 0) {
        res -= red;
        i++;
      } else {
        res -= green;
        i++;
      }
    }
    return i % 2 == 0;
  }
}
