
public class GoblinLeader extends Boss {
	public Floor floor;
	int damageCount = 0;
	int goblinCount = 10;
	
	public GoblinLeader(Floor floor) {
		this.floor = floor;
		this.name = "고블린 리더";
		this.hp = 250;
	}
	
	@Override
	public int attack() {
		summonGoblin();
		int resultDmg = calcDmg();
		return (resultDmg);
	}
	
	@Override
	public void underAttack(int damage) {
	    super.underAttack(damage);
	    damageCount++;
	}
	
	public void summonGoblin() {
		while(damageCount>=2) {
			System.out.println("고블린 소환");
			Enemy enemy = new Enemy(this.floor, goblinCount);
			enemy.name = "부하 고블린"+ (11-goblinCount);
			enemy.hp = 30;
			this.floor.addEnemy(enemy);
			damageCount -=2;
			goblinCount -=1;
		}
	}
	
	public int calcDmg() {
		int dice = (int) (Math.random() * 6);
		return (40 + dice*2 - (goblinCount*3));
	}
}
