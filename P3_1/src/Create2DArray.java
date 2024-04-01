import java.util.Scanner;

public class Create2DArray {
		
	public void inputArrayValue(int[][]arr) { 
		//배열 초기화		
		System.out.println("배열을 초기화합니다."); 
		for (int i=0; i<arr.length; i++) {
			 for (int j=0; j<arr[i].length; j++) {
				 arr[i][j] = 0;
			 }
		 }
		//입력
		System.out.println("배열 입력을 시작합니다.");
		Scanner scanner = new Scanner(System.in);
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.println(cnt+1 +"번째 숫자를 입력해 주세요.");
				arr[i][j] = scanner.nextInt();
				cnt++;
			}
		} 

	}
			
	public void printArray(int[][]inputArr) {
		// input받은 배열보다 한사이즈 큰 배열 생성
		int inputRow = inputArr.length;
		int inputCol = inputArr[inputRow-1].length;
		int[][]arr = new int[inputRow+1][inputCol+1];
		
		// 배열에 input값 집어넣기
		for(int i=0; i<inputRow; i++) {
			//System.arraycopy(inputArr[i], 0, arr[i], 0, inputArr[i].length);
			for (int j=0; j<inputCol; j++) {
				arr[i][j] = inputArr[i][j];
			}
		} 
		// 배열의 각행 각열 합 계산하기
		for(int i=0; i<arr.length-1; i++) { // i행은 계속해서 갱신되기 때문에 arr.length-1 까지만 반복
			for (int j=0; j<arr[i].length; j++) { // i행j열의 값은 마지막 행의 j열에 추가시켜야 하기때문에 j는 arr[i].length만큼 반복해야만 함
				if (j !=arr[i].length-1) { // 열의 마지막 값이 한번더 추가되지 않도록 조건 추가
					arr[i][arr[i].length-1] = arr[i][arr[i].length-1] + arr[i][j]; // j번째 열에 값 추가
				}
				arr[arr.length-1][j] = arr[arr.length-1][j] + arr[i][j]; // i번째 행에 값 추가
			}
		}		
		//배열에서 가장 긴 값의 길이 계산
		int length = 0;
		for (int i=0; i<arr.length; i++) {
			 for (int j=0; j<arr[i].length; j++) {
				 int temp = Integer.toString(arr[i][j]).length(); // 배열을 돌면서 각 요소를 string으로 바꾸고 길이를 int로 저장
				 if (temp>length) {
					length = temp; 
				 }
			 }
		}
		//출력
		System.out.println("작성된 배열을 출력합니다.");
		String letterSpacing = "%"+length+"d "; // "%10d"
		for (int[] row : arr) { // 
			for(int num : row) {
				System.out.printf(letterSpacing,num);
			}System.out.println();
		}	
	}
	
	
	/*
	public void calcArrayValue(int[][]arr) {
		for(int i=0; i<arr.length-1; i++) { // i행은 계속해서 갱신되기 때문에 arr.length-1 까지만 반복
			int colSum = 0;
			for (int j=0; j<arr[i].length; j++) {
				colSum = colSum + arr[i][j];
				if (j==arr[i].length-1) { // i행의 마지막 열일때만 여태까지 기록한 colsum을 집어넣음. i++되면서 colsum은 초기화
					arr[i][j] = colSum; 
				}
				arr[arr.length-1][j] = arr[arr.length-1][j] + arr[i][j]; // i행j열의 값은 마지막 행의 j열에 추가시킴
			}
		}
	}*/
	
	
	
	
	/*
	public int calcFormatSpecifier(int[][]arr) { // 배열의 가장 긴 값 찾아서 int로 리턴
		int length = 0;
		for (int i=0; i<arr.length; i++) {
			 for (int j=0; j<arr[i].length; j++) {
				 int temp = Integer.toString(arr[i][j]).length(); // 배열을 돌면서 각 요소를 string으로 바꾸고 길이를 int로 저장
				 if (temp>length) {
					length = temp; 
				 }
			 }
		}return length;
		// 본 예제에서는 arr[i][j]의 길이 한번만 체크하는게 더 효율적이지만, 연습 목적으로 전체 arr를 돌도록 작성함
	}
	
	
	/*
	 * 
	public String[] inputStringToArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열 입력, 값은 ','로 구분됩니다.");
		String input = scanner.nextLine();
		String delimiter = ",";
		String[] inputSplit = input.split(delimiter);
		return inputSplit;
	}
	
	public int[] extractNum(String[]arr) {
		String[] numberArr = new String[arr.length];
		for (int i=0; i< arr.length; i++) {
			numberArr[i] = 
		}
	}
	 */
	
	/*
	public void calcArrayValue(int[][]arr) { // 조건에 맞게 i번째 행과 열의 빈칸을 채워나감
		for(int i=0; i<arr.length; i++) {
			if (i+1 != arr.length) {
				int temp = 0;
				for (int j=0; j<arr[i].length; j++) {					
					temp = temp+ arr[i][j];
					if(j+1==arr.length) {
						arr[i][j] = temp;
					}
				}
			}else if (i+1 == arr.length) {
				for (int j=0; j<arr[i].length; j++) {
					arr[i][j] = sumRowvalue(arr,j); // i행 계산하는 부분 따로 빼내서 작성
				}
			}else {
				return;
			}
		}
	}
	
	public int sumRowvalue(int[][]arr, int j) { // i행 계산하는 메서드
		int sum=0;
		for (int i=0; i<arr.length; i++) {
			sum=sum+arr[i][j];
		}return sum;
	}*/


}
