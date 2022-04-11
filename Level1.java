import java.util.*;

public class Level1 {

    public static boolean white_walkers(String village) {
        if (village.isEmpty()) {
            return false;
        }
        char [] tmp = village.toCharArray();
        List<Boolean> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < village.length(); i++) {
            if (Character.isDigit(tmp[i]) && searchEquals(tmp, i)) {
                checkSum(tmp, i, tmp[i] - 48, result);
            }
        }
        if (result.isEmpty()) {
            return false;
        }
        for (Boolean aBoolean : result) {
            if (Boolean.TRUE.equals(aBoolean)) {
                count++;
            }
        }
        return count == result.size();
    }

    static boolean searchEquals(char [] tmp, int point) {
        for (int i = point + 1; i < tmp.length; i++) {
            if (Character.isDigit(tmp[i])) {
                for (int j = point + 1; j < i; j++) {
                    if (tmp[j] == '=') {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    static void checkSum(char [] tmp, int point, int sum, List<Boolean> result) {
        int count = 0;
        for (int i = point + 1; i < tmp.length; i++) {
            if (Character.isDigit(tmp[i])) {
                sum += (tmp[i] - 48);
                if (sum == 10) {
                    result.add(checkEquals(tmp, point + 1, i, count));
                }
            }
        }
    }

    static boolean checkEquals(char [] tmp, int point, int pointSum, int count) {
        for (; point < pointSum; point++) {
            if (tmp[point] == '=') {
                count++;
            }
        }
        return count == 3;
    }
}
