public class BinarySearch{
	public static int binarySearch(int[] arr, int value){
		int start = 0;
		int end = arr.length - 1;
		int middle = (start + end) / 2;

		while (arr[middle] != value && start <= end){
			if (arr[middle] < value){
				start = middle + 1;
			}else{
				end = middle - 1; 
			}
			middle = (start + end) / 2;
			System.out.println(start + " " + middle + " " + end);
		}

		if (arr[middle] == value){
			System.out.println("The element is found at the index: " + middle);
			return middle;
		}

		System.out.println("The element " + value + " not found.");
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {8, 9, 12, 15, 17, 19, 20, 21, 28};
		binarySearch(arr, 15);
	}
}