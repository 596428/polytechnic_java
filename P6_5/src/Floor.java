import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Floor {
	String floorName;
	int currentfloor;
	private List<Enemy> enemies;
	Scanner s =  new Scanner(System.in);
	
	Floor(String name){
		this.floorName = name;
	}
	  
	// GameState에서 실행되는 메서드, enemy 객체들을 생성하고 engageInBattle 메서드를 실행
	public void runBattle(List<Base> players, int floorIndex, int floorSize) {
		createEnemy(players, floorIndex, floorSize); //적 개체 생성
		System.out.println("전투를 시작합니다.");
		engageInBattle(players, enemies); // 플레이어 혹은 적이 전멸할때까지 while문 실행
	}
	
	
	
	public List<Enemy> createEnemy(List<Base> players, int floorIndex, int floorSize){
		this.enemies = new ArrayList<>();
		this.currentfloor = floorIndex+1;
		if(currentfloor == floorSize) {
			System.out.println("보스 출현");
			Enemy slimeBoss = new SlimeBoss(this);
			//slimeBoss.floor = this;
			this.enemies.add(slimeBoss);
		}else {
			for(int i = 0; i< players.size()+1; i++) {
				this.enemies.add(new Enemy(this, i));
			}
		}
		return enemies;
	}
	
	
	// 플레이어 혹은 몬스터가 전멸할때까지 번갈아가면서 공격을 주고받음
	private void engageInBattle(List<Base> players, List<Enemy> enemies) {
		int cnt = 0;
		int damage = 0;
		//플레이어 혹은 적의 리스트가 모두 사라질때까지 while문
		while(!(players.isEmpty() ||enemies.isEmpty())) {
			System.out.println("-----" + (cnt+1) + "턴 시작-----");
			// enemy 객체들의 리스트 출력하는 for문
			for (Enemy enemy : enemies) {
	    		System.out.println(enemies.indexOf(enemy) + ". " + enemy.name + " hp: " + enemy.hp);
	        }System.out.println("\n");
			
			//작성자 : 김지수
			for (Base player : players) {
                if (!enemies.isEmpty()) {
                    damage = 0;
                    Enemy targetEnemy = chooseEnemy(enemies);

                    if (player instanceof Minji) {
                        damage = ((Minji) player).attack();
                        targetEnemy.underAttack(damage);
                        System.out.println(player.name + "가 " + targetEnemy.name + "에게 " + damage + "데미지를 주었습니다.");
                        System.out.println(targetEnemy.name + "의 남은 hp: " + targetEnemy.hp);
                    } else if (player instanceof Hanni) {
                    	damage = ((Hanni) player).attack();
                    	targetEnemy.underAttack(damage);
                    	System.out.println(player.name + "가 " + targetEnemy.name + "에게 " + damage + "데미지를 주었습니다.");
                    	System.out.println(targetEnemy.name + "의 남은 hp: " + targetEnemy.hp);                    	
                    } else if (player instanceof Haerin) {
	                	damage = ((Haerin) player).attack();
	                	targetEnemy.underAttack(damage);
	                	System.out.println(player.name + "이 " + targetEnemy.name + "에게 " + damage + "데미지를 주었습니다.");
	                	System.out.println(targetEnemy.name + "의 남은 hp: " + targetEnemy.hp);                    	
	                }
                }
            }
			
			//작성자:권동운
			for(Base player : players ) {
				if(!enemies.isEmpty()){
					Base targetEnemy = chooseTargetEnemy(enemies);
					if(player instanceof Quokka) {
						damage = ((Quokka)player).attack();
					}
					System.out.println(player.name + "가" + targetEnemy.name + "에게" + damage + "데미지를 주었습니다." );
					System.out.println(targetEnemy.name + "의 hp" + (targetEnemy.hp - damage));
					targetEnemy.underAttack(damage);
				}
			}
			
			//작성자 : 백지욱
			for(Base player : players ) {
				if(!enemies.isEmpty()){
					Base targetEnemy = chooseTargetEnemy(enemies);
					if(player instanceof Player) {
						damage = ((Player)player).attack();
					}
					System.out.println(player.name + "가" + targetEnemy.name + "에게" + damage + "데미지를 주었습니다." );
					System.out.println(targetEnemy.name + "의 hp" + (targetEnemy.hp - damage));
					targetEnemy.underAttack(damage);
				}
			}
			
			// 모든 enemy 객체들이 각자 1번씩 플레이어를 공격하는 메서드
			startEnemyTurn(players, enemies);
			cnt++;
		}

	}
	
	//작성자 : 김지수
	private Enemy chooseEnemy(List<Enemy> enemies) {
        Enemy targetEnemy = enemies.get(0);
        for (Enemy enemy : enemies) {
            if (enemy.hp < targetEnemy.hp) {
                targetEnemy = enemy;
            } else if (enemy.hp == targetEnemy.hp && enemies.indexOf(enemy) < enemies.indexOf(targetEnemy)) {
                targetEnemy = enemy;
            }
        }
        return targetEnemy;
    }
	
	//작성자 : 권동운
	private Base chooseTargetEnemy(List<Enemy> enemies) {
		// TODO Auto-generated method stub
		Base targetEnemy = enemies.get(0);
		for(Enemy enemy : enemies) {
			if(enemy.hp <targetEnemy.hp ) {
				targetEnemy = enemy;
			} else if (enemy.hp == targetEnemy.hp && enemies.indexOf(enemy) > enemies.indexOf(targetEnemy)) {
				targetEnemy = enemy;
			}
		}
		return targetEnemy;
	}
	
	public void startEnemyTurn(List<Base> players, List<Enemy> enemies) {
		for(Enemy enemy : enemies) {
			if(!players.isEmpty()) {
				Base targetPlayer = chooseTargetPlayer(players);
				int damage = enemy.attack();
				System.out.println(enemy.name + "가 " + targetPlayer.name + "에게" + damage +"데미지를 주었습니다.");
				System.out.println(targetPlayer.name + "의 hp " + (targetPlayer.hp-damage));
				targetPlayer.underAttack(damage);
			}
		}
	}
	
	
	// enemies는 다음과 같은 조건에 따라 목표 플레이어를 결정함
	// 1. 현재 hp가 가장 낮은 플레이어 우선 2. hp가 동일하다면, 인덱스 번호가 높은 순서를 우선
	private Base chooseTargetPlayer(List<Base> players) {
		Base targetPlayer = players.get(0);
        for (Base player : players) {
            if (player.hp < targetPlayer.hp) {
                targetPlayer = player;
            } else if (player.hp == targetPlayer.hp && players.indexOf(player) > players.indexOf(targetPlayer)) {
                targetPlayer = player;
            }
        }
        return targetPlayer;
    }
	

	public void addEnemy(Enemy enemy) {
    	enemies.add(enemy);
    }
	public void removeEnemy(Enemy enemy) {
    	enemies.remove(enemy);
    }

}
