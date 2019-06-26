/////////////////////////////////////////////
// File: Sequence.java
// Author: Justin Casey
// Date: June 25, 2019
// Purpose: This class has two methods
//          to compute the value of the
//          previous number + double the
//          value of the current. It does
//          this iteratively and recursively
//

class Sequence {

  // var for efficiency count
  private static int efficiency = 0;

  // compute the value iteratively
  static int computeIterative(int n) {

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return n;
    }

    int current = 1;
    int previous = 0;
    int result = 0;
    efficiency = 0;

    for (int i = 1; i < n; i++) {
      result = (current * 2) + previous;
      previous = current;
      current = result;
      efficiency++;
    }
    return result;
  }

  // computer the value recursively
  static int computeRecursive(int n) {
    efficiency++;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return ((2*computeRecursive(n-1)) + (computeRecursive(n-2)));
  }

  // efficiency getter
  static int getEfficiency() {
    return efficiency;
  }
}
