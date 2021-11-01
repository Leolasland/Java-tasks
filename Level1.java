import java.util.*;

public class Level1 {
  public static int squirrel(int N) {
    long F = 1;

    for (int i = 2; i <= N; i++)
      F *= i;
    while (F >= 10)
      F /= 10;
    return (int)F;
  }
}