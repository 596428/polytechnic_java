import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RunClass {
	public static void main(String[] args) {
				
		//주사위 생성
		List<Dice> dices = new ArrayList<>();
		// List<Type> list = new ArrayList<>(/*초기 용량*/);
		for (int i = 0; i < 10; i++) {
		    dices.add(new Dice("dice" + i));
		}
		
		
		
		
		
		// 익명 클래스를 통해 처리하는 방법
		Collections.sort(dices, new Comparator<Dice>() {
		    @Override
		    public int compare(Dice d1, Dice d2) {
		        //return d1.getName().compareTo(d2.getName()); 문자열 비교할때랑 숫자열 비교할때 양식이 다름
		        return Integer.compare(d1.getValue(), d2.getValue());
		    }
		});
		
		// 바깥으로 클래스 빼내서 사용하는 방법
		DiceComparator comparator = new DiceComparator();
		Collections.sort(dices, comparator);
		
		
		Comparator<Dice> nameComparator = Comparator.comparing(Dice::getValue,Comparator.reverseOrder());
		dices.sort(nameComparator);
////		//Collections.sort(dices); 이건왜안됨?
		
		
		//dices.sort(Comparator.comparing(Dice::getValue));
		dices.sort(Comparator.comparing(Dice -> Dice.getProperty("diceNumber"),Comparator.reverseOrder()));
		//::getProperty("문자열") 사용할수없는이유
		//Comparator.comparing() 메서드 내에서 Dice::getProperty("diceNumber")를 사용하여 속성 값을 가져오려고 하기 때문입니다.
		//그러나 Comparator.comparing() 메서드는 메서드 참조(Method Reference) 또는 람다식을 기대하므로, 메서드 호출을 직접 사용할 수 없습니다.
		
		

		
		for (Dice dice : dices) {
			if (dice.getProperty("diceNumber")%2 ==dice.getProperty("diceNumber")%2) {
				System.out.println(dice.getValue()+"  "+dice.getName());
				//System.out.println(dice.getProperty("diceNumber"));
				//System.out.println(dice.getName()+ dice.getProperty("price"));				
			}
		}
	}
}
	
	
	
//	 public static int solution(int n) {
//		 int answer = 0;
//	 
//	        for (int i=0; i<n+1; i++) {
//	        	if(i%2 == 0) {
//	        		answer = answer + i;
//	        	}
//	        }
//	        return answer;
//	    }

	
//	
//	
//	public static void printArr(int [][]arr) {
//		int sum = 0;
//		double avg = 0;
//		System.out.println(" Name    Quiz1   Quiz2   Quiz3   Sum  Avg");
//		for (int i=0; i<40; i++) {
//			System.out.print("-");
//		}System.out.println();
//		System.out.print("student1   ");
//		for (int j=0; j<arr[0].length; j++) {
//			System.out.print(arr[0][j]+ "   ");
//			sum = sum + arr[0][j];
//		}
//		avg = (double) sum / 3;
//		avg = Math.round(avg * 10.0) / 10.0;
//		System.out.print(sum + "    " + avg);
//		System.out.println();
//		
//		System.out.print("student2   ");
//		sum = 0;
//		for (int j=0; j<arr[0].length; j++) {
//			System.out.print(arr[1][j]+ "   ");
//			sum = sum + arr[1][j];
//		}
//		avg = (double) sum / 3;
//		avg = Math.round(avg * 10.0) / 10.0;
//		System.out.print(sum + "    " + avg);
//		System.out.println();
//		
//		for (int i=0; i<40; i++) {
//			System.out.print("-");
//		}System.out.println();
//		System.out.print("tot  ");
//		System.out.print(arr[0][0] + arr[1][0]  + "   ");
//		System.out.print(arr[0][1] + arr[1][1]  + "   ");
//		System.out.print(arr[0][2] + arr[1][2]  + "   ");
//		
//	}
//	
	
	
	
//	public static void printArr(int [][]arr) {
//		int arrPrint[][] = new int [arr.length][6];
//		
//		for(int i=0; i<arr.length; i++) {
//			for (int j=0; j<arr[i].length; j++) {
//				if (j==0) {
//					arrPrint[i][j] = "student"
//				}
//			}
//		} 
//
//	}
	
	
	
	
//	public static void printMeanMedian() {
//		Scanner scanner = new Scanner(System.in);
//		int length = 5;
//		// length를 인자로 받도록 바꾸면 사용자가 원하는 갯수만큼의 합을 구하도록 할수있다
//		int arr[] = new int[length];
//		int sum = 0;
//		for (int i=0; i<length; i++) {
//			System.out.println((i+1)+ "번째 숫자를 입력하세요");
//			arr[i] = scanner.nextInt();
//			sum = sum + arr[i];
//		}
//		int low = 0;
//		for(int i=low+1; i<=length-1; i++) {
//			int key = arr[i];
//			int j;
//			for(j = i-1; j>=low && arr[j]>key; j--) {
//				arr[j+1] = arr[j]; //
//			}arr[j+1] = key;
//		}
//		
//		int avg = sum / length;
//		System.out.println(avg);
//		System.out.println(arr[length/2]);
//		// 배열의 개수가 짝수일때도 작동하도록 하려면 length/2와 (length/2)-1 값의 평균을 출력하도록 if문 붙여줘야함
//	}
	
	
//	public static String solution(int num) {
//	        String answer = "";
//	        if (num%2 !=0) {
//	        	answer = "Odd";
//	        }else{
//	        	answer = "Even";
//	        }
//	        return answer;
//	    }
//	
	
//	 public static int solution(int[] array, int n) {
//	        int answer = 0;
//	        for (int i =0; i< array.length; i++) {
//	        	if(array[i] == n) {
//	        		answer++;
//	        	}
//	        }
//	        return answer;
//	    
//	
	
	
//	 public static int[] solution(int[] num_list) {
//	        int[] answer = {0,0};
//	        int countOdd = 0;
//	        for (int i =0; i<num_list.length; i++) {
//	        	if (num_list[i]%2 !=0) {
//	        		countOdd++;
//	        	}
//	        }
//	        answer[0] = num_list.length - countOdd;
//	        answer[1] = countOdd;
//	        return answer;
//	    }
	
	
	
	



