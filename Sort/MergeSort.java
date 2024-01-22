public class MergeSort{

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void merge(int[] arr, int left, int middle,int right){
		int[] leftTempArr = new int[middle - left + 2];
		int[] rightTemArr = new int[right - middle + 1];

		for(int i = 0; i < middle - left + 1; i++){
			leftTempArr[i] = arr[left + i];
		}

		for(int i = 0; i < right - middle; i++){
			rightTemArr[i] = arr[middle + i + 1];
		}

		leftTempArr[middle - left + 1] = Integer.MAX_VALUE;
		rightTemArr[right - middle] = Integer.MAX_VALUE;

		int i = 0, j = 0;
		for(int k = left; k < right + 1; k++){
			arr[k] = leftTempArr[i] < rightTemArr[j] ? leftTempArr[i++] : rightTemArr[j++];
		}
	}

	public static void mergeSort(int[] arr, int left, int right){
		if(left < right){
			int middle = (left + right) / 2;
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	public static void main(String[] args) {
		int[] arr = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8, 6};
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
}