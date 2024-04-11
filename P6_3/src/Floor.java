import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Floor {
	String floorName;
	private List<Enemy> enemies;
	Scanner s =  new Scanner(System.in);
	
	Floor(String name){
		this.floorName = name;
	}
	
	public void startBattle(List<Player> players) {
		this.enemies = new ArrayList<>();
		for(int i = 0; i< players.size(); i++) {
			this.enemies.add(new Enemy(this, i));
		}
		engageInBattle(players, enemies);
	}
	
	private void engageInBattle(List<Player> players, List<Enemy> enemies) {
		int cnt = 0;
		int damage = 0;
		//플레이어 혹은 적의 리스트가 모두 사라질때까지 while문
		while(!(players.isEmpty() ||enemies.isEmpty())) {
			System.out.println((cnt+1) + "턴 시작");
			for(Player player : players) {
				Enemy targetEnemy = chooseTargetEnemy(player, enemies);
				damage = player.attack();
				targetEnemy.underAttack(damage);
			}
			for(Enemy enemy : enemies) {
				Player targetPlayer = chooseTargetPlayer(players);
				damage = enemy.attack();
				targetPlayer.underAttack(damage);
			cnt++;
			}
		}

	}
	
	private Enemy chooseTargetEnemy(Player player, List<Enemy> enemies) {
        // enemies를 순회하면서 인덱스와 name를 출력하고, 번호를 입력받아서 리턴함
		System.out.println("공격할 적의 번호를 입력하세요.");
    	for (Enemy enemy : enemies) {
    		System.out.println(enemies.indexOf(enemy) + ". " + enemy.name);
        }
    	int targetEnemyIndex = enemies.size()+1;
    	String inputTxt = "";
    	while (targetEnemyIndex >= enemies.size()) {
            System.out.println("입력을 기다리고 있습니다.");
            try {
            	inputTxt = s.nextLine();
            	targetEnemyIndex = Math.abs(Integer.parseInt(inputTxt));
                if (targetEnemyIndex >= enemies.size()) {
                    System.out.println("error");
                }
            } catch (NumberFormatException e) {
                System.out.println("error");
            }
        }
        return enemies.get(targetEnemyIndex);
    }
	
	private Player chooseTargetPlayer(List<Player> players) {
        Player targetPlayer = players.get(0);
        for (Player player : players) {
            if (player.getHp() < targetPlayer.getHp()) {
                targetPlayer = player;
            } else if (player.getHp() == targetPlayer.getHp() && players.indexOf(player) > players.indexOf(targetPlayer)) {
                targetPlayer = player;
            }
        }
        return targetPlayer;
    }
	
	public void removeEnemy(Enemy enemy) {
    	enemies.remove(enemy);
    }

}
