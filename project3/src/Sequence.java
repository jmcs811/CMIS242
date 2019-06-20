public class Sequence {

  private static int efficiency;

  static int computeIterative(int n) {

    if (n == 0) {
      efficiency = 0;
      return 0;
    }

    if (n == 1) {
      efficiency = 1;
      return n;
    }

    int current = 2;
    int previous = 1;
    for (int i = 2; i < n; i++) {
      int temp = current;
      current = (2*current) + previous;
      previous = temp;
      efficiency += 1;
    }
    efficiency += 2;
    return current;
  }

  public static int computeRecursive(int n) {

    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    return (2*computeRecursive(n-1)) + computeRecursive(n-2);
  }

  public static int getEfficiency() {
    return efficiency;
  }
}
