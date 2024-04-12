
public class Enemy extends Base {
	String name;
	private Floor floor;
	
	public Enemy(Floor floor, int i) {
		super();
		this.floor = floor;
		this.name = "monster" + Integer.toString(i+1);
	}
	
	public int attack() {
		return 1;
	}


	@Override
	public void underAttack(int damage) {
		// TODO Auto-generated method stub
		 this.hp -= damage;
	        if (!super.isLive()) {
	        	this.floor.removeEnemy(this);
	        	System.out.println(this.name + "이 사망했습니다.");
	        }
		
	}
	
	public int getHp() {
        return hp;
    }

}
