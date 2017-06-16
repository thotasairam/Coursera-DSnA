import java.util.*;

public class GCD {

  //Method for finding gcd using Euclidean algorithm.
  private static long euclid_gcd(long a, long b) {

    if(b == 0){
      return a;
    }
    else {
      long ap = a % b;
      return euclid_gcd(b, ap);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    if(a>b) {
      System.out.println(euclid_gcd(b, a));
    }
    else {
      System.out.println(euclid_gcd(a,b));
    }
  }
}
