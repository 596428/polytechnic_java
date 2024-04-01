import java.util.Arrays;

public class MyQuickSort {
	public void myDualPivotQuickSort(int[]arr, int low, int high) {
		if (low < high) {
			int leftPivot = partitionLow(arr, low, high); 
			int rightPivot = partitionHigh(arr, low, high); 
			myDualPivotQuickSort(arr, low, leftPivot-1);
			myDualPivotQuickSort(arr, leftPivot, rightPivot-1);
			myDualPivotQuickSort(arr, rightPivot+1, high);
		}
	}
	
	public int partitionLow(int[]arr, int low, int high) {
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
	
	public int partitionHigh(int[]arr, int low, int high) {
		 int pivot = arr[high]; // 
		 int pivotIndex = low;
		 for (int i=low; i<high; i++) {
			 if (arr[i]< pivot) {
				 swap(arr,pivotIndex, i);
				 pivotIndex++;
			 }
		 }swap(arr, pivotIndex, high);
		 return pivotIndex;
	}	
	
	public void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}		

}
