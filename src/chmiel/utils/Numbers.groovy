package chmiel.utils

class Numbers {
  private Numbers() {}
  
  //Triangle 	  	Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
  static long triangle(long n) {
    n*(n+1)/2
  }
  static boolean isTriangle(long n) {
    isWhole((Math.sqrt(8*n+1)-1)/2)
  }
  //Pentagonal 	  	Pn=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
  static long pentagonal(long n) {
    n*(3*n-1)/2
  }
  static boolean isPentagonal(long n) {
    isWhole((Math.sqrt(24*n+1)+1)/6)
  }
  //Hexagonal 	  	Hn=n(2n−1) 	  	1, 6, 15, 28, 45, ...
  static long hexagonal(long n) {
    n*(2*n-1)
  }
  static boolean isHexagonal(long n) {
    isWhole((Math.sqrt(8*n+1)+1)/4)
  }
  
  
  static boolean isWhole(double n) {
    n == (double)((long)n)
  }
  static boolean isSqare(long n) {
    isWhole(Math.sqrt(n))
  }
}