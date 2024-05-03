import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findGCDAndLCM(14,20)));
		System.out.println(getSumOfDivisors(12));
		
		//문자열 뒤집기
	    String txt01 = "안녕하세요 자바입니다";
	    StringBuilder sb = new StringBuilder(txt01);
	    sb.reverse();
	    String resultTxt = sb.toString();
	    System.out.println(resultTxt);
	    
	    placeQueen(8,5,5);
	    int[] arr = {0,2,1,3,2,0,4,4};
		int num = 0;
		solution03(arr,num);
	}
	
	public static int solution03(int[]arr,int num) {
		int count = 0;
		Arrays.sort(arr);
		if(arr[0]!=num) count++;
		for (int i=0; i<arr.length-1; i++) {
			count += (arr[i] != arr[i+1] && arr[i+1] != num) ? 1 : 0;
		}
		System.out.println(count);
		return count;
	}
	
	public static int[] findGCDAndLCM(int n, int m) {
        int[] answer = new int[2];
        int r = 0;
        int big = Math.max(n, m);;
        int small = Math.min(n, m);
        while(small!=0){
            r = big%small;
            big=small;
            small=r;
        }
        answer[0]=big; // 최대공약수
        answer[1]=(n*m)/big; // 최소공배수
        return answer;
    }
	
	public static int getSumOfDivisors(int n) {
        int answer = 0;
        for(int i=0; i<=(n/2); i++){
            //answer = (i != 0 && n % i == 0) ? answer + i : answer;
            if(i != 0 && n % i == 0) {
            	answer +=i;
            }
        }
        return answer + n;
    }
	
	public static void placeQueen(int size, int x, int y) {
	       int[][] arr = new int[size][size];
	       for(int i=0; i<size; i++) {
	          for(int j=0; j<size; j++) {
	             if(i==x || j==y || i+j==x+y || i-j==x-y) {
	                arr[i][j] = 1;
	             }
	             //else arr[i][j] = " ";
	             System.out.print(arr[i][j] + " ");
	          }System.out.println();
	       }
	}
	

	
}
