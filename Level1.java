import java.util.*;

public class Level1 {
  static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
    boolean find = false;
    int [][] map = convertor(H1, W1, S1);
    int [][] value = convertor(H2, W2, S2);
    for (int i = 0; i < H1; i++) {
      for (int j = 0; j < W1; j++) {
        if (map[i][j] == value[0][0]) {
          find = checkNext(map, value, i, j, H2, W2);
        }
        if (find) {
          break;
        }
      }
      if (find) {
        break;
      }
    }
    return find;
  }

  static int [][] convertor(int h, int w, String str) {
    int [][] arr = new int[h][w];
    str = str.replaceAll("\\s+", "");
    char [] strArr = str.toCharArray();
    int count = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        arr[i][j] = Character.getNumericValue(strArr[count]);
        count++;
      }
    }
    return arr;
  }

  static boolean checkNext(int [][] map, int [][] value, int posX, int posY, int h, int w) {
    for (int i = 0; i < h; i++) {
      for (int j = 0 ; j < w; j++) {
        if (((posX + i) >= map.length) || ((posY + j >= map[i].length)) || (map[posX + i][posY + j] != value[i][j]))
          return false;
      }
    }
    return true;
  }
}
