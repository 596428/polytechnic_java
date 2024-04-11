
public class Player extends Base {
	String role;
	private GameState gameState;
	

	public Player(GameState gameState, String name, Role role) {
		super();
		this.gameState = gameState;
		this.name = name;
	}
	
	public int attack() {
		return 55;
	}
	

	@Override
	public void underAttack(int damage) {
		 this.hp -= damage;
	        if (!super.isLive()) { // 죽었으면 false, 살아있다면 True를 반환
	            // 플레이어 사망 처리, player 객체들의 리스트 players에서 자기 자신을 삭제
	        	this.gameState.removePlayer(this);
	        }
	}
	
	public int getHp() {
        return hp;
    }
	

}
