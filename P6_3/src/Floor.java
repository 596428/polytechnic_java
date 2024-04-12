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
	
	// GameState에서 실행되는 메서드, enemy 객체들을 생성하고 engageInBattle 메서드를 실행
	public void runBattle(List<Player> players) {
		this.enemies = new ArrayList<>();
		for(int i = 0; i< players.size()+1; i++) {
			this.enemies.add(new Enemy(this, i));
		}
		System.out.println("전투를 시작합니다.");
		engageInBattle(players, enemies);
	}
	
	// 플레이어 혹은 몬스터가 전멸할때까지 번갈아가면서 공격을 주고받음
	private void engageInBattle(List<Player> players, List<Enemy> enemies) {
		int cnt = 0;
		int damage = 0;
		//플레이어 혹은 적의 리스트가 모두 사라질때까지 while문
		while(!(players.isEmpty() ||enemies.isEmpty())) {
			System.out.println("-----" + (cnt+1) + "턴 시작-----");
			// 플레이어 인덱스 순서대로, 목표 enemy를 잡고, attack 메서드로 데미지를 계산해서 underAttack으로 넘겨줌
			// underattack에서는 데미지를 계산한 뒤 hp가 0이라면 객체 리스트에서 자기자신을 삭제함
			// 최종적으로 어느 한쪽이 전멸하면 while문을 탈출함
			for(Player player : players) {
				if(!enemies.isEmpty()) {
					Enemy targetEnemy = chooseTargetEnemy(player, enemies);

					damage = player.attack();
					System.out.println(player.name + "가 " + targetEnemy.name + "에게" + damage +"데미지를 주었습니다.");
					System.out.println(targetEnemy.name + "의 hp " + (targetEnemy.getHp()-damage));
					targetEnemy.underAttack(damage);
				}
			}
			// 모든 플레이어가 attack 메서드를 한번씩 실행하고 나면, enemy들이 한번씩 공격함
			for(Enemy enemy : enemies) {
				if(!players.isEmpty()) {
					Player targetPlayer = chooseTargetPlayer(players);
					damage = enemy.attack();
					System.out.println(enemy.name + "가 " + targetPlayer.name + "에게" + damage +"데미지를 주었습니다.");
					System.out.println(targetPlayer.name + "의 hp " + (targetPlayer.getHp()-damage));
					targetPlayer.underAttack(damage);
				}
			}
			cnt++;
		}

	}
	
	// 플레이어가 어떤 적을 선택할지는 이용자가 입력하도록 함
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
	
	// enemies는 다음과 같은 조건에 따라 목표 플레이어를 결정함
	// 1. 현재 hp가 가장 낮은 플레이어 우선 2. hp가 동일하다면, 인덱스 번호가 높은 순서를 우선
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
	
	// enemy는 floor에서 생성되기 때문에, enemy 객체의 삭제 역시 floor에서 처리함
	public void removeEnemy(Enemy enemy) {
    	enemies.remove(enemy);
    }

}
