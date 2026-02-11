public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	    this.numerator = numerator;
      this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
	    this.numerator = numerator;
      this.denominator = denominator;
      reduce();
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
      int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
      int newDenomenator  = this.denominator * other.denominator;
      return new Rational(newNumerator, newDenomenator);
    }

    public static Rational plus(Rational a, Rational b) {
    	return a.plus(b);
    }

    // Transforms this number into its reduced form

    private void reduce() {
      // Your code here
      if( numerator == 0){
        denominator = 1;
      }

      int theGCD = gcd(numerator, denominator);
      numerator = numerator/theGCD;
      denominator = denominator/theGCD;
      
      if(numerator < 0 && denominator < 0){
        numerator *= -1;
        denominator *= -1;
      }
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
      if (a < 0){
        a *= -1;
      }
      if (b < 0){
        b *= -1;
      }

    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }

    public int compareTo(Rational other) {
      
      int num1 = this.numerator*other.denominator; //Match denomenators for both fractions  
	    int num2= other.numerator*this.denominator;
	    if(num1 < num2){
		    return -1;
	    }
	    else if(num1 == num2){
		    return 0;
	    }
	    else{
		    return 1;
	    }
    }

    public boolean equals(Rational other) {

      return (this.denominator == other.denominator && this.numerator == other.numerator);
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    result = String.valueOf(numerator);
    	} else {
    	    result =  numerator + "/" + denominator;
    	}
    	return result;
    }

    public static void main(String[] args) {
      Rational x = new Rational(1,2);
      Rational y = new Rational(1,4);
      Rational z = x.plus(y);

      System.out.println(z.getNumerator());
      System.out.println(z.getDenominator());
      
    }

}
