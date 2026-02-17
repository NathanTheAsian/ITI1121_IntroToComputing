public class Q3_ArrayInsertionDemo{

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
        int[] newArray = new int[beforeArray.length + 1];
        for (int i = 0; i < indexToInsert; i++) {
            newArray[i] = beforeArray[i];
        }
        newArray[indexToInsert] = valueToInsert;
        for (int i = indexToInsert; i < beforeArray.length; i++) {
            newArray[i + 1] = beforeArray[i];
        }
        return newArray;
    }

	public static void main(String[] args){
        int[] arr = {1, 5, 4, 7, 9, 6};
        int[] newArray = insertIntoArray(arr, 3, 15);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
	}
}