public class SelectionSort{

	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			int minIndex = i;

			for(int j = i + 1; j < arr.length; j++){
				if( arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}

			if(minIndex != i){
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
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
		selectionSort(arr);
		printArray(arr);
	}
}