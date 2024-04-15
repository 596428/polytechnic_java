import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {
	private List<Floor> floors;
	private List<Base> players;
	Scanner s =  new Scanner(System.in);

	
	
	// 정해진 만큼의 floor 객체, player 객체 생성
    public void initializeGame(int maxFloor) {
    	createFloor(maxFloor);
    	createPlayer();
        climbingFloors();
    }
    
    
    public List<Floor> createFloor(int maxFloor){
    	this.floors = new ArrayList<>();
		for(int i=0; i< maxFloor; i++) {
			this.floors.add(new Floor("floor" + (i+1)));
		}
		return floors;
    }
    
    public List<Base> createPlayer(){
    	this.players = new ArrayList<>();
    	//작성자 : 김지수
    	Base minji = new Minji(this);
        Base hanni = new Hanni(this);
        Base haerin = new Haerin(this);
        players.add(minji);
        players.add(hanni);
        players.add(haerin);
        //작성자 : 권동운
        Base player01 = new Quokka(this, 0);
		this.players.add(player01);
        //작성자 : 백지욱
		Base player02 = new Player(this, 0);
		this.players.add(player02);
		return players;
    }
    
    public void climbingFloors() {
    	System.out.println("\n던전으로 들어갑니다...\n");
    	for(Floor floor : floors) {
    		if (!isGameOver()) {
    			System.out.println("-----" + floor.floorName + "-----");
    			floor.runBattle(players, floors.indexOf(floor), floors.size());
    			System.out.println(floor.floorName + " closed\n");
    		}
    	}
    }
      
    
    //player는 GameState에서 생성되기 때문에, player의 삭제 역시 GameState에서 처리함
    public void removePlayer(Base player) {
    	players.remove(player);
    }
    

    // 플레이어가 사망할때마다 플레이어 객체도 삭제되기 때문에,
    // players가 비어있다는 것은 곧 모든 플레이어의 사망을 뜻함
    public boolean isGameOver() {
    	return players.isEmpty(); // players 리스트에 더이상 player 객체가 남아있지 않다면 true
    }
    


}
