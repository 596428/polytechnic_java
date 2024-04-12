
public class Player extends Base {
	private GameState gameState;
	String name;
	Role role;
	

	public Player(GameState gameState, String name, Role role) {
		super();
		this.gameState = gameState;
		this.name = name;
		this.role = role;
	}
	
	public int attack() {
		
		return 55;
	}
	
	public int attack() {
		return 55;
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
	        	System.out.println(this.name + "이 사망했습니다.");
	        }
	}
	
	public int getHp() {
        return hp;
    }
	

}
