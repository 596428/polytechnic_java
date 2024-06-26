
public class SlimeBoss extends Boss{
	public Floor floor;
	
	public SlimeBoss(Floor floor) {
		this.name = "대왕 슬라임";
		this.hp = 300;
		this.maxHp = hp;
		this.floor = floor;
	}
	@Override
	public void underAttack(int damage) {
	    super.underAttack(damage);
	    binaryFission();
	}
	
	public void binaryFission() {
		if(hp>0 && hp < maxHp/2) {
	    	 for (int i = 0; i < 2; i++) {
	    		 Enemy slimeBoss = new SlimeBoss(this.floor);
	    		 slimeBoss.name = "분열된 슬라임";
	    		 slimeBoss.hp = this.hp;
	    		 slimeBoss.maxHp = 100;
	    		 slimeBoss.floor = this.floor; // 이게 왜필요한거임?
	    		 this.floor.addEnemy(slimeBoss);
	    		 this.floor.removeEnemy(this); 
	    	 }
	    }
	}
	
	
}
