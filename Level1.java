import java.util.*;

public class Level1 {

  static String[] TreeOfLife(int H, int W, int N, String[] tree) {
    for (int i = 0; i <= N; i++) {
      if (i == 0) {
        for (int j = 0; j < H; j++) {
          tree[j] = tree[j].replace("+", "1");
          tree[j] = tree[j].replace(".", "0");
        }
      } else if (i % 2 == 0) {
        age(tree);
        delete(tree, H, W);
      } else {
        age(tree);
      }
    }

    for (int i = 0; i < H; i++) {
      tree[i] = tree[i].replace("0", ".");
      tree[i] = tree[i].replace("1", "+");
      tree[i] = tree[i].replace("2", "+");
      tree[i] = tree[i].replace("3", "+");
      tree[i] = tree[i].replace("4", "+");
    }

    return tree;
  }

  static String[] age(String[] tree) {
    for (int i = 0; i < tree.length; i++) {
      tree[i] = tree[i].replace("3", "4");
      tree[i] = tree[i].replace("2", "3");
      tree[i] = tree[i].replace("1", "2");
      tree[i] = tree[i].replace("0", "1");
    }
    return tree;
  }

  static String[] delete(String[] tree, int h, int w) {
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (tree[i].charAt(j) == '3' || tree[i].charAt(j) == '4') {
          if (i == 0 && j == 0) {
            tree[i] = build(tree[i], j, '0');
            if (tree[i].charAt(j + 1) == '1' || tree[i].charAt(j + 1) == '2') {
              tree[i] = build(tree[i], j + 1, '0');
            }
            if (tree[i + 1].charAt(j) == '1' || tree[i + 1].charAt(j) == '2') {
              tree[i + 1] = build(tree[i + 1], j, '0');
            }
          }

          if (i == 0 && j > 0 && j < (w - 1)) {
            tree[i] = build(tree[i], j, '0');
            tree[i] = build(tree[i], j - 1, '0');
            if (tree[i].charAt(j + 1) == '1' || tree[i].charAt(j + 1) == '2') {
              tree[i] = build(tree[i], j + 1, '0');
            }
            if (tree[i + 1].charAt(j) == '1' || tree[i + 1].charAt(j) == '2') {
              tree[i + 1] = build(tree[i + 1], j, '0');
            }
          }

          if (i == 0 && j > 0 && j == (w - 1)) {
            tree[i] = build(tree[i], j, '0');
            tree[i] = build(tree[i], j - 1, '0');
            if (tree[i + 1].charAt(j) == '1' || tree[i + 1].charAt(j) == '2') {
              tree[i + 1] = build(tree[i + 1], j, '0');
            }
          }

          if (i > 0 && i < (h - 1) && j == 0) {
            tree[i] = build(tree[i], j, '0');
            tree[i - 1] = build(tree[i - 1], j, '0');
            if (tree[i].charAt(j + 1) == '1' || tree[i].charAt(j + 1) == '2') {
              tree[i] = build(tree[i], j + 1, '0');
            }
            if (tree[i + 1].charAt(j) == '1' || tree[i + 1].charAt(j) == '2') {
              tree[i + 1] = build(tree[i + 1], j, '0');
            }
          }

          if (i > 0 && i < (h - 1) && j > 0 && j < (w - 1)) {
            tree[i] = build(tree[i], j, '0');
            tree[i - 1] = build(tree[i - 1], j, '0');
            tree[i] = build(tree[i], j - 1, '0');
            if (tree[i].charAt(j + 1) == '1' || tree[i].charAt(j + 1) == '2') {
              tree[i] = build(tree[i], j + 1, '0');
            }
            if (tree[i + 1].charAt(j) == '1' || tree[i + 1].charAt(j) == '2') {
              tree[i + 1] = build(tree[i + 1], j, '0');
            }
          }

          if (i > 0 && i < h && j == (w - 1)) {
            tree[i] = build(tree[i], j, '0');
            tree[i - 1] = build(tree[i - 1], j, '0');
            tree[i] = build(tree[i], j - 1, '0');
          }

          if (i == (h - 1) && j == 0) {
            tree[i] = build(tree[i], j, '0');
            tree[i - 1] = build(tree[i - 1], j, '0');
            if (tree[i].charAt(j + 1) == '1' || tree[i].charAt(j + 1) == '2') {
              tree[i] = build(tree[i], j + 1, '0');
            }
          }

          if (i == (h - 1) && j > 0 && j < (w - 1)) {
            tree[i] = build(tree[i], j, '0');
            tree[i - 1] = build(tree[i - 1], j, '0');
            tree[i] = build(tree[i], j - 1, '0');
            if (tree[i].charAt(j + 1) == '1' || tree[i].charAt(j + 1) == '2') {
              tree[i] = build(tree[i], j + 1, '0');
            }
          }

          if (i == (h - 1) && j == (w - 1)) {
            tree[i] = build(tree[i], j, '0');
            tree[i - 1] = build(tree[i - 1], j, '0');
            tree[i] = build(tree[i], j - 1, '0');
          }
        }
      }
    }

    return tree;
  }

  static String build(String tree, int index, char ch) {
    StringBuilder builder = new StringBuilder(tree);
    builder.setCharAt(index, ch);
    return builder.toString();
  }
}
