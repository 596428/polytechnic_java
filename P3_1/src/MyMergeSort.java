
public class MyMergeSort {
	
	public static void myMergeSort(int[]arr) {
		if (arr.length<128){
			insertionSort(arr, 0, arr.length-1);			
		}else { // 이미 배열 길이가 일정 이하면 insertion sort로 바꿔서 들어가니까 배열 길이>0 을 따로 체크할 필요 없지 않을까...
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
			int key = arr[i]; // i번째의 값을 최종적으로 위치할 곳을 결정하기 전까지 보관
			int j;
			for(j = i-1; j>=low && arr[j]>key; j--) { // j가 low와 같거나 더클때까지, arr[j]가 arr[i]의 보관된 값보다 크다면
				arr[j+1] = arr[j]; //
			}arr[j+1] = key;
		}
	}

}
