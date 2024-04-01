import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RunClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

	
		int length = 30;
		int arr01[] = new int[length];
		for (int i=0; i < arr01.length; i++){
			arr01[i]= random.nextInt(100)+1; 
		}
		int[][] arr02 = new int[2][3];
		
		MyMergeSort a1 = new MyMergeSort();
		Create2DArray a2 = new Create2DArray();
		
		
		for (int n=0; n<999999; n++) {
			if(n==0) {	
				System.out.println("HW0319_안지환\n시작하시려면 HW 번호, 종료하시려면 q를 눌러주세요.\n1.배열 정렬 2.이차원배열 출력");	
			}else {
				System.out.println("다른 HW를 확인하시려면 번호를 입력해 주세요.\n1.배열 정렬 2.이차원배열 출력\n종료하시려면 q를 눌러주세요.");
			}
			String button = scanner.nextLine();
			
			
			if(button.equals("1")) { 
				System.out.println("수정 전 배열\n" + Arrays.toString(arr01));
				a1.myMergeSort(arr01);
				System.out.println("수정 후 배열\n" + Arrays.toString(arr01));
				
			}else if(button.equals("2")) {
				a2.inputArrayValue(arr02); 
				a2.printArray(arr02);
				
			}else if(button.equals("q")) {
				break;
				
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
