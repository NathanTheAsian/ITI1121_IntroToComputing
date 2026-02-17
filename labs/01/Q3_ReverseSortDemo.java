public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
        char reversed [] = new char[values.length];
        int len = values.length-1;
        for (int i=0;i < values.length;i++) {
            reversed[i] = values[len-i];
            System.out.println(reversed[i]);
        }
		
	}

}