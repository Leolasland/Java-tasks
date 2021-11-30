import java.util.*;

public class Level1 {
  static int Unmanned(int L, int N, int [][] track) {
    int res = track[0][0];

    if (track[0][0] >= L) {
      return L;
    }
    for (int i = 0; i < N; i++) {
      if (stop(track[i][1], track[i][2], res)) {
        res += minutes(track[i][1], track[i][2], res);
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
    if (i % 2 == 0) {
      return false;
    } else {
      return true;
    }
  }
  static int minutes(int red, int green, int res) {
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
    if (res < 0) {
      res *= -1;
    }
    return res;
  }
}
