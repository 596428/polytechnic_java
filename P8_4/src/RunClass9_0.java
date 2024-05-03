import java.util.Scanner;
import java.util.Stack;

public class RunClass9_0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputNum = sc.nextLine();
		int num = Integer.parseInt(inputNum);
		for(int i=0; i<num; i++) {
			int count = sc.nextInt();
			String ss = sc.nextLine();
			int match = match(ss,count);
			System.out.println(match);
		}
	}
	
	//str 은 무분별한 (와 )로 이루어진 문자열 ex: ))()(()) 혹은 ()((()()))
	//n은 0이상의 정수, n번째의 괄호와 매칭되는 짝이 몇번째인지를 return 하는 함수
	public static int match(String str, int n) {
		Stack<Integer> stack = new Stack<Integer> ();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				stack.push(i);
			}else if(ch==')') {
				int result = stack.size()>0? stack.pop() : 0;
				if(result ==n ) return i;
			}
		}
		return 0;
	}
	
//
//	public static int myMatch(String str, int n) {
//		Stack<Integer> stack = new Stack<Integer> ();
//		
//		for(int i=0; i<str.length(); i++) {
//			char ch = str.charAt(i);
//						
//			if(i==n) {
//				if(ch == '(') {
//					while (!stack.isEmpty()) {
//					    stack.pop();
//					}
//					stack.push(i);
//				}else if(ch==')') {
//					if(!stack.isEmpty()) return 0;
//					else return stack.pop();
//				}
//			}else {
//				if(ch == '(') {
//					stack.push(i);
//				}else if(ch==')' && !stack.isEmpty()) {
//					int result = stack.pop();
//					if(!stack.isEmpty()) return result;
//				}
//			}
//			
//			
//		}
//		return 0;
//	}
	


}
