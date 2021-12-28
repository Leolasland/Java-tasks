import java.util.Arrays;

public class Level1 {
 static String [] ShopOLAP(int N, String [] items) {
        String [] res = new String[N];
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(items[i]);
        }
        Collections.sort(arr);
        for (int i = 0; i < N; i++) {
            res[i] = arr.get(i);
        }
        String [][] resArr = new String[N][N];
        for (int i = 0; i < N; i++) {
            resArr[i] = res[i].split(" ");
        }
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
        res = new String[N];
        for (int i = 0; i < N; i++) {
            if (resArr[i] == null)
                continue;
            res[i] = resArr[i][0] + " " + resArr[i][1];
        }
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(res[i]);
        }
        arr.remove(null);
        res = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
