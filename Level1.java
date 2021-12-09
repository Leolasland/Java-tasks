public class Level1 {
  static int MaximumDiscount(int N, int [] price) {
    int discount = 0;
    sorting(N, price);
    for (int i = 0; i < N; i++) {
      if ((i + 1) % 3 == 0) {
        discount += price[i];
      }
    }
    return discount;
  }

  static void sorting(int n, int [] arr) {
    boolean xchange = true;
    int tmp;
    while (xchange) {
      xchange = false;
      for (int i = 0; i < n - 1; i++) {
        if (arr[i] < arr[i + 1]) {
          tmp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tmp;
          xchange = true;
        }
      }
    }
  }
}
