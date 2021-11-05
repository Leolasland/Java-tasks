import java.util.*;

public class Level1 {
  public static int [] MadMax(int N, int [] Tele) {
    int [] startImpulse = new int [N];
    int x = 0;
    boolean change = true;

    for (int i = 0; i < N; i++) {
      startImpulse[i] = Tele[i];
    }

    while (change) {
      change = false;
      for (int i = 0; i < (N - 1); i++) {
        if (startImpulse[i] > startImpulse[i + 1]) {
          x = startImpulse[i];
          startImpulse[i] = startImpulse[i + 1];
          startImpulse[i + 1] = x;
          change = true;
        }
      }
    }
    change = true;
    while (change) {
      change = false;
      for (int i = N / 2; i < (N - 1); i++) {
        if (startImpulse[i] < startImpulse[i + 1]) {
          x = startImpulse[i];
          startImpulse[i] = startImpulse[i + 1];
          startImpulse[i + 1] = x;
          change = true;
        }
      }
    }

    return startImpulse;
  }
}
