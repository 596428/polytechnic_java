import java.util.Scanner;

public class RunClass {
	public static void main(String[] args) {
		
		MarketState newMarket01 = new MarketState();
		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<999999; i++) {
			if(i==0) {
				System.out.println("0423 JAVA 중간고사_안지환");
				System.out.println("1.상품등록 2.상품목록 출력 3. 상품통계 출력\n 4.상품 판매내역 확인 5. 재고관리 q.종료");	
			}else {
				System.out.println("추가로 작성하시려면 번호를 입력해 주세요.\n1.상품등록 2.상품목록 출력 3. 상품통계 출력 4.상품 판매내역 확인 5. 재고관리 q.종료");
			}
			String button = scanner.nextLine();
						
			if(button.equals("1")) {
				//상품 추가
				newMarket01.inputProduct();
			}else if(button.equals("2")) {
				//상품목록출력
				//정렬기준 입력받고 거기에 따라서
				newMarket01.printProducts();
			}else if(button.equals("3")) {
				//등록된 상품의 갯수, 평균 가격을 출력
				newMarket01.calcAvgPrice();
			}else if(button.equals("4")) {
				//판매내역 관리
				newMarket01.updateBuylist();
			}else if(button.equals("5")) {
				//상품명을 입력받아 재고를 수정
				newMarket01.updateStock();
			}else if(button.equals("q")) {
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
}