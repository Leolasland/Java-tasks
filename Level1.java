import java.util.*;

public class Level1 {
  public static String TheRabbitsFoot(String s, boolean encode) {
    String res;
    if (encode) {
      res = encrypt(s);
    } else {
      res = decrypt(s);
    }
    return res;
  }

  static String encrypt(String s) {
    String res;
    int len;
    int line;
    int column;
    res = s.replaceAll("\\s+", "");
    len = res.length();
    line = (int) Math.floor(Math.sqrt(len));
    column = (int) Math.ceil(Math.sqrt(len));
    if ((line * column) < len) {
      line++;
    }
    String[] matrix = new String[line];
    for (int i = 0; i < line; i++) {
      if (column * (i + 1) > len) {
        matrix[i] = res.substring(column * i, len);
      } else {
        matrix[i] = res.substring(column * i, column * (i + 1));
      }
    }
    res = collectString(matrix, column, line);
    return res;
  }

  static String decrypt(String s) {
    String res;
    String [] matrix = s.split("\\s+");
    int len;
    int line;
    int column;
    res = s.replaceAll("\\s+", "");
    len = res.length();
    line = (int)Math.floor(Math.sqrt(len));
    column = (int)Math.ceil(Math.sqrt(len));
    if ((line * column) < len) {
      line++;
    }
    res = collectString(matrix, line, column);
    return res;
  }

  static String collectString(String [] matrix, int column, int line) {
    StringBuilder bld = new StringBuilder();
    String res;
    for (int i = 0; i < column; i++) {
      for (int j = 0; j < line; j++) {
        bld.append(giveSymbol(matrix[j], i));
      }
      if (i + 1 < column) {
        bld.append(" ");
      }
    }
    res = bld.toString();
    return res;
  }

  static String giveSymbol(String s, int i) {
    String symbol = "";
    if (s.length() > i) {
      symbol = String.valueOf(s.charAt(i));
    }
    return symbol;
  }
}
