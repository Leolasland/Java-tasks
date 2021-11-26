import java.util.*;

public class wordsearch {
  public static int [] WordSearch(int len, String s, String subs) {
    String[] words = s.split("\\s+");
    ArrayList<String> arrWords = new ArrayList<>();
    StringBuilder stringBuffer = new StringBuilder();
    int count = 0;
    int index = 0;
    while (index != words.length) {
      if (count + words[index].length() <= len) {
        count += words[index].length() + 1;
        stringBuffer.append(words[index]).append(" ");
        index++;
      } else {
        if (words[index].length() > len) {
          stringBuffer.append(words[index], 0, len).append(" ");
          arrWords.add(stringBuffer.toString());
          stringBuffer = new StringBuilder();
          stringBuffer.append(words[index].substring(len)).append(" ");
          index++;
        }
        arrWords.add(stringBuffer.toString());
        stringBuffer = new StringBuilder();
        count = 0;
      }
    }
    if (stringBuffer.length() > 0) {
      arrWords.add(stringBuffer.toString());
    }

    words = arrWords.toArray(new String[0]);
    int [] word = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      if (strCheck(words[i], subs)) {
        word[i] = 1;
      } else {
        word[i] = 0;
      }
    }
    return word;
  }

  static boolean strCheck(String words, String subs) {
    String [] checkArray = words.split("\\s+");
    for (String s : checkArray) {
      if (s.equals(subs)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(WordSearch(12, "строка разбивается на набор строк через выравнивание по заданной ширине.", "строк")));
  }
}
