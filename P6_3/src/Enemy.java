
public class Enemy extends Base {
	protected Floor floor;
	int maxHp;
	
	public Enemy() {
	}
	
	public Enemy(Floor floor, int i) {
		this.floor = floor;
		this.name = "monster" + Integer.toString(i+1);
	}
	
	public int attack() {
		return 1;
	};
	
	@Override
	public void underAttack(int damage) {
		 this.hp -= damage;
	     if (!super.isLive()) {
	        floor.removeEnemy(this);
	        System.out.println(this.name + "이 사망했습니다.");
	     }
		
	}
	public int getHp() {
        return hp;
    }
}
