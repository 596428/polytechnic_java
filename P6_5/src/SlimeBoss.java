
public class SlimeBoss extends Boss{
	
	public SlimeBoss(Floor floor) {
		this.name = "대왕 슬라임";
		this.hp = 400;
		this.maxHp = hp;
		this.floor = floor;
	}
	
	@Override
	public int attack() {
		int resultDmg = calcDmg();
		return (resultDmg);
	}
	
	@Override
	public void underAttack(int damage) {
	    super.underAttack(damage);
	    binaryFission();
	}
	
	
	public int calcDmg() {
		int dice = (int) (Math.random() * 9);
		int result = 50 + dice;
		return result;
	}
	
	// 분열 메서드
	public void binaryFission() {
		if(hp>0 && hp < maxHp*0.5) {
	    	 for (int i = 0; i < 2; i++) {
	    		 Enemy slimeBoss = new SlimeBoss(this.floor);
	    		 slimeBoss.name = "분열된 슬라임";
	    		 slimeBoss.hp = this.hp;
	    		 slimeBoss.maxHp = 120;
	    		 this.floor.addEnemy(slimeBoss);
	    		 this.floor.removeEnemy(this); 
	    	 }
	    }
	}


}
