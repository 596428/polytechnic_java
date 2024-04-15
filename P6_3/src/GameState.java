import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {
	private List<Floor> floors;
	private List<Player> players;
	Scanner s =  new Scanner(System.in);

	
	
	// 정해진 만큼의 floor 객체, player 객체 생성
    public void initializeGame(int maxFloor, int playerCount) {
    	this.floors = new ArrayList<>();
		for(int i=0; i< maxFloor; i++) {
			this.floors.add(new Floor("Floor"+ (i+1)));
		}
    	this.players = new ArrayList<>();
		for (int i = 0; i< playerCount; i++) {
			System.out.println((i+1) + "번 캐릭터를 생성합니다.");
            Role role = checkPlayerRole(); // 직업 선택하는 메서드
            System.out.println("캐릭터의 이름을 입력하세요.");
            String inputTxt = s.nextLine();
            Player player = new Player(this, inputTxt, role);
            this.players.add(player);
        }
		climbingFloors();
    }
    


    
    // 이용자가 플레이어의 직업을 입력하는 메서드
    private Role checkPlayerRole() {
    	System.out.println("직업을 선택하세요.");
    	for (int i = 0; i < Role.values().length; i++) {
    		System.out.println((i) + ". " + Role.values()[i]);
        }
    	int inputRoleNum = Role.values().length+1;
    	String inputTxt = "";
    	while (inputRoleNum >= Role.values().length) {
            System.out.println("원하시는 직업의 번호를 입력하세요.: ");
            try {
            	inputTxt = s.nextLine();
                inputRoleNum = Math.abs(Integer.parseInt(inputTxt));
                if (inputRoleNum >= Role.values().length) {
                    System.out.println("error");
                }
            } catch (NumberFormatException e) {
                System.out.println("error");
            }
        }
    	return Role.values()[inputRoleNum];
    }
    
 // 게임 루프 시작
    public void climbingFloors() {
    	System.out.println("\n던전으로 들어갑니다...\n");
    	for(Floor floor : floors) {
    		if (!isGameOver()) {
    			System.out.println("-----" + floor.floorName + "-----");
    			floor.runBattle(players, floors.indexOf(floor), floors.size());
    			System.out.println(floor.floorName + " clear\n");
    		}
    	}
    }
    
    
    //player는 GameState에서 생성되기 때문에, player의 삭제 역시 GameState에서 처리함
    public void removePlayer(Player player) {
    	players.remove(player);
    }
    

    // 플레이어가 사망할때마다 플레이어 객체도 삭제되기 때문에,
    // players가 비어있다는 것은 곧 모든 플레이어의 사망을 뜻함
    public boolean isGameOver() {
    	return players.isEmpty(); // players 리스트에 더이상 player 객체가 남아있지 않다면 true
    }
    


}
