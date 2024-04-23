import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MarketState {
	
	List<BuyList> buyLists = new ArrayList<>();
	List<Product> products = new ArrayList<>();
	
	public void inputProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구매내역 입력을 시작합니다. 상품명, 가격, 재고, 할인율 순으로 입력해 주세요.");
		//상품입력함수 : 상품명 가격 재고 할인율
		System.out.println("상품명:");
		String input1 = scanner.nextLine();
		int input2 = 0;
	    int input3 = 0;
	    double input4 = 0.0;
	    try {
	        System.out.println("가격:");
	        input2 = scanner.nextInt();
	        System.out.println("재고:");
	        input3 = scanner.nextInt();
	        System.out.println("할인율:");
	        input4 = scanner.nextDouble();
	    } catch (InputMismatchException e) {
	        System.out.println("숫자를 입력해주세요.");
	        scanner.nextLine();
	        //e.printStackTrace(); 에러를 [rint 해줌
	        return; 
	    }
		products.add(new Product(input1, input2, input3, input4));
	}
	
	public void printProducts() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정렬기준 입력 : 1.price 오름차순, 2. price 내림차순\n 3. discountRate 오름차순, 4. discountRate 내름차순");
		String button = scanner.nextLine();
		if(button.equals("1")) {
			products.sort(Comparator.comparing(Product -> Product.getPrice()));
		}else if(button.equals("2")) {
			products.sort(Comparator.comparing(Product -> Product.getPrice(),Comparator.reverseOrder()));
		}else if(button.equals("3")) {
			products.sort(Comparator.comparing(Product -> Product.getDiscountRate()));
		}else if(button.equals("4")) {
			products.sort(Comparator.comparing(Product -> Product.getDiscountRate(),Comparator.reverseOrder()));
		}else {
			System.out.println("");
		}
		for (Product product : products) {
			System.out.println(product.getProperty("name") + " " + product.getProperty("price")+ " " + product.getProperty("stock")+ " " + product.getProperty("discountRate"));
		}
	}
	
	public void calcAvgPrice() {
		int length = products.size();
		System.out.println("총 상품 수는" + length +"개 입니다.");
		int sumPrice = 0;
		for (Product product : products) {
			sumPrice += product.getPrice();
		}
		int avgPrice = sumPrice / length;
		System.out.println("평균 가격은" + avgPrice + "입니다.");
	}

	
	public void updateBuylist() {
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<999999; i++) {
			if(i==0) {	
				System.out.println("1.판매내역서 작성 2.판매내역 출력 3. 판매내역 수정 q.종료");	
			}else {
				System.out.println("추가로 작성하시려면 번호를 입력해 주세요.\n1.판매내역서 작성 2.판매내역 출력 3. 판매내역 수정 q.종료");
			}
			String button = scanner.nextLine();
			
			if(button.equals("1")) { 
				System.out.println("판매내역 입력을 시작합니다. 상품명, 구매자이름, 연락처, 주소 순으로 입력해 주세요.");
				//상품목록 출력
				for (Product product : products) {
					System.out.println(product.getProperty("name") + " " + product.getProperty("price")+ " " + product.getProperty("stock")+ " " + product.getProperty("discountRate"));
				}
				//판매내역 추가 : 상품명,구매자이름, 구매자연락처,주소
				System.out.println("상품명:");
				String input1 = scanner.nextLine();
				for (Product product : products) {
					if(input1.equals(product.getProperty("name"))) {
						System.out.println("구매자이름:");
						String input2 = scanner.nextLine();
						System.out.println("연락처:");
						String input3 = scanner.nextLine();
						System.out.println("주소:");
						String input4 = scanner.nextLine();
						if(product.getStock()>0) {
							product.decreaseStock(1);
							buyLists.add(new BuyList(input1, input2, input3, input4));
						}else {
							System.out.println("재고가 부족합니다.");
						}
					}
				}
			}else if(button.equals("2")) {
				for (BuyList buyList : buyLists) {
					System.out.println(buyList.getProperty("productName") + " " + buyList.getProperty("name")+ " " + buyList.getProperty("phoneNum")+ " " + buyList.getProperty("address"));
				}
			}else if(button.equals("3")) {
				System.out.println("구매자의 이름과 수정하실 연락처, 주소를 입력해 주세요.");
				for (BuyList buyList : buyLists) {
					System.out.println(buyList.getProperty("productName") + " " + buyList.getProperty("name")+ " " + buyList.getProperty("phoneNum")+ " " + buyList.getProperty("address"));
				}
				System.out.println("이름:");
				String name = scanner.nextLine();
				System.out.println("연락처:");
				String phoneNum = scanner.nextLine();
				System.out.println("주소:");
				String address = scanner.nextLine();
				for (BuyList buyList : buyLists) {
					if(name.equals(buyList.getProperty("name"))) {
						//연락처와 주소 수정
						buyList.setPhoneNum(phoneNum);
						buyList.setAddress(address);
					}
				}
			}else if(button.equals("q")) {
				break;
				
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	
	public void updateStock() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정하실 상품의 상품명과 재고량을 입력해 주세요.");
		for (Product product : products) {
			System.out.println(product.getProperty("name") + " " + product.getProperty("price")+ " " + product.getProperty("stock")+ " " + product.getProperty("discountRate"));
		}
		System.out.println("상품명:");
		String name = scanner.nextLine();
		System.out.println("재고:");
		int stock = scanner.nextInt();
		for (Product product : products) {
			if(name.equals(product.getProperty("name"))) {
				product.setStock(stock);
			}
		}
	}

}
