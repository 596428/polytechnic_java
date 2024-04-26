import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RunClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//HashSet에서 객체의 동일성 여부를 판단하는 기준: equals()와 hashCode()
		//equals()와 hashCode() 메서드를 override해야 제대로 작동함
		HashSet<MoneyBox> newBank01 = new HashSet<MoneyBox>();
		for(int i=0; i<3; i++) {
			System.out.println("이름:");
			String input1 = scanner.nextLine();
			System.out.println("번호:");
			int input2 = Integer.parseInt(scanner.nextLine());
			newBank01.add(new MoneyBox(input1, input2));
		}
		System.out.println(newBank01.toString());
		
		HashMap<String, MoneyBox> newBank02 = new HashMap<String, MoneyBox>();
		newBank02.put("번호25", new MoneyBox("피카츄", 25));
		System.out.println(newBank02.toString());
		
		scanner.close();
	}

}
