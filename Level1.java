import java.util.*;

public class Level1 {
  static String [] ShopOLAP(int N, String [] items) {
    String [][] resArr = new String[N][N];
    HashMap<String, Integer> resMap = new HashMap<>();
    resArr = arrString(N, items);
    findDup(N, resArr);
    resArr = removeNull(N, resArr);
    for (int i = 0; i < resArr.length; i++) {
      resMap.put(resArr[i][0], Integer.parseInt(resArr[i][1]));
    }
    int [] arr = new int[resMap.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = resMap.get(resArr[i][0]);
    }
    sorting(arr);
    ArrayList<String> arrNames = new ArrayList<>(resMap.keySet());
    ArrayList<Integer> arrNumb = new ArrayList<>(resMap.values());
    resArr = new String[arrNames.size()][2];
    for (int i = 0; i < resMap.size(); i++) {
      resArr[i][0] = arrNames.get(arrNumb.indexOf(arr[i]));
      resArr[i][1] = Integer.toString(arrNumb.get(arrNumb.indexOf(arr[i])));
      arrNames.remove(arrNumb.indexOf(arr[i]));
      arrNumb.remove(arrNumb.indexOf(arr[i]));
    }
    check(resArr);
    String [] res = new String[resArr.length];
    for (int i = 0; i < resArr.length; i++) {
      res[i] = resArr[i][0] + " " + resArr[i][1];
    }
    return res;
  }

  static String [][] arrString(int N, String [] res) {
    String [][] resArr = new String[N][N];
    for (int i = 0; i < N; i++) {
      resArr[i] = res[i].split(" ");
    }
    return resArr;
  }

  static void findDup(int N, String [][] resArr) {
    for (int i = 0; i < N; i++) {
      if (resArr[i] == null)
        continue;
      for (int j = 0; j < N; j++) {
        if (i == j || resArr[j] == null)
          continue;
        if (resArr[i][0].equals(resArr[j][0])) {
          resArr[i][1] = Integer.toString(Integer.parseInt(resArr[i][1]) + Integer.parseInt(resArr[j][1]));
          resArr[j] = null;
        }
      }
    }
  }

  static String [][] removeNull(int N, String [][] resArr) {
    String [] res = new String[N];
    ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      if (resArr[i] == null)
        continue;
      res[i] = resArr[i][0] + " " + resArr[i][1];
    }
    for (int i = 0; i < N; i++) {
      arr.add(res[i]);
    }
    arr.remove(null);
    res = new String[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      res[i] = arr.get(i);
    }
    resArr = new String[arr.size()][arr.size()];
    resArr = arrString(arr.size(), res);
    return resArr;
  }

  static void sorting(int [] arr) {
    boolean xchange = true;
    int x;
    while(xchange) {
      xchange = false;
      for(int i = 0; i < arr.length - 1; i ++)
        if(arr[i] < arr[i+1]) {
          x = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] = x;
          xchange = true;
        }
    }
  }

  static void check(String [][]resArr) {
    String str = "";
    String strTmp = "";
    for (int i = 0; i < resArr.length; i++) {
      for (int j = 0; j < resArr.length; j++) {
        if (i == j)
          continue;
        if (resArr[i][1].equals(resArr[j][1])) {
          str = new String(resArr[i][0]);
          strTmp = new String(resArr[j][0]);
          if (str.compareTo(strTmp) > 0 && i < j) {
            resArr[i][0] = new String(strTmp);
            resArr[j][0] = new String(str);
          }
        }
      }
    }
  }
}
