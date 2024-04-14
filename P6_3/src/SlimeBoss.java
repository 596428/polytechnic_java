
public class SlimeBoss extends Boss{
	private Floor floor;
	
	public SlimeBoss(Floor floor) {
		this.floor = floor;
		this.name = "대왕 슬라임";
		this.hp = 250;
		this.maxHp = hp;
	}
	@Override
	public void underAttack(int damage) {
	    super.underAttack(damage);
	    if(hp>0 && hp < maxHp/2) {
	    	 for (int i = 0; i < 2; i++) {
	    		 Enemy slimeBoss = new SlimeBoss(this.floor);
	    		 slimeBoss.name = "분열된 슬라임";
	    		 slimeBoss.hp = this.hp;
	    		 slimeBoss.maxHp = 100;
	    		 slimeBoss.floor = this.floor; // 이거 왜필요한거임???
	    		 this.floor.addEnemy(slimeBoss);
	    		 this.floor.removeEnemy(this); 
	    	 }
	    }
	}
}
