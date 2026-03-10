public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
    }

    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
       this.denominator = denominator;
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
      int num = (this.numerator)*(other.denominator) + other.numerator*(this.denominator);
      int den = (this.denominator)*(other.denominator);
      return new Rational(num, den);
    }

    public static Rational plus(Rational a, Rational b) {
      int num = (a.numerator)*(b.denominator) + b.numerator*(a.denominator);
      int den = (a.denominator)*(b.denominator);
      return new Rational(num, den);
    }

    // Transforms this number into its reduced form

    private void reduce() {
      int gcd = gcd(this.numerator,this.denominator);
      this.numerator /= gcd;
      this.denominator /= gcd;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.

    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
      return 0;
    }

    public boolean equals(Rational other) {
      return false;
    }

    public String toString() {
    	String result = "";
    	if (denominator == 1) {
    	    result = this.numerator + "";
    	} else {
    	    result = this.numerator + "/" + this.denominator;
    	}
    	return result;
    }

}