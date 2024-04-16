
public class Boss extends Enemy {
	@Override
	public void underAttack(int damage) {
		int checkDmg = (int) Math.round((double)maxHp*0.5);
		int dice = (int) (Math.random() * 6);
		if(damage>checkDmg+dice) {
			System.out.println("Warning : Invalid attack");
			damage = 0;
			System.out.println(name + "의 hp가 " + hp + "으로 돌아간다...");
		}
		super.underAttack(damage);


	}
	

}
