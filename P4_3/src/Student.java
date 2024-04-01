import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {
	String name;
	private Map<String, Double> properties;
	
	Student(int i) {
		Random random = new Random();
		// 이렇게 무식하게 학생01, 학생02... 하는 방법밖에 없는지?
		if(i>=0 && i<9) {
			this.name = "학생0" + Integer.toString(i+1);
		}else {
			this.name = "학생" + Integer.toString(i+1);
		}
		//생략하면 Cannot invoke "java.util.Map.put(Object, Object)" because "this.properties" is null 오류
		this.properties = new HashMap<String, Double>(); // properties 필드 초기화
		properties.put("midTerm", (Math.round(random.nextDouble(100) * 10.0) / 10.0));
		properties.put("final", (Math.round(random.nextDouble(100) * 10.0) / 10.0));
		// 성적 향상률(100-(finalExam-midtermExam))/100
		double temp = (100-(getProperty("midTerm") - getProperty("final"))) / 100;
		temp = (Math.round(temp * 10.0) / 100.0);
		properties.put("improvementRate", temp);
		
		
	}
	
	public String getName() {
		return name;
	}
		
	public void addProperty(String key, Double value) {
        properties.put(key, value);
    }
	
	public Double getProperty(String key) {
		 return properties.get(key);
	 }
	
	

}
