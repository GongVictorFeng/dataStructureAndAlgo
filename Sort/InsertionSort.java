public class InsertionSort{
	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int temp = arr[i], j = i;
			while(j > 0 && arr[j - 1] > temp){
				arr[j] = arr[j - 1];
				j--; 
			}
			arr[j] = temp;
		}
	}
	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {10, 3, 2, 5, 8, 4, 1, 9};
		insertionSort(arr);
		printArray(arr);
	}
}