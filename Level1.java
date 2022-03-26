import java.util.*;

public class Level1 {

  static String result = "";
  static List<String> tmp = new ArrayList<>();
  static int point = 0;
  static boolean isUndo = false;


  static String BastShoe(String command) {
    char findCommand = command.charAt(0);
    if (command.length() > 2) {
      command = command.substring(2);
      if (findCommand  == '4' || findCommand  == '5' || (findCommand  == '3' && !command.matches("^[0-9]")))
        return result;
      if (!tmp.isEmpty() && isUndo) {
        String str = result;
        tmp.clear();
        tmp.add(str);
      }
      if (findCommand == '3' && result != null) {
        result = issueChar(command);
        isUndo = false;
      }
      else {
        if (findCommand == '1') {
          result = result + command;
        }
        else if (findCommand == '2' && result != null) {
          result = deleteNCharacters(command);
        }
        isUndo = false;
        tmp.add(findCommand + result);
        point = tmp.size() - 1;
      }
    }
    else if (findCommand == '4') {
      result = undo();
      isUndo = true;
    }
    else if (findCommand == '5') {
      result = redo();
    }
    return result;
  }

  static String deleteNCharacters(String command) {
    int n = Integer.parseInt(command);
    if (n >= result.length() || n < 0)
      return result = "";
    return result.substring(0, result.length() - n);
  }

  static String issueChar(String command) {
    int n = Integer.parseInt(command);
    if (n >= tmp.get(tmp.size() - 1).length() || n < 0)
      return "";
    String str = tmp.get(tmp.size() - 1).substring(1);
    return String.valueOf(str.charAt(n));
  }

  static String undo() {
    point--;
    String last = result;
    if (point >= 0 && point <= (tmp.size() - 1))
    {
      if (!tmp.get(point).isEmpty() && Character.isDigit(tmp.get(point).charAt(0)))
        last = tmp.get(point).substring(1);
      else
        last = tmp.get(point);
    }
    return last;
  }

  static String redo() {
    point++;
    String last = result;
    if (point <= (tmp.size() - 1) && point >= 0)
      last = tmp.get(point).substring(1);
    if (point >= tmp.size())
      point--;
    return last;
  }
}
