import java.util.Scanner;

public class ThisIsNotAGame {
	private GameState gameState;
	private static final int maxFloor = 2;
	private static final int playerCount = 1;
	Scanner scanner = new Scanner(System.in);	
	
	public void runGame() {
		System.out.println("0416 과제 : This is definitely not A SLS");
		for (int i=0; i<999; i++) {
			if(i==0) {	
				System.out.println("시작하시려면 s, 종료하시려면 q를 눌러주세요.");	
			}else {
				System.out.println("새로운 게임을 시작하시려면 s를 눌러주세요.\n종료하시려면 q를 눌러주세요.");
			}
			String button = scanner.nextLine();
			
			if (button.equals("s")) {
				System.out.println((i+1)+ "번째 게임을 시작합니다.");
				createNewGame();
			}else if(button.equals("q")) {
				break;
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

    public void createNewGame() {
        this.gameState = new GameState();
        // initializeGame 메서드로 floor와 player 객체를 생성함
        this.gameState.initializeGame(maxFloor, playerCount);
        // climbingFloors 안쪽에서 게임 루프 실행
        this.gameState.climbingFloors();


        //패배조건 : 모든 플레이어가 사망했다면
        if (gameState.isGameOver()) {
        	System.out.println("Game Over!\\n");
        } else {
        	System.out.println("정상에 도착했습니다.");
        	System.out.println("Victory!\n");
        }
    }



}
