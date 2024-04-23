import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class RunClass6_0 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Purchase> purchases = new ArrayList<>();
		Product product = new Product();
		
		for (int i=0; i<999999; i++) { /// 프로그램이 지맘대로 종료되지 않고 계속해서 반복 실행 되도록, 무한루프 해도됨
			if(i==0) {	
				System.out.println("구매내역 추가는 1, 구매내역 확인은 2, 종료는 q를 눌러주세요.");	
			}else {
				System.out.println("추가로 작성하시려면 번호를 입력해 주세요.\n구매내역 추가는 1, 구매내역 확인은 2\n종료는 q를 눌러주세요.");
			}
			String button = scanner.nextLine();
			
			
			if(button.equals("1")) { 
				System.out.println("구매내역 입력을 시작합니다. 상품번호, 가격, 배송지 순으로 입력해 주세요.");
				product.printProductList();
				String input1 = scanner.nextLine();
				String input2 = scanner.nextLine();
				String input3 = scanner.nextLine();
				purchases.add(new Purchase(input1, input2, input3));
				
				
			}else if(button.equals("2")) {
				for (Purchase purchase : purchases) {
					System.out.println(purchase.getProperty("name") + " " + purchase.getProperty("price") + " " + purchase.getProperty("shippingAddress"));
				}
				
			}else if(button.equals("q")) {
				break;
				
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
		
	}

}
