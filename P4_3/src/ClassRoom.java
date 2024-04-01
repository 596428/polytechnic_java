import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassRoom {
	String name;
	private Map<String, Double> properties;
	List<Student> students = new ArrayList<>();

	
	
	ClassRoom(int studentNum, int classNum) {
		this.name = Integer.toString(classNum+1)+"반";
		this.properties = new HashMap<String, Double>();
		
		for (int i=0; i<studentNum; i++) {
			students.add(new Student(i));
		}
		double classMidSum = 0;
		double classFinalSum = 0;
		for (Student student : students) {
			classMidSum = classMidSum + student.getProperty("midTerm");
			classFinalSum = classFinalSum + student.getProperty("final");
		}

		properties.put("classMidSum",  (Math.round(classMidSum * 10.0) / 10.0));
		properties.put("classFinalSum", (Math.round(classFinalSum * 10.0) / 10.0));
		properties.put("classMidAvg", (Math.round(classMidSum / studentNum * 10.0) / 10.0));
		properties.put("classFinalAvg", (Math.round(classFinalSum / studentNum * 10.0) / 10.0));
		

	}
	
	public void printStudentProperties(String inputTxt) {
		students.sort(Comparator.comparing(Student -> Student.getProperty(inputTxt),Comparator.reverseOrder()));
		for (Student student : students) {
			System.out.println(student.name + " " + inputTxt + ": " + student.getProperty(inputTxt));
		}
	}
	
	
	// 학생1,학생2... 학생10, 학생11 이라서 단순 문자열 비교하면 의도한대로 정렬되지 않는 문제 있음
	public void printScoreIncrease() {
		Collections.sort(students, new Comparator<Student>() {
		    @Override
		    public int compare(Student s1, Student s2) {
		        return s1.getName().compareTo(s2.getName()); //문자열 비교할때랑 숫자열 비교할때 Comparator 작성을 고쳐줘야함
		        //return Integer.compare(d1.getValue(), d2.getValue());
		    }
		});
		// Comparator를 따로 생성하지 않고 람다식만으로는 문자열을 기준으로 정렬하는 것이 불가능
		//students.sort(Comparator.comparing(Student -> Student.getProperty("name"))); 작동 X
		for (Student student : students) {
			if (student.getProperty("final") > student.getProperty("midTerm")) {
				System.out.println(student.name + "   중간 " + student.getProperty("midTerm") + "-> 기말 " + student.getProperty("final"));
			}
		}
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void addProperty(String key, Double value) {
        properties.put(key, value);
    }
	
	public Double getProperty(String key) {
		 return properties.get(key);
	 }

}
