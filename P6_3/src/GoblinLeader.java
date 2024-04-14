import java.util.List;

public class GoblinLeader extends Boss {
	private Floor floor;
	int damageCount = 0;
	int goblinCount = 10;
	
	public GoblinLeader(Floor floor) {
		this.floor = floor;
		this.name = "고블린 리더";
		this.hp = 250;
		this.maxHp = hp;
	}
	
	@Override
	public int attack() {
		while(damageCount>=2) {
			System.out.println("고블린 소환");
			Enemy enemy = new Enemy(this.floor, goblinCount);
			enemy.name = "부하 고블린"+ (11-goblinCount);
			enemy.hp = this.hp;
			enemy.floor = this.floor;
			this.floor.addEnemy(enemy);
			damageCount -=2;
			goblinCount -=1;
		}
		return (20 - goblinCount);
	};
	
	@Override
	public void underAttack(int damage) {
	    super.underAttack(damage);
	    damageCount++;
	}

}
