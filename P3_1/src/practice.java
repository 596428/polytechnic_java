import java.util.Arrays;
import java.util.Random;

public class practice {
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int length=300;
		int arr01[] = new int[length];
		for (int i=0; i < arr01.length; i++){
			//arr01[i]= random.nextInt(100);
			arr01[i] = length-i;
		}
		
		
		int arr02[] = {0,0,0,0,0,0,0};
		int arr03[] = {1,3,5};
		int arr04[] = {2,4,6,8};
		
		Arrays.sort(arr01);
		System.out.println(Arrays.toString(arr01));
		//myMergeSort(arr01);
		insertionSort(arr01, 0, arr01.length-1);
		System.out.println(Arrays.toString(arr01)); // 출력
		
		myMerge(arr02,arr03,arr04);
		//System.out.println(Arrays.toString(arr02));
		//System.out.println(7/2);
	}
	
	
	
	
	public static void myMergeSort(int[]arr) {
		if (arr.length<=8){
			insertionSort(arr, 0, arr.length-1);			
		}else {
			int medianIdx = arr.length / 2;
			int[] leftArr = new int[medianIdx];
			int[] rightArr = new int[arr.length - medianIdx];
			
			for (int i=0; i<arr.length; i++) {
				if(i<medianIdx) {
					leftArr[i] = arr[i];
				}else{
					rightArr[i-medianIdx] = arr[i];
				}
			}
			myMergeSort(leftArr);
			myMergeSort(rightArr);
			
			myMerge(arr, leftArr,rightArr);
		}
	}
	
	
	public static void myMerge(int[]arr,int[]left, int[]right) {
		int i=0, j=0, k=0;
		for (i = 0; i < left.length && j < right.length;) {
			if (left[i]<right[j]) {
				arr[k++] = left[i++];
			}else {
				arr[k++] = right[j++];
			}
		}
		for (;i<left.length; i++) {
			arr[k++] = left[i];
		}
		for (;j<right.length; j++) {
			arr[k++] = right[j];
		}
	}
		
	public static void insertionSort(int[]arr, int low, int high) {
		for(int i=low+1; i<=high; i++) {
			int index = i; 
			int value = arr[i]; // i번째의 값을 최종적으로 위치할 곳을 결정하기 전까지 보관
			for(int j = i-1; j>=low && arr[j]>value; j--) { // j가 low와 같거나 더클때까지, arr[j]가 arr[i]의 보관된 값보다 크다면
				arr[j+1] = arr[j];
				index--;//
			}arr[index] = value;
		}
	}

}
	
	
	
	/*
	public static void myDualPivotQuickSort(int[]arr, int low, int high) { // 재귀로 돌아가기 때문에 매번 arr[0]과 arr[arr.length]를 계산하는 것보다 인자로 받는 형식을 사용
		if (low < high) {
			int leftPivot = partitionLow(arr, low, high); // partitionLow는 arr[0]를 pivot으로 시작해서 index++ 
			int rightPivot = partitionHigh(arr, low, high); // partirionHight는 arr[arr.length-1]을 pivot으로 index--
			myDualPivotQuickSort(arr, low, leftPivot-1);
			myDualPivotQuickSort(arr, leftPivot, rightPivot-1);
			myDualPivotQuickSort(arr, rightPivot+1, high);
		}
	}

	public static int partitionLow(int[]arr, int low, int high) {
		 int pivot = arr[low]; 
		 int pivotIndex = high;
		 
		 for (int i=high; i>low; i--) {
			 if (arr[i]> pivot) {
				 swap(arr,i, pivotIndex);
				 pivotIndex--;
			 }
		 }swap(arr, low, pivotIndex);
		 return pivotIndex;
	}
	
	public static int partitionHigh(int[]arr, int low, int high) {
		 int pivot = arr[high]; 
		 int pivotIndex = low;
		 for (int i=low; i<high; i++) {
			 if (arr[i]< pivot) {
				 swap(arr,pivotIndex, i); // if조건으로 걸러낸 '피벗보다 작은 값'들을 피벗 왼쪽으로 이동시킴
				 pivotIndex++;
			 }
		 }swap(arr, pivotIndex, high); // 최종적으로 피벗을 피벗인덱스에 위치시킴
		 return pivotIndex;
	}	
	
	public static void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}		




public static void insertionSort(int[]arr, int low, int high) {
	for(int i=low+1; i<=high; i++) {
		int key = arr[i]; // i번째의 값을 최종적으로 위치할 곳을 결정하기 전까지 보관
		int j;
		for(j = i-1; j>=low && arr[j]>key; j--) { // j가 low와 같거나 더클때까지, arr[j]가 arr[i]의 보관된 값보다 크다면
			arr[j+1] = arr[j]; //
		}arr[j+1] = key;
	}
}
*/