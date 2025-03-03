import java.util.ArrayList;
import java.util.Collections;

public class BucketSort{

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void printBucket(ArrayList<Integer>[] buckets){
		for(int i = 0; i < buckets.length; i++){
			System.out.println("\nBucket#" + i + ":");
			for(int j = 0; j < buckets[i].size(); j++){
				System.out.print(buckets[i].get(j) + " ");
			}
		}
	}

	public static void bucketSort(int[] arr){
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		for(int value : arr){
			if(value > maxValue){
				maxValue = value;
			}
		}

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		for(int i = 0; i < numberOfBuckets; i++){
			buckets[i] = new ArrayList<Integer>();
		}

		for(int value : arr){
			int bucketNum = (int) Math.ceil(((float) value * numberOfBuckets) / (float)maxValue);
			buckets[bucketNum - 1].add(value);
		}

		System.out.println("\n\nPriting buckets before sorting....");
		printBucket(buckets);

		for(ArrayList<Integer> bucket: buckets){
			Collections.sort(bucket);
		}

		System.out.println("\n\nPriting buckets after sorting....");
		printBucket(buckets);

		int index = 0;
		for(ArrayList<Integer> bucket: buckets){
			for(int value : bucket){
				arr[index] = value;
				index++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {9, 7, 5, 4, 8, 3, 1, 2, 6};
		printArray(arr);
		bucketSort(arr);
		System.out.println();
		printArray(arr);
	}
}