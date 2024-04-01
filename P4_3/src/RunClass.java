import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RunClass {
	public static int countClassRoom = 3;
	public static int countStudent = 20;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<ClassRoom> classRooms = new ArrayList<>();
		for (int i=0; i<countClassRoom; i++) {
			classRooms.add(new ClassRoom(countStudent, i));
		}
		
		// i반 이외의 다른 텍스트 들어오면 멈추는거 처리하는 단계 필요
		System.out.println("반 이름을 입력해주세요. (ex: 7반)");
		String temp = scanner.nextLine();
		//String temp = "1반"; // 반 이름 : 1반, 2반, 3반...
		for (ClassRoom classRoom : classRooms) {
			if (classRoom.name.equals(temp)) {
				System.out.println("반 이름: " + classRoom.name);
				// 반별 중간기말 총점,평균
				System.out.println("중간 : 총점"+ classRoom.getProperty("classMidSum") + " 평균"+classRoom.getProperty("classMidAvg"));
				System.out.println("기말 : 총점"+ classRoom.getProperty("classFinalSum") + " 평균"+classRoom.getProperty("classFinalAvg"));
				//반별 시험별 석차 출력
				System.out.println("-------중간 석차-------");
				classRoom.printStudentProperties("midTerm");
				System.out.println("-------기말 석차-------");
				classRoom.printStudentProperties("final");
				//기말고사> 중간고사 출력
				System.out.println("------기말>중간 학생------");
				classRoom.printScoreIncrease();
				//반별   성적 향상률 석차 출력
				System.out.println("------성적향상률 석차------");
				classRoom.printStudentProperties("improvementRate");
			}
			
		}
		
		
		
	
	}

}

