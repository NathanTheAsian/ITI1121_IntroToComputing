public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int[] numbers = new int[size];
        for (int i = 0;i < numbers.length; i++) {
            numbers[i]= (i*i);
        }
        return numbers;
        
	}

	public static void main(String[] args){
		int[] banana = createArray(13);
		for (int i = 0; i < banana.length; i++) {
		System.out.println(banana[i]);
		}
	}
}