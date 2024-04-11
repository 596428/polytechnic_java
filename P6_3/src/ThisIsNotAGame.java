
public class ThisIsNotAGame {
	private GameState gameState;
	private static final int maxFloor = 2;
	private static final int playerCount = 2;
		

    public void startGame() {
        this.gameState = new GameState();
        // initializeGame 메서드로floor와 player 객체를 생성함
        this.gameState.initializeGame(maxFloor, playerCount);
        // climbingFloors 안쪽에서 게임 루프 실행
        this.gameState.climbingFloors();


        //패배조건 : 모든 플레이어가 사망했다면
        if (gameState.isGameOver()) {
        	System.out.println("Game Over!");
        } else {
        	System.out.println("Victory!");
        }
    }



}
