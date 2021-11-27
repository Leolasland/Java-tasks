import java.util.*;

public class Level1 {
  static int [] UFO(int N, int [] data, boolean octal) {
    int [] res = new int [N];
    if (octal) {
      res = transToOstal(N, data);
    } else {
      res = transToHex(N, data);
    }
    return res;
  }

  static int [] transToOstal(int N, int [] data) {
    int [] res = new int[N];
    for (int i = 0; i < N; i++) {
      res[i] = Integer.parseInt(String.valueOf(data[i]), 8);
    }
    return res;
  }

  static int [] transToHex(int N, int [] data) {
    int [] res = new int[N];
    for (int i = 0; i < N; i++) {
      res[i] = Integer.parseInt(String.valueOf(data[i]), 16);
    }
    return res;
  }
}
